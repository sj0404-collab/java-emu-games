import { createServer } from 'node:http';
import { createReadStream, existsSync, statSync } from 'node:fs';
import { extname, join, normalize, resolve } from 'node:path';
import { randomUUID } from 'node:crypto';
import { fileURLToPath } from 'node:url';
import { LocalAIEngine } from './engine.js';
import { normalizeMessages } from '../shared/chat.js';

const PROJECT_ROOT = resolve(fileURLToPath(new URL('../..', import.meta.url)));
const DEFAULT_DIST = join(PROJECT_ROOT, 'dist');
const MAX_BODY_BYTES = 2 * 1024 * 1024;

export function createLocalAIServer(options = {}) {
  const engine = options.engine || new LocalAIEngine(options);
  const apiKey = options.apiKey || process.env.LOCAL_AI_API_KEY || '';
  const distDir = resolve(options.distDir || DEFAULT_DIST);
  const corsOrigin = options.corsOrigin || '*';

  const server = createServer(async (request, response) => {
    setCors(response, corsOrigin);

    if (request.method === 'OPTIONS') {
      response.writeHead(204);
      response.end();
      return;
    }

    const url = new URL(request.url || '/', 'http://localhost');

    try {
      if (url.pathname.startsWith('/v1/') && !isAuthorized(request, apiKey)) {
        sendJson(response, 401, apiError('Неверный API-ключ.', 'authentication_error'));
        return;
      }

      if (request.method === 'GET' && url.pathname === '/health') {
        sendJson(response, 200, {
          status: 'ok',
          ready: engine.loaded,
          model: engine.model.model,
          local: true,
        });
        return;
      }

      if (request.method === 'GET' && url.pathname === '/v1/models') {
        sendJson(response, 200, {
          object: 'list',
          data: [modelObject(engine.model.model)],
        });
        return;
      }

      if (request.method === 'POST' && url.pathname === '/v1/chat/completions') {
        const body = await readJson(request);
        await handleChat(response, body, engine);
        return;
      }

      if (request.method === 'GET' || request.method === 'HEAD') {
        if (serveStatic(request, response, url.pathname, distDir)) return;
      }

      sendJson(response, 404, apiError('Маршрут не найден.', 'not_found'));
    } catch (error) {
      if (!response.headersSent) {
        const status = error.statusCode || 500;
        sendJson(response, status, apiError(error.message || 'Ошибка сервера.'));
      } else if (!response.writableEnded) {
        writeSse(response, {
          error: { message: error.message || 'Ошибка генерации.', type: 'server_error' },
        });
        response.write('data: [DONE]\n\n');
        response.end();
      }
    }
  });

  server.on('close', () => engine.dispose?.());
  return { server, engine };
}

export async function listen(options = {}) {
  const host = options.host || '127.0.0.1';
  const port = Number(options.port ?? 3928);
  const instance = createLocalAIServer(options);

  await new Promise((resolveListen, reject) => {
    instance.server.once('error', reject);
    instance.server.listen(port, host, () => {
      instance.server.off('error', reject);
      resolveListen();
    });
  });

  const address = instance.server.address();
  return {
    ...instance,
    host,
    port: typeof address === 'object' && address ? address.port : port,
  };
}

async function handleChat(response, body, engine) {
  const messages = normalizeMessages(body.messages, body.system_prompt);
  const id = `chatcmpl-${randomUUID().replaceAll('-', '')}`;
  const created = Math.floor(Date.now() / 1000);
  const model = engine.model.model;
  const options = {
    max_tokens: body.max_tokens,
    temperature: body.temperature,
    top_p: body.top_p,
    repetition_penalty: body.repetition_penalty,
  };

  if (body.stream) {
    response.writeHead(200, {
      'Content-Type': 'text/event-stream; charset=utf-8',
      'Cache-Control': 'no-cache, no-transform',
      Connection: 'keep-alive',
      'X-Accel-Buffering': 'no',
    });
    response.flushHeaders?.();

    writeSse(response, completionChunk(id, created, model, { role: 'assistant' }));
    const result = await engine.generate(messages, options, (token) => {
      if (!response.destroyed) {
        writeSse(response, completionChunk(id, created, model, { content: token }));
      }
    });

    if (!response.destroyed) {
      writeSse(response, completionChunk(id, created, model, {}, 'stop'));
      response.write('data: [DONE]\n\n');
      response.end();
    }
    return result;
  }

  const result = await engine.generate(messages, options);
  sendJson(response, 200, {
    id,
    object: 'chat.completion',
    created,
    model,
    choices: [
      {
        index: 0,
        message: { role: 'assistant', content: result.text },
        finish_reason: 'stop',
      },
    ],
    usage: null,
    local_ai: { elapsed_ms: Math.round(result.elapsedMs) },
  });
}

function completionChunk(id, created, model, delta, finishReason = null) {
  return {
    id,
    object: 'chat.completion.chunk',
    created,
    model,
    choices: [{ index: 0, delta, finish_reason: finishReason }],
  };
}

function modelObject(id) {
  return {
    id,
    object: 'model',
    created: 0,
    owned_by: 'local-ai',
  };
}

function apiError(message, type = 'server_error') {
  return { error: { message, type, param: null, code: null } };
}

function isAuthorized(request, apiKey) {
  if (!apiKey) return true;
  return request.headers.authorization === `Bearer ${apiKey}`;
}

function setCors(response, origin) {
  response.setHeader('Access-Control-Allow-Origin', origin);
  response.setHeader('Access-Control-Allow-Headers', 'Authorization, Content-Type');
  response.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
}

async function readJson(request) {
  const chunks = [];
  let bytes = 0;

  for await (const chunk of request) {
    bytes += chunk.length;
    if (bytes > MAX_BODY_BYTES) {
      const error = new Error('Запрос больше 2 МБ.');
      error.statusCode = 413;
      throw error;
    }
    chunks.push(chunk);
  }

  try {
    return JSON.parse(Buffer.concat(chunks).toString('utf8') || '{}');
  } catch {
    const error = new Error('Тело запроса должно быть валидным JSON.');
    error.statusCode = 400;
    throw error;
  }
}

function sendJson(response, status, value) {
  const body = JSON.stringify(value);
  response.writeHead(status, {
    'Content-Type': 'application/json; charset=utf-8',
    'Content-Length': Buffer.byteLength(body),
  });
  response.end(body);
}

function writeSse(response, value) {
  response.write(`data: ${JSON.stringify(value)}\n\n`);
}

function serveStatic(request, response, pathname, distDir) {
  if (!existsSync(distDir)) return false;

  const requested = pathname === '/' ? 'index.html' : pathname.slice(1);
  const safePath = normalize(requested).replace(/^(\.\.(\/|\\|$))+/, '');
  let filePath = join(distDir, safePath);

  if (!filePath.startsWith(distDir)) return false;
  if (!existsSync(filePath) || !statSync(filePath).isFile()) {
    if (extname(pathname)) return false;
    filePath = join(distDir, 'index.html');
  }

  const headers = {
    'Content-Type': mimeType(filePath),
    'Cache-Control': filePath.endsWith('index.html')
      ? 'no-cache'
      : 'public, max-age=31536000, immutable',
  };
  response.writeHead(200, headers);
  if (request.method === 'HEAD') response.end();
  else createReadStream(filePath).pipe(response);
  return true;
}

function mimeType(path) {
  const types = {
    '.css': 'text/css; charset=utf-8',
    '.html': 'text/html; charset=utf-8',
    '.ico': 'image/x-icon',
    '.js': 'text/javascript; charset=utf-8',
    '.json': 'application/json; charset=utf-8',
    '.mjs': 'text/javascript; charset=utf-8',
    '.png': 'image/png',
    '.svg': 'image/svg+xml',
    '.wasm': 'application/wasm',
    '.webmanifest': 'application/manifest+json',
  };
  return types[extname(path)] || 'application/octet-stream';
}

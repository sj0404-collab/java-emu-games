import test from 'node:test';
import assert from 'node:assert/strict';
import { listen } from '../src/node/server.js';

function fakeEngine() {
  return {
    loaded: true,
    model: { model: 'test/local-model' },
    disposed: false,
    async generate(messages, options, onToken = () => {}) {
      assert.ok(messages.some((message) => message.role === 'user'));
      assert.equal(options.max_tokens, 12);
      onToken('локальный ');
      onToken('ответ');
      return { text: 'локальный ответ', elapsedMs: 12.7 };
    },
    async dispose() {
      this.disposed = true;
    },
  };
}

async function start(t, options = {}) {
  const engine = options.engine || fakeEngine();
  const instance = await listen({
    host: '127.0.0.1',
    port: 0,
    distDir: '/definitely/not/a/build',
    engine,
    ...options,
  });
  const base = `http://127.0.0.1:${instance.port}`;
  t.after(async () => {
    await new Promise((resolve) => instance.server.close(resolve));
  });
  return { ...instance, base };
}


test('health and models endpoints expose only local metadata', async (t) => {
  const { base } = await start(t);
  const health = await fetch(`${base}/health`).then((response) => response.json());
  assert.deepEqual(health, {
    status: 'ok',
    ready: true,
    model: 'test/local-model',
    local: true,
  });

  const models = await fetch(`${base}/v1/models`).then((response) => response.json());
  assert.equal(models.object, 'list');
  assert.equal(models.data[0].id, 'test/local-model');
});


test('chat completion has an OpenAI-compatible non-stream response', async (t) => {
  const { base } = await start(t);
  const response = await fetch(`${base}/v1/chat/completions`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      messages: [{ role: 'user', content: 'Привет' }],
      max_tokens: 12,
    }),
  });
  assert.equal(response.status, 200);
  assert.match(response.headers.get('content-type'), /application\/json/);
  const data = await response.json();
  assert.equal(data.object, 'chat.completion');
  assert.equal(data.model, 'test/local-model');
  assert.equal(data.choices[0].message.content, 'локальный ответ');
  assert.equal(data.local_ai.elapsed_ms, 13);
});


test('streaming chat completion emits SSE chunks and DONE', async (t) => {
  const { base } = await start(t);
  const response = await fetch(`${base}/v1/chat/completions`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      messages: [{ role: 'user', content: 'Привет' }],
      max_tokens: 12,
      stream: true,
    }),
  });
  const body = await response.text();
  assert.equal(response.status, 200);
  assert.match(response.headers.get('content-type'), /text\/event-stream/);
  assert.match(body, /"role":"assistant"/);
  assert.match(body, /"content":"локальный "/);
  assert.match(body, /"finish_reason":"stop"/);
  assert.match(body, /data: \[DONE\]/);
});


test('API key and malformed JSON are rejected', async (t) => {
  const { base } = await start(t, { apiKey: 'secret' });
  const unauthorized = await fetch(`${base}/v1/models`);
  assert.equal(unauthorized.status, 401);

  const malformed = await fetch(`${base}/v1/chat/completions`, {
    method: 'POST',
    headers: {
      Authorization: 'Bearer secret',
      'Content-Type': 'application/json',
    },
    body: '{broken',
  });
  assert.equal(malformed.status, 400);
  const data = await malformed.json();
  assert.match(data.error.message, /JSON/);
});

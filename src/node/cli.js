#!/usr/bin/env node

import { createInterface } from 'node:readline/promises';
import { stdin, stdout, stderr } from 'node:process';
import { LocalAIEngine } from './engine.js';
import { listen } from './server.js';
import {
  DEFAULT_SYSTEM_PROMPT,
  MODEL_PRESETS,
  resolveModel,
} from '../shared/models.js';
import {
  PROFILE_PRESETS,
  profileSystemPrompt,
  profileTemperature,
} from '../shared/profiles.js';

const VERSION = '0.1.0';
const KNOWN_COMMANDS = new Set(['chat', 'serve', 'download', 'models', 'help']);

main().catch((error) => {
  clearProgress();
  stderr.write(`\nОшибка: ${friendlyError(error)}\n`);
  process.exitCode = 1;
});

async function main() {
  const parsed = parseArguments(process.argv.slice(2));
  const command = parsed.command;
  const options = parsed.options;
  if (options.profile && !PROFILE_PRESETS.some((profile) => profile.id === options.profile)) {
    throw new Error(`Неизвестный профиль: ${options.profile}`);
  }

  if (options.version) {
    stdout.write(`${VERSION}\n`);
    return;
  }
  if (options.help || command === 'help') {
    stdout.write(helpText());
    return;
  }
  if (command === 'models') {
    printModels();
    return;
  }

  if (command === 'serve') {
    await runServer(options);
    return;
  }

  const engine = makeEngine(options);
  if (command === 'download') {
    stderr.write(`Загружаю ${engine.model.label} (${engine.dtype})…\n`);
    await engine.load();
    clearProgress();
    stdout.write(`Готово. Модель сохранена в ${engine.cacheDir}\n`);
    await engine.dispose();
    return;
  }

  const prompt = parsed.positionals.join(' ').trim();
  if (prompt) await oneShot(engine, prompt, options);
  else await interactiveChat(engine, options);
  await engine.dispose();
}

function makeEngine(options) {
  return new LocalAIEngine({
    model: options.model || 'phone',
    dtype: options.dtype,
    device: options.device || 'cpu',
    cacheDir: options.cache,
    localModelPath: options.localModels,
    offline: options.offline,
    threads: options.threads,
    onProgress: progressReporter(),
  });
}

async function oneShot(engine, prompt, options) {
  const selectedProfile = options.profile || (options.system ? 'custom' : 'auto');
  const messages = [
    { role: 'system', content: systemPromptFor(selectedProfile, prompt, options.system) },
    { role: 'user', content: prompt },
  ];
  let streamed = '';
  const result = await engine.generate(messages, generationFrom(options, selectedProfile, prompt), (token) => {
    if (!options.json) {
      clearProgress();
      stdout.write(token);
      streamed += token;
    }
  });
  clearProgress();

  if (options.json) {
    stdout.write(`${JSON.stringify({
      model: result.model,
      message: { role: 'assistant', content: result.text },
      elapsed_ms: Math.round(result.elapsedMs),
    }, null, 2)}\n`);
  } else {
    if (!streamed && result.text) stdout.write(result.text);
    stdout.write('\n');
  }
}

async function interactiveChat(engine, options) {
  const rl = createInterface({ input: stdin, output: stdout });
  let selectedProfile = options.profile || (options.system ? 'custom' : 'auto');
  let customSystem = options.system || DEFAULT_SYSTEM_PROMPT;
  let messages = [{ role: 'system', content: systemPromptFor(selectedProfile, '', options.system) }];

  stdout.write('\nЛокальный AI · данные остаются на устройстве\n');
  stdout.write(`Модель: ${engine.model.label} · ${engine.dtype} · ${engine.device}\n`);
  stdout.write(`Профиль: ${selectedProfile}\n`);
  stdout.write('Команды: /reset, /profile имя, /system текст, /save файл.json, /help, /exit\n\n');

  try {
    while (true) {
      const input = (await rl.question('\x1b[36mВы ›\x1b[0m ')).trim();
      if (!input) continue;

      if (input === '/exit' || input === '/quit') break;
      if (input === '/help') {
        stdout.write('  /reset — очистить историю\n  /profile auto|general|coding|rpg|creative|analysis|custom\n  /system ТЕКСТ — включить свою системную инструкцию и очистить историю\n  /save ФАЙЛ — сохранить диалог\n  /exit — выйти\n');
        continue;
      }
      if (input === '/reset') {
        messages = [{ role: 'system', content: systemPromptFor(selectedProfile, '', customSystem) }];
        stdout.write('История очищена.\n');
        continue;
      }
      if (input.startsWith('/profile ')) {
        const requested = input.slice(9).trim().toLowerCase();
        if (!PROFILE_PRESETS.some((profile) => profile.id === requested)) {
          stdout.write('Неизвестный профиль. Доступны: auto, general, coding, rpg, creative, analysis, custom.\n');
          continue;
        }
        selectedProfile = requested;
        messages = [{ role: 'system', content: systemPromptFor(selectedProfile, '', customSystem) }];
        stdout.write(`Профиль ${selectedProfile}; история очищена.\n`);
        continue;
      }
      if (input.startsWith('/system ')) {
        customSystem = input.slice(8).trim();
        selectedProfile = 'custom';
        messages = [{ role: 'system', content: customSystem }];
        stdout.write('Своя системная инструкция включена; история очищена.\n');
        continue;
      }
      if (input.startsWith('/save ')) {
        const { writeFile } = await import('node:fs/promises');
        const path = input.slice(6).trim();
        await writeFile(path, `${JSON.stringify(messages, null, 2)}\n`, 'utf8');
        stdout.write(`Сохранено: ${path}\n`);
        continue;
      }
      if (input.startsWith('/')) {
        stdout.write('Неизвестная команда. Введите /help.\n');
        continue;
      }

      messages[0] = {
        role: 'system',
        content: systemPromptFor(selectedProfile, input, customSystem),
      };
      messages.push({ role: 'user', content: input });
      stdout.write('\x1b[35mAI  ›\x1b[0m ');
      let streamed = '';
      try {
        const result = await engine.generate(messages, generationFrom(options, selectedProfile, input), (token) => {
          clearProgress();
          stdout.write(token);
          streamed += token;
        });
        if (!streamed && result.text) stdout.write(result.text);
        stdout.write(`\n\x1b[2m${(result.elapsedMs / 1000).toFixed(1)} с\x1b[0m\n\n`);
        messages.push({ role: 'assistant', content: result.text || streamed });
      } catch (error) {
        clearProgress();
        stdout.write(`\nОшибка: ${friendlyError(error)}\n\n`);
        messages.pop();
      }
    }
  } finally {
    rl.close();
  }
}

async function runServer(options) {
  const apiKey = options.apiKey || process.env.LOCAL_AI_API_KEY || '';
  const instance = await listen({
    model: options.model || 'phone',
    dtype: options.dtype,
    device: options.device || 'cpu',
    cacheDir: options.cache,
    localModelPath: options.localModels,
    offline: options.offline,
    threads: options.threads,
    host: options.host || '127.0.0.1',
    port: options.port || 3928,
    apiKey,
    corsOrigin: options.cors || '*',
    onProgress: progressReporter(),
  });

  const shownHost = instance.host === '0.0.0.0' ? 'localhost' : instance.host;
  stdout.write('Локальный AI API запущен\n');
  stdout.write(`  Web:    http://${shownHost}:${instance.port}/\n`);
  stdout.write(`  API:    http://${shownHost}:${instance.port}/v1\n`);
  stdout.write(`  Модель: ${instance.engine.model.model}\n`);
  if (apiKey) {
    stdout.write('  Доступ: защищён Bearer-ключом\n');
  } else {
    stdout.write('  Доступ: без ключа (не открывайте порт в интернет)\n');
  }
  if (options.preload) {
    stderr.write('Загружаю модель…\n');
    await instance.engine.load();
    clearProgress();
    stdout.write('Модель готова.\n');
  }

  const stop = async () => {
    stdout.write('\nОстанавливаю…\n');
    await new Promise((resolveClose) => instance.server.close(resolveClose));
  };
  process.once('SIGINT', stop);
  process.once('SIGTERM', stop);
}

function systemPromptFor(profile, prompt, customSystem) {
  if (profile === 'custom' && customSystem) return customSystem;
  return profileSystemPrompt(profile || 'auto', prompt, customSystem || DEFAULT_SYSTEM_PROMPT);
}

function generationFrom(options, profile = 'auto', prompt = '') {
  return {
    maxNewTokens: options.maxTokens || 256,
    temperature: options.temperature ?? profileTemperature(profile, prompt),
    topP: options.topP ?? 0.9,
    repetitionPenalty: options.repetitionPenalty ?? 1.05,
  };
}

function printModels() {
  stdout.write('Встроенные модели:\n\n');
  for (const model of MODEL_PRESETS) {
    stdout.write(`${model.id.padEnd(9)} ${model.label}\n`);
    stdout.write(`          ${model.model}\n`);
    stdout.write(`          ${model.download}, RAM ${model.ram}, ${model.description}\n\n`);
  }
  stdout.write('Можно передать любой Hugging Face repo с ONNX: --model owner/model\n');
}

function parseArguments(argv) {
  let command = 'chat';
  const args = [...argv];
  if (args[0] && KNOWN_COMMANDS.has(args[0])) command = args.shift();

  const options = {};
  const positionals = [];
  const aliases = {
    '-h': 'help',
    '-V': 'version',
    '-m': 'model',
    '-n': 'maxTokens',
    '-t': 'temperature',
    '-s': 'system',
    '-p': 'port',
  };
  const booleans = new Set(['help', 'version', 'offline', 'json', 'preload']);

  for (let index = 0; index < args.length; index += 1) {
    const argument = args[index];
    if (argument === '--') {
      positionals.push(...args.slice(index + 1));
      break;
    }
    if (!argument.startsWith('-')) {
      positionals.push(argument);
      continue;
    }

    const [rawName, inlineValue] = argument.split(/=(.*)/s, 2);
    const longName = rawName.startsWith('--')
      ? toCamelCase(rawName.slice(2))
      : aliases[rawName];
    if (!longName) throw new Error(`Неизвестный параметр: ${argument}`);

    if (booleans.has(longName)) {
      options[longName] = inlineValue == null ? true : inlineValue !== 'false';
      continue;
    }

    const value = inlineValue ?? args[++index];
    if (value == null || value.startsWith('--')) {
      throw new Error(`Параметру ${rawName} нужно значение.`);
    }
    options[longName] = value;
  }

  return { command, options, positionals };
}

function toCamelCase(name) {
  return name.replace(/-([a-z])/g, (_, letter) => letter.toUpperCase());
}

function progressReporter() {
  let lastText = '';
  return (event) => {
    if (!event) return;
    const file = event.file ? String(event.file).split('/').at(-1) : 'модель';
    const percent = Number.isFinite(event.progress)
      ? `${Math.round(event.progress)}%`
      : event.loaded && event.total
        ? `${Math.round((event.loaded / event.total) * 100)}%`
        : '';
    const text = event.status === 'progress'
      ? `Загрузка ${file} ${percent}`.trim()
      : event.status === 'ready'
        ? 'Модель готова'
        : '';
    if (!text || text === lastText) return;
    lastText = text;
    if (stderr.isTTY) stderr.write(`\r\x1b[2K${text}`);
  };
}

function clearProgress() {
  if (stderr.isTTY) stderr.write('\r\x1b[2K');
}

function friendlyError(error) {
  const text = error?.message || String(error);
  if (/local files|not found|404/i.test(text)) {
    return `${text}\nПодключитесь к интернету для первой загрузки или отключите --offline.`;
  }
  if (/memory|allocation|out of bounds/i.test(text)) {
    return `${text}\nНе хватает памяти: выберите --model mini или уменьшите --max-tokens.`;
  }
  return text;
}

function helpText() {
  return `
Локальный AI ${VERSION} — ONNX-ассистент без облачного API

Использование:
  local-ai [chat] [текст] [параметры]   Диалог или один запрос
  local-ai download [параметры]        Скачать модель для офлайна
  local-ai serve [параметры]           OpenAI-совместимый HTTP API
  local-ai models                      Показать модели

Основные параметры:
  -m, --model <id>          phone | mini | quality | coder | owner/model
      --dtype <тип>         q4f16, q4, q8, fp16 (по умолчанию из пресета)
      --device <устройство> cpu (Node.js; для Termux см. scripts/)
      --cache <путь>        Кэш моделей (по умолчанию .local-ai/cache)
      --local-models <путь> Каталог самостоятельно скачанных ONNX-моделей
      --offline             Запретить сетевые загрузки
      --threads <число>     Потоки CPU
  -n, --max-tokens <число> Максимум новых токенов (256)
      --profile <имя>       auto | general | coding | rpg | creative | analysis | custom
  -t, --temperature <0..2> Температура (иначе preset выбранного профиля)
  -s, --system <текст>      Своя системная инструкция (включает custom без --profile)
      --json                JSON-ответ в одноразовом режиме

Параметры сервера:
      --host <адрес>        127.0.0.1 (0.0.0.0 для локальной сети)
  -p, --port <порт>         3928
      --api-key <ключ>      Защитить /v1/* Bearer-ключом
      --cors <origin>       CORS origin (по умолчанию *)
      --preload             Загрузить модель до приёма запросов

Примеры:
  local-ai "Объясни квантование простыми словами"
  local-ai chat --model mini --offline
  local-ai download --model phone
  local-ai serve --model phone --port 3928
`;
}

// Validate custom model names early when this module is run directly.
void resolveModel;

import {
  env,
  InterruptableStoppingCriteria,
  pipeline,
  TextStreamer,
} from '@huggingface/transformers';
import { dtypeForDevice, resolveModel } from '../shared/models.js';
import {
  extractAssistantText,
  generationOptions,
  normalizeMessages,
} from '../shared/chat.js';

let generator = null;
let loadedConfig = null;
let loading = null;
let stoppingCriteria = null;
let operation = Promise.resolve();

env.allowLocalModels = false;
env.allowRemoteModels = true;
env.useBrowserCache = true;
env.useWasmCache = true;
if (env.backends?.onnx?.wasm) env.backends.onnx.wasm.proxy = false;

self.addEventListener('message', ({ data }) => {
  if (data?.type === 'stop') {
    stoppingCriteria?.interrupt();
    return;
  }
  if (data?.type === 'load') enqueue(() => load(data.payload));
  if (data?.type === 'generate') enqueue(() => generate(data.payload));
  if (data?.type === 'dispose') {
    stoppingCriteria?.interrupt();
    enqueue(dispose);
  }
});

function enqueue(task) {
  operation = operation.then(task).catch(postError);
}

async function load(payload = {}) {
  if (loading) return loading;
  const preset = resolveModel(payload.model || 'phone', payload.dtype);
  const requestedDevice = payload.device || 'auto';
  const preferredDevice = requestedDevice === 'auto'
    ? (self.navigator?.gpu ? 'webgpu' : 'wasm')
    : requestedDevice;
  const key = `${preset.model}:${payload.dtype || 'auto'}:${preferredDevice}`;

  if (generator && loadedConfig?.key === key) {
    postMessage({ type: 'ready', payload: loadedConfig });
    return generator;
  }

  loading = (async () => {
    await dispose();
    postMessage({
      type: 'status',
      payload: { state: 'loading', message: `Подготовка ${preset.label}` },
    });

    try {
      generator = await createPipeline(preset, preferredDevice, payload.dtype);
      loadedConfig = {
        key,
        model: preset.model,
        label: preset.label,
        device: preferredDevice,
        dtype: payload.dtype || dtypeForDevice(preset, preferredDevice),
      };
    } catch (error) {
      if (requestedDevice !== 'auto' || preferredDevice !== 'webgpu') throw error;
      postMessage({
        type: 'status',
        payload: {
          state: 'fallback',
          message: 'WebGPU недоступен — переключаюсь на CPU / WASM',
        },
      });
      await generator?.dispose?.();
      generator = await createPipeline(preset, 'wasm', payload.dtype);
      loadedConfig = {
        key: `${preset.model}:${payload.dtype || 'auto'}:wasm`,
        model: preset.model,
        label: preset.label,
        device: 'wasm',
        dtype: payload.dtype || dtypeForDevice(preset, 'wasm'),
      };
    }

    postMessage({ type: 'ready', payload: loadedConfig });
    return generator;
  })();

  try {
    return await loading;
  } catch (error) {
    try {
      await dispose();
    } catch {
      // Preserve the original loading error.
    }
    throw error;
  } finally {
    loading = null;
  }
}

async function createPipeline(preset, device, requestedDtype) {
  const dtype = requestedDtype || dtypeForDevice(preset, device);
  return pipeline('text-generation', preset.model, {
    device,
    dtype,
    progress_callback: (event) => {
      const payload = {
        status: event.status,
        file: event.file,
        progress: finite(event.progress),
        loaded: finite(event.loaded),
        total: finite(event.total),
      };
      postMessage({ type: 'progress', payload });
    },
  });
}

async function generate(payload = {}) {
  if (!generator) {
    postError(new Error('Сначала загрузите модель.'));
    return;
  }

  try {
    const messages = normalizeMessages(payload.messages, payload.systemPrompt);
    stoppingCriteria = new InterruptableStoppingCriteria();
    const streamer = new TextStreamer(generator.tokenizer, {
      skip_prompt: true,
      skip_special_tokens: true,
      callback_function: (token) => postMessage({ type: 'token', payload: token }),
    });
    const startedAt = performance.now();
    const output = await generator(messages, {
      ...generationOptions(payload),
      streamer,
      stopping_criteria: stoppingCriteria,
    });
    const text = extractAssistantText(output);
    postMessage({
      type: 'result',
      payload: {
        text,
        elapsedMs: performance.now() - startedAt,
        interrupted: Boolean(stoppingCriteria?.interrupted),
      },
    });
  } finally {
    stoppingCriteria = null;
  }
}

async function dispose() {
  stoppingCriteria?.interrupt();
  await generator?.dispose?.();
  generator = null;
  loadedConfig = null;
}

function postError(error) {
  postMessage({
    type: 'error',
    payload: {
      message: friendlyError(error),
      stack: import.meta.env?.DEV ? error?.stack : undefined,
    },
  });
}

function friendlyError(error) {
  const message = error?.message || String(error);
  if (/memory|allocation|out of bounds/i.test(message)) {
    return 'Не хватает памяти. Закройте другие вкладки или выберите SmolLM2 360M.';
  }
  if (/fetch|network|failed to load|404/i.test(message)) {
    return 'Не удалось получить модель. Для первой загрузки нужен интернет; затем модель работает из кэша.';
  }
  return message;
}

function finite(value) {
  return Number.isFinite(value) ? Number(value) : undefined;
}

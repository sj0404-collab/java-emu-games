import { resolve } from 'node:path';
import { availableParallelism } from 'node:os';
import { dtypeForDevice, resolveModel } from '../shared/models.js';
import {
  extractAssistantText,
  generationOptions,
  normalizeMessages,
} from '../shared/chat.js';

export class LocalAIEngine {
  #pipeline = null;
  #loading = null;
  #queue = Promise.resolve();
  #transformers = null;

  constructor(options = {}) {
    this.model = resolveModel(options.model, options.dtype);
    this.device = options.device || 'cpu';
    this.dtype = options.dtype || dtypeForDevice(this.model, this.device);
    this.offline = Boolean(options.offline);
    this.cacheDir = resolve(
      options.cacheDir || process.env.LOCAL_AI_CACHE || '.local-ai/cache',
    );
    this.localModelPath = options.localModelPath
      ? resolve(options.localModelPath)
      : null;
    this.threads = positiveInteger(
      options.threads || process.env.LOCAL_AI_THREADS,
      availableParallelism(),
    );
    this.onProgress = options.onProgress || (() => {});
  }

  get loaded() {
    return Boolean(this.#pipeline);
  }

  async load() {
    if (this.#pipeline) return this.#pipeline;
    if (this.#loading) return this.#loading;

    this.#loading = this.#loadPipeline();
    try {
      this.#pipeline = await this.#loading;
      return this.#pipeline;
    } finally {
      this.#loading = null;
    }
  }

  async #loadPipeline() {
    const transformers = await import('@huggingface/transformers');
    this.#transformers = transformers;
    const { env, pipeline } = transformers;

    env.cacheDir = this.cacheDir;
    env.useFSCache = true;
    env.allowRemoteModels = !this.offline;
    env.allowLocalModels = true;
    if (this.localModelPath) env.localModelPath = `${this.localModelPath}/`;

    return pipeline('text-generation', this.model.model, {
      device: this.device,
      dtype: this.dtype,
      local_files_only: this.offline,
      progress_callback: this.onProgress,
      session_options: {
        intra_op_num_threads: this.threads,
        inter_op_num_threads: 1,
      },
    });
  }

  generate(messages, options = {}, onToken = () => {}) {
    const job = this.#queue.then(async () => {
      const generator = await this.load();
      const cleanMessages = normalizeMessages(messages, options.systemPrompt);
      const streamer = new this.#transformers.TextStreamer(generator.tokenizer, {
        skip_prompt: true,
        skip_special_tokens: true,
        callback_function: onToken,
      });

      const startedAt = performance.now();
      const output = await generator(cleanMessages, {
        ...generationOptions(options),
        streamer,
      });
      const text = extractAssistantText(output);

      return {
        text,
        output,
        elapsedMs: performance.now() - startedAt,
        model: this.model.model,
      };
    });

    this.#queue = job.catch(() => {});
    return job;
  }

  async dispose() {
    await this.#loading?.catch(() => {});
    await this.#pipeline?.dispose?.();
    this.#pipeline = null;
  }
}

function positiveInteger(value, fallback) {
  const parsed = Number.parseInt(value, 10);
  return Number.isFinite(parsed) && parsed > 0 ? parsed : fallback;
}

import { DEFAULT_SYSTEM_PROMPT } from './models.js';

const VALID_ROLES = new Set(['system', 'user', 'assistant']);

export function normalizeMessages(messages, systemPrompt = DEFAULT_SYSTEM_PROMPT) {
  if (!Array.isArray(messages)) {
    throw new TypeError('messages должен быть массивом.');
  }

  const clean = messages
    .filter((message) => message && VALID_ROLES.has(message.role))
    .map((message) => ({
      role: message.role,
      content: String(message.content ?? '').trim(),
    }))
    .filter((message) => message.content.length > 0);

  if (!clean.some((message) => message.role === 'system') && systemPrompt) {
    clean.unshift({ role: 'system', content: String(systemPrompt).trim() });
  }

  if (!clean.some((message) => message.role === 'user')) {
    throw new TypeError('Добавьте хотя бы одно сообщение пользователя.');
  }

  return clean;
}

export function extractAssistantText(output) {
  const generated = output?.[0]?.generated_text;

  if (Array.isArray(generated)) {
    const assistant = [...generated]
      .reverse()
      .find((message) => message?.role === 'assistant');
    if (assistant?.content != null) return String(assistant.content).trim();
  }

  if (typeof generated === 'string') return generated.trim();
  if (typeof output?.generated_text === 'string') {
    return output.generated_text.trim();
  }

  return '';
}

export function generationOptions(options = {}) {
  const maxNewTokens = clampInteger(options.maxNewTokens ?? options.max_tokens, 1, 2048, 256);
  const temperature = clampNumber(options.temperature, 0, 2, 0.7);
  const topP = clampNumber(options.topP ?? options.top_p, 0.01, 1, 0.9);

  return {
    max_new_tokens: maxNewTokens,
    temperature: temperature || 1,
    top_p: topP,
    do_sample: temperature > 0,
    repetition_penalty: clampNumber(
      options.repetitionPenalty ?? options.repetition_penalty,
      0.5,
      2,
      1.05,
    ),
  };
}

function clampInteger(value, min, max, fallback) {
  const number = Number.parseInt(value, 10);
  return Number.isFinite(number) ? Math.min(max, Math.max(min, number)) : fallback;
}

function clampNumber(value, min, max, fallback) {
  const number = Number(value);
  return Number.isFinite(number) ? Math.min(max, Math.max(min, number)) : fallback;
}

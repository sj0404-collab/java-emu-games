export const DEFAULT_SYSTEM_PROMPT =
  'Ты полезный локальный ассистент. Отвечай точно, кратко и на языке пользователя. Если не знаешь ответ, честно скажи об этом.';

/**
 * Model files are fetched once and cached by Transformers.js. Sizes are rough
 * download estimates for the listed dtype; tokenizer files add a few MB.
 */
export const MODEL_PRESETS = Object.freeze([
  {
    id: 'phone',
    label: 'Qwen3 0.6B · телефон',
    model: 'onnx-community/Qwen3-0.6B-ONNX',
    params: '0.6B',
    dtype: 'q4f16',
    cpuDtype: 'q4',
    download: '≈570 МБ',
    ram: 'от 2 ГБ',
    description: 'Многоязычный баланс скорости и качества',
  },
  {
    id: 'mini',
    label: 'SmolLM2 360M · слабый телефон',
    model: 'HuggingFaceTB/SmolLM2-360M-Instruct',
    params: '360M',
    dtype: 'q4f16',
    cpuDtype: 'q4',
    download: '≈273 МБ',
    ram: 'от 1 ГБ',
    description: 'Самый лёгкий, лучше отвечает по-английски',
  },
  {
    id: 'quality',
    label: 'Qwen3 1.7B · качество',
    model: 'onnx-community/Qwen3-1.7B-ONNX',
    params: '1.7B',
    dtype: 'q4f16',
    cpuDtype: 'q4',
    download: '≈1.3 ГБ',
    ram: 'от 4 ГБ',
    description: 'Лучше рассуждает, требует современный телефон или ПК',
  },
  {
    id: 'coder',
    label: 'Qwen2.5 Coder 0.5B · код',
    model: 'onnx-community/Qwen2.5-Coder-0.5B-Instruct',
    params: '0.5B',
    dtype: 'q4f16',
    cpuDtype: 'q4',
    download: '≈555 МБ',
    ram: 'от 2 ГБ',
    description: 'Компактная модель для программирования',
  },
]);

export const DEFAULT_PRESET = MODEL_PRESETS[0];

export function findPreset(value = 'phone') {
  return MODEL_PRESETS.find(
    (preset) => preset.id === value || preset.model === value,
  );
}

export function resolveModel(value = 'phone', dtype) {
  const preset = findPreset(value);
  if (preset) {
    return { ...preset, dtype: dtype || preset.dtype };
  }

  if (typeof value !== 'string' || !value.trim()) {
    throw new TypeError('Название модели не может быть пустым.');
  }

  return {
    id: 'custom',
    label: value.trim(),
    model: value.trim(),
    params: '—',
    dtype: dtype || 'q4',
    cpuDtype: dtype || 'q4',
    download: 'зависит от модели',
    ram: 'зависит от модели',
    description: 'Пользовательская ONNX-модель Hugging Face',
  };
}

export function dtypeForDevice(model, device) {
  if (device === 'webgpu') return model.dtype;
  return model.cpuDtype || model.dtype;
}

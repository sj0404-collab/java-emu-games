import './styles.css';
import {
  DEFAULT_SYSTEM_PROMPT,
  findPreset,
  MODEL_PRESETS,
  resolveModel,
} from '../shared/models.js';
import {
  profileSystemPrompt,
  profileTemperature,
} from '../shared/profiles.js';

const STORAGE_KEY = 'local-ai-phone:v1';
const worker = new Worker(new URL('./ai.worker.js', import.meta.url), { type: 'module' });
const elements = collectElements();
const state = {
  loaded: false,
  loading: false,
  generating: false,
  settings: {
    model: 'phone',
    customModel: '',
    device: 'auto',
    dtype: '',
    profile: 'auto',
    temperature: 0.7,
    maxTokens: 256,
    systemPrompt: DEFAULT_SYSTEM_PROMPT,
  },
  messages: [],
  loadedSignature: '',
};
let installPrompt = null;
let toastTimer = null;

restoreState();
bindEvents();
syncSettingsForm();
renderModelDetails();
renderMessages();
setRuntime('idle', navigator.onLine ? 'Модель не загружена' : 'Офлайн · нужен кэш модели');
registerServiceWorker();

worker.addEventListener('message', ({ data }) => {
  const { type, payload } = data || {};

  if (type === 'status') {
    state.loading = true;
    showProgress(payload?.message || 'Подготовка модели…', 0);
    setRuntime('busy', payload?.message || 'Подготовка модели…');
  }

  if (type === 'progress') updateProgress(payload);

  if (type === 'ready') {
    state.loaded = true;
    state.loading = false;
    state.loadedSignature = settingsSignature();
    elements.loadProgress.hidden = true;
    elements.loadModelButton.disabled = false;
    elements.loadModelButton.querySelector('span').textContent = 'Модель готова';
    elements.prompt.disabled = false;
    elements.prompt.focus();
    setRuntime('ready', `${payload.label} · ${String(payload.device).toUpperCase()}`);
    syncControls();
    updateWelcomeVisibility();
    showToast('Модель загружена. Теперь запросы обрабатываются локально.');
  }

  if (type === 'token') appendToken(String(payload || ''));

  if (type === 'result') finishGeneration(payload || {});

  if (type === 'error') handleWorkerError(payload?.message || 'Неизвестная ошибка модели.');
});

worker.addEventListener('error', (event) => {
  handleWorkerError(event.message || 'Ошибка Web Worker.');
});

function bindEvents() {
  elements.loadModelButton.addEventListener('click', loadModel);
  elements.composer.addEventListener('submit', submitPrompt);
  elements.prompt.addEventListener('input', () => {
    autoResizePrompt();
    syncControls();
  });
  elements.prompt.addEventListener('keydown', (event) => {
    if (event.key === 'Enter' && !event.shiftKey && !event.isComposing) {
      event.preventDefault();
      elements.composer.requestSubmit();
    }
  });
  elements.stopButton.addEventListener('click', () => worker.postMessage({ type: 'stop' }));
  elements.clearButton.addEventListener('click', clearConversation);

  for (const button of document.querySelectorAll('.starter')) {
    button.addEventListener('click', async () => {
      elements.prompt.value = button.dataset.prompt || '';
      autoResizePrompt();
      if (!state.loaded) {
        await loadModel();
      } else {
        elements.prompt.focus();
      }
      syncControls();
    });
  }

  elements.settingsButton.addEventListener('click', openSettings);
  elements.settingsClose.addEventListener('click', closeSettings);
  elements.settingsBackdrop.addEventListener('click', closeSettings);
  document.addEventListener('keydown', (event) => {
    if (event.key === 'Escape') closeSettings();
  });
  elements.modelSelect.addEventListener('change', previewSettingsModel);
  elements.customModel.addEventListener('input', previewSettingsModel);
  elements.profileSelect.addEventListener('change', () => {
    elements.temperature.disabled = elements.profileSelect.value !== 'custom';
  });
  elements.temperature.addEventListener('input', () => {
    elements.temperatureValue.value = Number(elements.temperature.value).toFixed(1);
  });
  elements.applySettings.addEventListener('click', applySettings);
  elements.eraseData.addEventListener('click', eraseData);

  window.addEventListener('beforeinstallprompt', (event) => {
    event.preventDefault();
    installPrompt = event;
    elements.installButton.hidden = false;
  });
  elements.installButton.addEventListener('click', installApp);
  window.addEventListener('appinstalled', () => {
    installPrompt = null;
    elements.installButton.hidden = true;
    showToast('Локальный AI установлен.');
  });
  window.addEventListener('online', () => {
    if (!state.loaded) setRuntime('idle', 'Онлайн · модель не загружена');
  });
  window.addEventListener('offline', () => {
    if (!state.loaded) setRuntime('idle', 'Офлайн · загрузится только из кэша');
    else showToast('Интернет отключён. Загруженная модель продолжит работать.');
  });
}

async function loadModel() {
  if (state.loading || state.loaded && state.loadedSignature === settingsSignature()) return;
  const model = effectiveModel();
  if (!model) {
    openSettings();
    showToast('Укажите Hugging Face ID пользовательской модели.', true);
    return;
  }

  state.loading = true;
  state.loaded = false;
  elements.loadModelButton.disabled = true;
  elements.loadModelButton.querySelector('span').textContent = 'Загрузка…';
  showProgress('Проверка локального кэша…', 0);
  setRuntime('busy', 'Подготовка ONNX-модели…');
  syncControls();
  worker.postMessage({
    type: 'load',
    payload: {
      model,
      device: state.settings.device,
      dtype: state.settings.dtype || undefined,
    },
  });
}

function submitPrompt(event) {
  event.preventDefault();
  const prompt = elements.prompt.value.trim();
  if (!prompt || !state.loaded || state.generating) return;

  state.messages.push({ role: 'user', content: prompt });
  elements.prompt.value = '';
  autoResizePrompt();
  state.generating = true;
  state.messages.push({ role: 'assistant', content: '' });
  renderMessages();
  updateWelcomeVisibility();
  setRuntime('busy', 'Модель генерирует ответ…');
  syncControls();
  scrollToBottom();

  worker.postMessage({
    type: 'generate',
    payload: {
      messages: state.messages.slice(0, -1),
      systemPrompt: profileSystemPrompt(state.settings.profile, prompt, state.settings.systemPrompt),
      maxNewTokens: state.settings.maxTokens,
      temperature: profileTemperature(state.settings.profile, prompt, state.settings.temperature),
      topP: 0.9,
    },
  });
}

function appendToken(token) {
  if (!state.generating) return;
  const message = state.messages.at(-1);
  if (!message || message.role !== 'assistant') return;
  message.content += token;
  updateLastMessage();
  scrollToBottom();
}

function finishGeneration(payload) {
  if (!state.generating) return;
  const message = state.messages.at(-1);
  if (message?.role === 'assistant') {
    if (payload.text && !message.content.trim()) message.content = payload.text;
    if (!message.content.trim()) message.content = 'Ответ остановлен.';
  }
  state.generating = false;
  persistState();
  renderMessages();
  setRuntime('ready', `${activeModel().label} · ${(payload.elapsedMs / 1000).toFixed(1)} с`);
  syncControls();
  elements.prompt.focus();
}

function handleWorkerError(message) {
  const wasGenerating = state.generating;
  state.loading = false;
  state.generating = false;
  if (!state.loaded) {
    elements.loadModelButton.disabled = false;
    elements.loadModelButton.querySelector('span').textContent = 'Повторить загрузку';
  }
  if (wasGenerating && state.messages.at(-1)?.role === 'assistant') {
    const assistant = state.messages.at(-1);
    if (!assistant.content) state.messages.pop();
  }
  renderMessages();
  setRuntime('error', 'Ошибка локальной модели');
  syncControls();
  showToast(message, true);
}

function updateProgress(progress = {}) {
  if (!state.loading) return;
  const file = progress.file ? String(progress.file).split('/').at(-1) : '';
  let percent = Number(progress.progress);
  if (!Number.isFinite(percent) && progress.loaded && progress.total) {
    percent = (progress.loaded / progress.total) * 100;
  }
  if (!Number.isFinite(percent)) percent = progress.status === 'ready' ? 100 : 0;
  const label = progress.status === 'progress'
    ? `Загрузка ${file || 'весов модели'}`
    : progress.status === 'done'
      ? `Готово: ${file || 'файл модели'}`
      : 'Подготовка ONNX Runtime…';
  showProgress(label, percent);
}

function showProgress(label, percent) {
  const value = Math.max(0, Math.min(100, Math.round(percent || 0)));
  elements.loadProgress.hidden = false;
  elements.progressLabel.textContent = label;
  elements.progressValue.textContent = `${value}%`;
  elements.progressBar.style.width = `${value}%`;
}

function renderMessages() {
  elements.messages.replaceChildren();
  state.messages.forEach((message, index) => {
    elements.messages.append(createMessage(message, index));
  });
  updateWelcomeVisibility();
  syncControls();
}

function updateLastMessage() {
  const index = state.messages.length - 1;
  const old = elements.messages.querySelector(`[data-index="${index}"]`);
  const next = createMessage(state.messages[index], index);
  if (old) old.replaceWith(next);
  else elements.messages.append(next);
}

function createMessage(message, index) {
  const article = document.createElement('article');
  article.className = `message ${message.role}`;
  article.dataset.index = index;

  const avatar = document.createElement('div');
  avatar.className = 'avatar';
  avatar.textContent = message.role === 'user' ? 'ВЫ' : 'AI';

  const body = document.createElement('div');
  body.className = 'message-body';
  const label = document.createElement('div');
  label.className = 'message-label';
  label.textContent = message.role === 'user' ? 'Вы' : activeModel().label;
  const content = document.createElement('div');
  content.className = 'message-content';
  renderRichText(content, message.content);
  if (state.generating && index === state.messages.length - 1) {
    const cursor = document.createElement('span');
    cursor.className = 'cursor';
    cursor.setAttribute('aria-label', 'Генерация');
    content.append(cursor);
  }

  body.append(label, content);
  article.append(avatar, body);
  return article;
}

function renderRichText(container, text) {
  const parts = String(text || '').split('```');
  parts.forEach((part, index) => {
    if (index % 2 === 1) {
      const pre = document.createElement('pre');
      const code = document.createElement('code');
      const firstBreak = part.indexOf('\n');
      const maybeLanguage = firstBreak >= 0 ? part.slice(0, firstBreak).trim() : '';
      code.textContent = maybeLanguage && /^[\w.+#-]{1,16}$/.test(maybeLanguage)
        ? part.slice(firstBreak + 1)
        : part;
      pre.append(code);
      container.append(pre);
      return;
    }
    appendInlineCode(container, part);
  });
}

function appendInlineCode(container, text) {
  const chunks = text.split(/(`[^`\n]+`)/g);
  for (const chunk of chunks) {
    if (chunk.startsWith('`') && chunk.endsWith('`')) {
      const code = document.createElement('code');
      code.className = 'inline-code';
      code.textContent = chunk.slice(1, -1);
      container.append(code);
    } else {
      container.append(document.createTextNode(chunk));
    }
  }
}

function clearConversation() {
  if (state.generating) return;
  state.messages = [];
  persistState();
  renderMessages();
  elements.prompt.focus();
}

function openSettings() {
  syncSettingsForm();
  elements.settingsBackdrop.hidden = false;
  requestAnimationFrame(() => elements.settingsPanel.classList.add('open'));
  elements.settingsPanel.setAttribute('aria-hidden', 'false');
  elements.settingsButton.setAttribute('aria-expanded', 'true');
}

function closeSettings() {
  elements.settingsPanel.classList.remove('open');
  elements.settingsPanel.setAttribute('aria-hidden', 'true');
  elements.settingsButton.setAttribute('aria-expanded', 'false');
  setTimeout(() => {
    if (!elements.settingsPanel.classList.contains('open')) elements.settingsBackdrop.hidden = true;
  }, 250);
}

function previewSettingsModel() {
  const custom = elements.modelSelect.value === 'custom';
  elements.customModelField.hidden = !custom;
  let model;
  try {
    model = custom
      ? resolveModel(elements.customModel.value || 'owner/model')
      : resolveModel(elements.modelSelect.value);
  } catch {
    return;
  }
  elements.modelDescription.replaceChildren();
  const strong = document.createElement('strong');
  strong.textContent = model.description;
  const span = document.createElement('span');
  span.textContent = `${model.params} параметров · ${model.download} · RAM ${model.ram}`;
  elements.modelDescription.append(strong, span);
}

function applySettings() {
  const modelSelection = elements.modelSelect.value;
  const customModel = elements.customModel.value.trim();
  if (modelSelection === 'custom' && !customModel) {
    showToast('Введите Hugging Face ID модели.', true);
    elements.customModel.focus();
    return;
  }

  const oldSignature = settingsSignature();
  state.settings = {
    model: modelSelection,
    customModel,
    device: elements.deviceSelect.value,
    dtype: elements.dtypeSelect.value,
    profile: elements.profileSelect.value,
    temperature: Number(elements.temperature.value),
    maxTokens: Math.max(16, Math.min(2048, Number(elements.maxTokens.value) || 256)),
    systemPrompt: elements.systemPrompt.value.trim() || DEFAULT_SYSTEM_PROMPT,
  };
  const modelChanged = oldSignature !== settingsSignature();
  if (modelChanged) {
    state.loaded = false;
    state.loadedSignature = '';
    worker.postMessage({ type: 'dispose' });
    elements.loadModelButton.querySelector('span').textContent = 'Загрузить модель';
    elements.prompt.disabled = true;
    setRuntime('idle', 'Настройки изменены · загрузите модель');
  }
  persistState();
  renderModelDetails();
  renderMessages();
  closeSettings();
  showToast(modelChanged ? 'Настройки применены. Загрузите выбранную модель.' : 'Настройки применены.');
}

function eraseData() {
  if (!window.confirm('Удалить историю диалога и вернуть настройки по умолчанию?')) return;
  localStorage.removeItem(STORAGE_KEY);
  state.messages = [];
  state.settings = {
    model: 'phone',
    customModel: '',
    device: 'auto',
    dtype: '',
    profile: 'auto',
    temperature: 0.7,
    maxTokens: 256,
    systemPrompt: DEFAULT_SYSTEM_PROMPT,
  };
  state.loaded = false;
  state.loadedSignature = '';
  worker.postMessage({ type: 'dispose' });
  syncSettingsForm();
  renderModelDetails();
  renderMessages();
  elements.prompt.disabled = true;
  elements.loadModelButton.querySelector('span').textContent = 'Загрузить модель';
  setRuntime('idle', 'Модель не загружена');
  closeSettings();
  showToast('История и настройки удалены. Кэш ONNX-модели сохранён браузером.');
}

function renderModelDetails() {
  const model = activeModel();
  elements.welcomeModelName.textContent = model.label;
  elements.welcomeModelMeta.textContent = `${model.download} · RAM ${model.ram}`;
}

function activeModel() {
  const model = effectiveModel();
  try {
    return resolveModel(model || 'phone', state.settings.dtype || undefined);
  } catch {
    return resolveModel('phone');
  }
}

function effectiveModel() {
  return state.settings.model === 'custom'
    ? state.settings.customModel.trim()
    : state.settings.model;
}

function settingsSignature() {
  return JSON.stringify([
    effectiveModel(),
    state.settings.device,
    state.settings.dtype,
  ]);
}

function syncSettingsForm() {
  const preset = findPreset(state.settings.model);
  elements.modelSelect.value = preset ? preset.id : state.settings.model === 'custom' ? 'custom' : 'phone';
  elements.customModel.value = state.settings.customModel || '';
  elements.customModelField.hidden = elements.modelSelect.value !== 'custom';
  elements.deviceSelect.value = state.settings.device;
  elements.dtypeSelect.value = state.settings.dtype;
  elements.profileSelect.value = state.settings.profile || 'auto';
  elements.temperature.value = state.settings.temperature;
  elements.temperature.disabled = elements.profileSelect.value !== 'custom';
  elements.temperatureValue.value = Number(state.settings.temperature).toFixed(1);
  elements.maxTokens.value = state.settings.maxTokens;
  elements.systemPrompt.value = state.settings.systemPrompt;
  previewSettingsModel();
}

function syncControls() {
  const hasPrompt = Boolean(elements.prompt.value.trim());
  const modelBusy = state.loading || state.generating;
  elements.sendButton.disabled = !state.loaded || state.generating || !hasPrompt;
  elements.clearButton.disabled = modelBusy || state.messages.length === 0;
  elements.applySettings.disabled = modelBusy;
  elements.eraseData.disabled = modelBusy;
  elements.stopButton.hidden = !state.generating;
  elements.sendButton.hidden = state.generating;
  elements.prompt.disabled = !state.loaded || state.generating;
}

function setRuntime(kind, label) {
  elements.runtimeDot.className = `status-dot ${kind === 'idle' ? '' : kind}`;
  elements.runtimeLabel.textContent = label;
}

function updateWelcomeVisibility() {
  elements.welcome.hidden = state.messages.length > 0 && state.loaded;
}

function autoResizePrompt() {
  elements.prompt.style.height = 'auto';
  elements.prompt.style.height = `${Math.min(elements.prompt.scrollHeight, 170)}px`;
}

function scrollToBottom() {
  requestAnimationFrame(() => window.scrollTo({ top: document.documentElement.scrollHeight, behavior: 'smooth' }));
}

function persistState() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify({
    settings: state.settings,
    messages: state.messages.slice(-40),
  }));
}

function restoreState() {
  try {
    const saved = JSON.parse(localStorage.getItem(STORAGE_KEY));
    if (saved?.settings) state.settings = { ...state.settings, ...saved.settings };
    if (Array.isArray(saved?.messages)) {
      state.messages = saved.messages.filter(
        (message) => ['user', 'assistant'].includes(message?.role) && typeof message.content === 'string',
      );
    }
  } catch {
    localStorage.removeItem(STORAGE_KEY);
  }
}

async function installApp() {
  if (!installPrompt) return;
  await installPrompt.prompt();
  await installPrompt.userChoice;
  installPrompt = null;
  elements.installButton.hidden = true;
}

function showToast(message, error = false) {
  clearTimeout(toastTimer);
  elements.toast.textContent = message;
  elements.toast.classList.toggle('error', error);
  elements.toast.hidden = false;
  toastTimer = setTimeout(() => { elements.toast.hidden = true; }, error ? 6500 : 3800);
}

async function registerServiceWorker() {
  if (!('serviceWorker' in navigator) || import.meta.env.DEV) return;
  try {
    await navigator.serviceWorker.register('./sw.js');
  } catch (error) {
    console.warn('Service Worker registration failed:', error);
  }
}

function collectElements() {
  const ids = [
    'apply-settings', 'clear-button', 'composer', 'custom-model', 'custom-model-field',
    'device-select', 'dtype-select', 'erase-data', 'install-button', 'load-model-button',
    'load-progress', 'max-tokens', 'messages', 'model-description', 'model-select', 'progress-bar',
    'progress-label', 'progress-value', 'profile-select', 'prompt', 'runtime-dot', 'runtime-label', 'send-button',
    'settings-backdrop', 'settings-button', 'settings-close', 'settings-panel', 'stop-button',
    'system-prompt', 'temperature', 'temperature-value', 'toast', 'welcome',
    'welcome-model-meta', 'welcome-model-name',
  ];
  return Object.fromEntries(ids.map((id) => [toCamelCase(id), document.getElementById(id)]));
}

function toCamelCase(value) {
  return value.replace(/-([a-z])/g, (_, letter) => letter.toUpperCase());
}

void MODEL_PRESETS;

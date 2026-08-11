# Локальный AI

Приватный чат-ассистент для **телефона, браузера, ПК, обычного терминала и Termux**. Текст генерируется на вашем устройстве: облачный API и отправка переписки на сервер не нужны.

Основной runtime — [Transformers.js](https://github.com/huggingface/transformers.js) + квантованные **ONNX**-модели. В Termux используется более практичная для Android связка `llama.cpp` + **GGUF**: официальный Node-биндинг ONNX Runtime не выпускается для Android/Bionic.

> Для первой загрузки модели нужен интернет. После загрузки браузер и CLI используют локальный кэш и могут работать офлайн. Сама модель не входит в Git: даже самый лёгкий пресет занимает сотни мегабайт.

## Что уже есть

- адаптивный browser chat без backend и регистрации;
- WebGPU на поддерживаемых устройствах, автоматический fallback на WASM/CPU;
- потоковый вывод и остановка генерации;
- четыре пресета и произвольный совместимый Hugging Face model ID;
- локальная история и настройки; безопасный renderer без `innerHTML`;
- устанавливаемая PWA с service worker и локальными assets;
- Node.js CLI для интерактивного и одноразового режима;
- OpenAI-совместимый локальный HTTP API с SSE;
- отдельный нативный launcher для Termux через `llama.cpp`;
- offline mode, файловый кэш и локальный каталог ONNX-весов;
- никаких web-fonts, аналитики и внешних frontend-скриптов.

## Модели

| Пресет | Модель | Для чего | Загрузка (примерно) |
|---|---|---|---:|
| `phone` | Qwen3 0.6B ONNX | основной многоязычный вариант | 570 МБ WebGPU |
| `mini` | SmolLM2 360M | слабый телефон, преимущественно английский | 273 МБ WebGPU |
| `coder` | Qwen2.5 Coder 0.5B | компактный помощник по коду | 555 МБ WebGPU |
| `quality` | Qwen3 1.7B ONNX | более качественные ответы на мощном устройстве | около 1,3 ГБ |

Для WebGPU используются веса `q4f16`, для WASM/Node CPU — `q4`. Реальная память выше размера файла: нужны KV-cache, токенизатор и рабочие буферы. На телефоне начните с `mini` или `phone` и контекста 1024–2048 токенов.

Компактная модель не равна большой облачной модели: она чаще ошибается, хуже следует сложным инструкциям и не имеет доступа к свежим данным. Не полагайтесь на неё в медицинских, юридических или иных критичных решениях.

## Быстрый запуск в браузере

Требования: Node.js `20.19+` (рекомендуется Node 22), npm и современный браузер.

```bash
npm ci
npm run dev
```

Откройте адрес, который напечатает Vite. Нажмите **«Загрузить модель»**. После окончания загрузки файлы останутся в browser Cache Storage.

Для production/PWA:

```bash
npm run build:runner
npm run serve
```

Откройте `http://127.0.0.1:3928`. `build:runner` задаёт Node heap 3072 МБ и использует почти всю доступную память текущего runner, оставляя запас операционной системе. Готовая статика находится в `dist/` и может раздаваться любым HTTPS-сервером.

### WebGPU и установка PWA

- WebGPU обычно доступен в актуальных Chrome/Edge на ПК и части Android-устройств.
- Если WebGPU или `q4f16` не поддерживается, режим **Auto** повторяет загрузку через WASM.
- PWA и WebGPU требуют secure context: HTTPS либо `localhost`.
- На iOS объём browser cache и фоновая работа ограничиваются системой.
- Кнопка установки показывается только когда браузер присылает событие install prompt; иначе используйте меню браузера **«Добавить на главный экран»**.

## CLI на ПК

Установка в текущем checkout:

```bash
npm ci
npm link
local-ai models
```

Интерактивный диалог:

```bash
local-ai chat --model phone
```

Один запрос и JSON-ответ:

```bash
local-ai "Объясни квантование простыми словами"
local-ai --model mini --max-tokens 128 --json "Что такое ONNX?"
```

Загрузить заранее, затем запретить сеть:

```bash
local-ai download --model phone
local-ai chat --model phone --offline
```

По умолчанию кэш — `.local-ai/cache`. Его можно перенести:

```bash
LOCAL_AI_CACHE="$HOME/models/local-ai" local-ai download --model phone
LOCAL_AI_CACHE="$HOME/models/local-ai" local-ai chat --model phone --offline
```

Самостоятельно скачанные Transformers.js/ONNX repositories можно использовать так:

```bash
local-ai chat \
  --model owner/model-ONNX \
  --local-models /absolute/path/to/models \
  --offline
```

Путь должен содержать полную структуру model repository: конфиги, tokenizer и каталог `onnx/`, а не только один `.onnx` файл.

Команды интерактивного режима: `/reset`, `/system текст`, `/save файл.json`, `/help`, `/exit`. Все параметры: `local-ai --help`.

## Termux / Android

В Termux **не запускайте `npm install` этого проекта**: `onnxruntime-node` поддерживает Linux ARM64 с glibc, но не Android с Bionic. Включён независимый установщик `llama.cpp` + Qwen3 0.6B `Q4_K_M` GGUF (484 МБ).

Установите современный Termux, затем из checkout проекта:

```bash
bash scripts/termux-setup.sh
local-ai-termux
```

Скрипт:

1. устанавливает пакет `llama-cpp` из Termux;
2. если пакет недоступен — собирает CPU-версию из исходников;
3. скачивает GGUF в `~/.local-ai/models/` с возможностью продолжить прерванную загрузку;
4. устанавливает команду `local-ai-termux` в `$PREFIX/bin`.

Настройка памяти и потоков:

```bash
LOCAL_AI_CONTEXT=1024 LOCAL_AI_THREADS=4 local-ai-termux
```

Другой локальный GGUF:

```bash
LOCAL_AI_GGUF="$HOME/my-model.gguf" local-ai-termux
```

После setup и загрузки GGUF интернет не нужен. Сборку и модель держите внутри Termux home, а не в `/sdcard`: Android shared storage не поддерживает нужные права на исполняемые файлы.

## Локальный OpenAI-совместимый API

```bash
local-ai serve --model phone --preload
```

Endpoints:

- `GET /health`
- `GET /v1/models`
- `POST /v1/chat/completions`
- static browser UI из `dist/`

Обычный запрос:

```bash
curl http://127.0.0.1:3928/v1/chat/completions \
  -H 'Content-Type: application/json' \
  -d '{
    "model": "phone",
    "messages": [{"role": "user", "content": "Привет!"}],
    "max_tokens": 128
  }'
```

Streaming включается полем `"stream": true` и возвращает SSE chunks с финальным `data: [DONE]`.

Для доступа из локальной сети обязательно задайте ключ:

```bash
local-ai serve --host 0.0.0.0 --api-key 'замените-на-длинный-секрет'
```

```bash
curl http://PHONE_OR_PC:3928/v1/models \
  -H 'Authorization: Bearer замените-на-длинный-секрет'
```

Не публикуйте этот CPU server напрямую в интернет. Встроенный Bearer key — минимальная защита, а не замена TLS, rate limiting и firewall.

## Настройки окружения

| Переменная | Назначение |
|---|---|
| `LOCAL_AI_CACHE` | каталог Node-кэша моделей |
| `LOCAL_AI_THREADS` | число CPU-потоков Node/Termux |
| `LOCAL_AI_API_KEY` | Bearer key для `/v1/*` |
| `LOCAL_AI_GGUF` | путь к модели Termux |
| `LOCAL_AI_CONTEXT` | размер контекста Termux |
| `LOCAL_AI_LLAMA_CLI` | другое имя/путь `llama-cli` |

## Разработка и проверка

```bash
npm ci
npm run check
npm test
npm run build:runner
npm audit --audit-level=high
```

Или одной командой:

```bash
npm run ci
```

`ci` уже вызывает `build:runner` с лимитом heap 3072 МБ.

Тесты не скачивают модель и используют fake inference engine для HTTP API. `.npmrc` отключает ненужную загрузку CUDA-библиотек ONNX Runtime; приложение на Node использует встроенный CPU runtime.

## Как устроено

```text
src/browser/app.js       UI, история, настройки, PWA
src/browser/ai.worker.js Transformers.js, WebGPU/WASM, streaming
src/node/engine.js       Node ONNX engine и очередь генераций
src/node/cli.js          терминальный интерфейс
src/node/server.js       HTTP/SSE API и static server
src/shared/              общие модели и chat validation
scripts/                 отдельный Termux/GGUF runtime
public/                  manifest, service worker, локальные icons
```

### Что значит «полностью локально»

- Промпты и ответы не отправляются облачному inference API.
- Frontend не содержит аналитики, CDN scripts или удалённых шрифтов.
- Hugging Face используется только как источник файлов модели при первой загрузке.
- Browser offline зависит от cache конкретного origin; очистка данных сайта удалит модель.
- Для air-gapped Node-системы заранее перенесите кэш или полный model repository и включите `--offline`.
- Проверяйте лицензию выбранной модели отдельно: MIT-лицензия этого кода не меняет лицензию весов.

## Лицензия

Код проекта — [MIT](LICENSE). Модели распространяются их авторами на собственных условиях.

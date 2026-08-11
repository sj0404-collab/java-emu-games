#!/data/data/com.termux/files/usr/bin/bash
set -euo pipefail

MODEL_DIR="${LOCAL_AI_MODEL_DIR:-$HOME/.local-ai/models}"
MODEL_FILE="$MODEL_DIR/Qwen_Qwen3-0.6B-Q4_K_M.gguf"
MODEL_URL="https://huggingface.co/bartowski/Qwen_Qwen3-0.6B-GGUF/resolve/main/Qwen_Qwen3-0.6B-Q4_K_M.gguf"
MODEL_SIZE=484220320
SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"

if ! command -v pkg >/dev/null 2>&1; then
  echo "Этот установщик предназначен для Termux." >&2
  exit 1
fi

pkg update -y
pkg install -y curl ca-certificates

if ! command -v llama-cli >/dev/null 2>&1; then
  if ! pkg install -y llama-cpp; then
    echo "Готовый llama.cpp недоступен — собираю CPU-версию из исходников."
    pkg install -y git cmake clang ninja libandroid-spawn
    SOURCE="$HOME/.local-ai/llama.cpp"
    if [[ ! -d "$SOURCE/.git" ]]; then
      git clone --depth 1 https://github.com/ggml-org/llama.cpp.git "$SOURCE"
    else
      git -C "$SOURCE" pull --ff-only
    fi
    cmake -S "$SOURCE" -B "$SOURCE/build" -G Ninja \
      -DCMAKE_BUILD_TYPE=Release \
      -DGGML_OPENMP=OFF \
      -DGGML_LLAMAFILE=OFF
    cmake --build "$SOURCE/build" --target llama-cli --parallel "$(nproc)"
    ln -sf "$SOURCE/build/bin/llama-cli" "$PREFIX/bin/llama-cli"
  fi
fi

mkdir -p "$MODEL_DIR"
CURRENT_SIZE="$(stat -c '%s' "$MODEL_FILE" 2>/dev/null || echo 0)"
if (( CURRENT_SIZE > MODEL_SIZE )); then
  echo "Повреждённый файл модели больше ожидаемого; загружаю заново."
  rm -f "$MODEL_FILE"
  CURRENT_SIZE=0
fi
if (( CURRENT_SIZE != MODEL_SIZE )); then
  echo "Загружаю Qwen3 0.6B Q4_K_M (484 220 320 байт)…"
  curl --fail --location --continue-at - --retry 5 --output "$MODEL_FILE" "$MODEL_URL"
fi
ACTUAL_SIZE="$(stat -c '%s' "$MODEL_FILE" 2>/dev/null || echo 0)"
if (( ACTUAL_SIZE != MODEL_SIZE )); then
  echo "Неверный размер модели: $ACTUAL_SIZE вместо $MODEL_SIZE байт." >&2
  echo "Повторите установку — curl продолжит загрузку с места остановки." >&2
  exit 1
fi
echo "Модель готова: $MODEL_FILE"

install -m 0755 "$SCRIPT_DIR/local-ai-termux" "$PREFIX/bin/local-ai-termux"

echo
echo "Готово. Запустите: local-ai-termux"
echo "Для экономии памяти: LOCAL_AI_CONTEXT=1024 local-ai-termux"

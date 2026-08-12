#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DEST="$ROOT/android/vendor/llama.cpp"
COMMIT="$(tr -d '[:space:]' < "$ROOT/android/llama-version.txt")"
REPOSITORY="https://github.com/ggml-org/llama.cpp.git"

if [[ -d "$DEST/.git" ]] && [[ "$(git -C "$DEST" rev-parse HEAD 2>/dev/null || true)" == "$COMMIT" ]]; then
  echo "llama.cpp уже подготовлен: $COMMIT"
  exit 0
fi

if [[ -e "$DEST" ]]; then
  echo "Удаляю неподходящий vendor checkout: $DEST"
  rm -rf "$DEST"
fi

mkdir -p "$(dirname "$DEST")"
git init -q "$DEST"
git -C "$DEST" remote add origin "$REPOSITORY"
echo "Загружаю закреплённый llama.cpp $COMMIT…"
git -C "$DEST" fetch --depth 1 origin "$COMMIT"
git -C "$DEST" checkout -q --detach FETCH_HEAD

ACTUAL="$(git -C "$DEST" rev-parse HEAD)"
if [[ "$ACTUAL" != "$COMMIT" ]]; then
  echo "Ошибка: ожидался $COMMIT, получен $ACTUAL" >&2
  exit 1
fi

echo "Готово: $DEST"

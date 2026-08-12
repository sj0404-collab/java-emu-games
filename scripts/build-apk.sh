#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
ANDROID_DIR="$ROOT/android"
OUTPUT_DIR="$ROOT/artifacts"

export ANDROID_HOME="${ANDROID_HOME:-${ANDROID_SDK_ROOT:-$HOME/android-sdk}}"
export ANDROID_SDK_ROOT="$ANDROID_HOME"

if [[ -z "${JAVA_HOME:-}" ]]; then
  JAVA_BIN="$(command -v java || true)"
  if [[ -n "$JAVA_BIN" ]]; then
    JAVA_HOME="$(dirname "$(dirname "$(readlink -f "$JAVA_BIN")")")"
    export JAVA_HOME
  fi
fi

if [[ ! -x "${JAVA_HOME:-}/bin/java" ]]; then
  echo "Нужен JDK 17. Укажите JAVA_HOME." >&2
  exit 1
fi
if [[ ! -d "$ANDROID_HOME/platforms/android-35" ]]; then
  echo "Не найден Android SDK Platform 35 в $ANDROID_HOME" >&2
  exit 1
fi
if [[ ! -d "$ANDROID_HOME/ndk/27.2.12479018" ]]; then
  echo "Не найден NDK 27.2.12479018 в $ANDROID_HOME" >&2
  exit 1
fi
if [[ ! -d "$ANDROID_HOME/cmake/3.22.1" ]]; then
  echo "Не найден CMake 3.22.1 в $ANDROID_HOME" >&2
  exit 1
fi

if [[ -z "${LOCAL_AI_KEYSTORE:-}" && ! -f "$HOME/.android/debug.keystore" ]]; then
  mkdir -p "$HOME/.android"
  "$JAVA_HOME/bin/keytool" -genkeypair -v \
    -keystore "$HOME/.android/debug.keystore" \
    -storepass android -alias androiddebugkey -keypass android \
    -keyalg RSA -keysize 2048 -validity 10000 \
    -dname "CN=Local AI Debug,O=Local AI,C=LV"
fi

"$ROOT/scripts/android-bootstrap.sh"
mkdir -p "$OUTPUT_DIR"

cd "$ANDROID_DIR"
./gradlew --no-daemon --stacktrace :app:assembleRelease

SOURCE="$ANDROID_DIR/app/build/outputs/apk/release/app-release.apk"
DESTINATION="$OUTPUT_DIR/local-ai-android-arm64-v0.2.0.apk"
cp "$SOURCE" "$DESTINATION"
sha256sum "$DESTINATION" | tee "$DESTINATION.sha256"
echo "APK: $DESTINATION"

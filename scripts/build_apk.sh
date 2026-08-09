#!/bin/bash
set -e
export ANDROID_HOME=/home/z/my-project/android-sdk
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
cd /home/z/my-project/heroes-lore-v1
echo "Starting build at $(date)..."
./gradlew assembleRelease --no-daemon 2>&1
echo "Build finished at $(date), exit=$?"
ls -la app/build/outputs/apk/release/*.apk 2>/dev/null

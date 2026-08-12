import test from 'node:test';
import assert from 'node:assert/strict';
import { access, readFile, readdir, stat } from 'node:fs/promises';
import { constants } from 'node:fs';
import { join } from 'node:path';

async function walk(directory) {
  const result = [];
  for (const entry of await readdir(directory, { withFileTypes: true })) {
    const path = join(directory, entry.name);
    if (entry.isDirectory()) result.push(...await walk(path));
    else result.push(path);
  }
  return result;
}

test('Android app is arm64-only, model-free and has no network/storage permission', async () => {
  const [gradle, manifest] = await Promise.all([
    readFile('android/app/build.gradle', 'utf8'),
    readFile('android/app/src/main/AndroidManifest.xml', 'utf8'),
  ]);
  assert.match(gradle, /abiFilters 'arm64-v8a'/);
  assert.match(gradle, /minSdk 26/);
  assert.match(gradle, /shrinkResources true/);
  assert.doesNotMatch(manifest, /uses-permission/);
  const files = await walk('android/app/src');
  assert.ok(files.every((file) => !/\.(?:gguf|onnx)$/i.test(file)));
});

test('Android native runtime uses SAF fd path, streaming and bounded context', async () => {
  const [activity, engine] = await Promise.all([
    readFile('android/app/src/main/java/com/localai/phone/MainActivity.java', 'utf8'),
    readFile('android/app/src/main/cpp/native_engine.cpp', 'utf8'),
  ]);
  assert.match(activity, /ACTION_OPEN_DOCUMENT/);
  assert.match(activity, /requestCode == SPEECH[\s\S]*getStringArrayListExtra[\s\S]*return;[\s\S]*data\.getData\(\)/);
  assert.match(activity, /\/proc\/self\/fd\//);
  assert.match(activity, /MAX_ESTIMATED_NATIVE = 1900L/);
  assert.match(engine, /nativeNextToken/);
  assert.match(engine, /llama_memory_seq_rm/);
  assert.match(engine, /common_chat_format_single/);
});

test('Android dependency versions and bootstrap are pinned', async () => {
  const [commit, wrapper, build] = await Promise.all([
    readFile('android/llama-version.txt', 'utf8'),
    readFile('android/gradle/wrapper/gradle-wrapper.properties', 'utf8'),
    readFile('scripts/build-apk.sh', 'utf8'),
  ]);
  assert.match(commit.trim(), /^[0-9a-f]{40}$/);
  assert.match(wrapper, /gradle-8\.10\.2-bin\.zip/);
  assert.match(build, /27\.2\.12479018/);
  await access('android/gradlew', constants.X_OK);
  await access('scripts/android-bootstrap.sh', constants.X_OK);
  assert.ok((await stat('android/gradle/wrapper/gradle-wrapper.jar')).size > 50_000);
});

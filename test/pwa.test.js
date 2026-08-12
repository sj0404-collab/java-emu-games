import test from 'node:test';
import assert from 'node:assert/strict';
import { readFile } from 'node:fs/promises';


test('PWA manifest has installable local icons', async () => {
  const manifest = JSON.parse(await readFile('public/manifest.webmanifest', 'utf8'));
  assert.equal(manifest.display, 'standalone');
  assert.equal(manifest.start_url, './');
  assert.ok(manifest.icons.some((icon) => icon.sizes === '192x192'));
  assert.ok(manifest.icons.some((icon) => icon.sizes === '512x512'));
});


test('browser source does not load remote fonts or scripts', async () => {
  const files = await Promise.all([
    readFile('index.html', 'utf8'),
    readFile('src/browser/styles.css', 'utf8'),
    readFile('src/browser/app.js', 'utf8'),
  ]);
  const source = files.join('\n');
  assert.doesNotMatch(source, /fonts\.(?:googleapis|gstatic)\.com/);
  assert.doesNotMatch(source, /<(?:script|link)[^>]+https?:\/\//i);
});


test('service worker precaches built assets without deleting the model cache', async () => {
  const worker = await readFile('public/sw.js', 'utf8');
  assert.match(worker, /html\.matchAll/);
  assert.match(worker, /key\.startsWith\(CACHE_PREFIX\)/);
  assert.doesNotMatch(worker, /keys\.filter\(\(key\) => key !== CACHE\)/);
});

import test from 'node:test';
import assert from 'node:assert/strict';
import { access, readFile } from 'node:fs/promises';
import { constants } from 'node:fs';


test('Termux launch scripts are executable and avoid Node native bindings', async () => {
  await access('scripts/termux-setup.sh', constants.X_OK);
  await access('scripts/local-ai-termux', constants.X_OK);
  const setup = await readFile('scripts/termux-setup.sh', 'utf8');
  const launcher = await readFile('scripts/local-ai-termux', 'utf8');
  assert.match(setup, /pkg install -y llama-cpp/);
  assert.match(setup, /Qwen_Qwen3-0\.6B-Q4_K_M\.gguf/);
  assert.match(launcher, /llama-cli/);
  assert.doesNotMatch(`${setup}\n${launcher}`, /npm install|onnxruntime-node/);
});

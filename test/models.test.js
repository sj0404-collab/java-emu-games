import test from 'node:test';
import assert from 'node:assert/strict';
import {
  DEFAULT_PRESET,
  MODEL_PRESETS,
  dtypeForDevice,
  findPreset,
  resolveModel,
} from '../src/shared/models.js';


test('built-in presets resolve by short id and full model id', () => {
  assert.ok(MODEL_PRESETS.length >= 4);
  assert.equal(findPreset('phone'), DEFAULT_PRESET);
  assert.equal(findPreset(DEFAULT_PRESET.model), DEFAULT_PRESET);
  assert.equal(resolveModel().model, DEFAULT_PRESET.model);
  assert.equal(resolveModel('phone', 'fp16').dtype, 'fp16');
});


test('custom model IDs are trimmed and receive safe defaults', () => {
  const custom = resolveModel('  owner/custom-ONNX  ');
  assert.equal(custom.id, 'custom');
  assert.equal(custom.model, 'owner/custom-ONNX');
  assert.equal(custom.dtype, 'q4');
  assert.throws(() => resolveModel('   '), /пустым/);
});


test('dtypeForDevice chooses GPU and CPU quantizations', () => {
  const model = { dtype: 'q4f16', cpuDtype: 'q4' };
  assert.equal(dtypeForDevice(model, 'webgpu'), 'q4f16');
  assert.equal(dtypeForDevice(model, 'wasm'), 'q4');
  assert.equal(dtypeForDevice(model, 'cpu'), 'q4');
});

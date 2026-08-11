import test from 'node:test';
import assert from 'node:assert/strict';
import {
  extractAssistantText,
  generationOptions,
  normalizeMessages,
} from '../src/shared/chat.js';


test('normalizeMessages cleans messages and inserts a system prompt', () => {
  const result = normalizeMessages([
    { role: 'user', content: '  Привет  ' },
    { role: 'tool', content: 'ignored' },
    null,
  ], '  Система  ');

  assert.deepEqual(result, [
    { role: 'system', content: 'Система' },
    { role: 'user', content: 'Привет' },
  ]);
});


test('normalizeMessages requires a user message', () => {
  assert.throws(
    () => normalizeMessages([{ role: 'assistant', content: 'Ответ' }]),
    /пользователя/,
  );
  assert.throws(() => normalizeMessages('not an array'), /массивом/);
});


test('extractAssistantText supports chat and plain pipeline outputs', () => {
  assert.equal(extractAssistantText([{
    generated_text: [
      { role: 'user', content: 'Вопрос' },
      { role: 'assistant', content: '  Ответ  ' },
    ],
  }]), 'Ответ');
  assert.equal(extractAssistantText([{ generated_text: '  plain  ' }]), 'plain');
  assert.equal(extractAssistantText({ generated_text: '  direct  ' }), 'direct');
  assert.equal(extractAssistantText(null), '');
});


test('generationOptions maps API names and clamps unsafe values', () => {
  assert.deepEqual(generationOptions({
    max_tokens: 9999,
    temperature: 0,
    top_p: -10,
    repetition_penalty: 9,
  }), {
    max_new_tokens: 2048,
    temperature: 1,
    top_p: 0.01,
    do_sample: false,
    repetition_penalty: 2,
  });

  assert.deepEqual(generationOptions({ maxNewTokens: 'bad' }), {
    max_new_tokens: 256,
    temperature: 0.7,
    top_p: 0.9,
    do_sample: true,
    repetition_penalty: 1.05,
  });
});

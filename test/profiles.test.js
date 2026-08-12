import test from 'node:test';
import assert from 'node:assert/strict';
import { execFile } from 'node:child_process';
import { readFile } from 'node:fs/promises';
import { promisify } from 'node:util';
import {
  PROFILE_PRESETS,
  profileSystemPrompt,
  profileTemperature,
  resolveProfile,
  routeProfile,
} from '../src/shared/profiles.js';

const execFileAsync = promisify(execFile);

test('auto profile routes Russian and English task words', () => {
  assert.equal(routeProfile('Исправь ошибку в функции JavaScript'), 'coding');
  assert.equal(routeProfile('Начнём D&D кампанию с новым персонажем'), 'rpg');
  assert.equal(routeProfile('Write a creative story about Riga'), 'creative');
  assert.equal(routeProfile('Рассчитай формулу точно'), 'analysis');
  assert.equal(routeProfile('Как прошёл твой день?'), 'general');
});

test('manual profile overrides routing and has a temperature preset', () => {
  assert.equal(resolveProfile('rpg', 'write SQL code'), 'rpg');
  assert.equal(profileTemperature('analysis', 'poem'), 0.15);
  assert.equal(profileTemperature('custom', '', 1.1), 1.1);
  assert.ok(PROFILE_PRESETS.some((profile) => profile.id === 'auto'));
});

test('profile prompt asks only material clarifying questions', () => {
  const prompt = profileSystemPrompt('coding', 'bug in Java');
  assert.match(prompt, /1–3 коротких уточняющих вопроса/);
  assert.match(prompt, /Не выдумывай/);
  assert.match(prompt, /инженер/);
  assert.equal(profileSystemPrompt('custom', '', '  My exact prompt  '), 'My exact prompt');
});

test('browser persists profile settings and resolves Auto per prompt', async () => {
  const [html, app] = await Promise.all([
    readFile('index.html', 'utf8'),
    readFile('src/browser/app.js', 'utf8'),
  ]);
  assert.match(html, /id="profile-select"/);
  assert.match(app, /profile: 'auto'/);
  assert.match(app, /elements\.profileSelect\.value = state\.settings\.profile \|\| 'auto'/);
  assert.match(app, /profileSystemPrompt\(state\.settings\.profile, prompt/);
  assert.match(app, /profileTemperature\(state\.settings\.profile, prompt/);
});

test('CLI documents profiles and rejects an unknown profile before model loading', async () => {
  const { stdout } = await execFileAsync(process.execPath, ['src/node/cli.js', '--help']);
  assert.match(stdout, /--profile <имя>/);
  await assert.rejects(
    execFileAsync(process.execPath, ['src/node/cli.js', '--profile', 'unknown', 'hello']),
    /Неизвестный профиль: unknown/,
  );
});

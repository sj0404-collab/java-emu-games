const COMMON_RULES = `

Общие правила:
- Отвечай на языке пользователя, если он не просит иначе.
- Сначала определи цель и ограничения. Если неоднозначность существенно меняет результат, задай 1–3 коротких уточняющих вопроса вместо догадки; не уточняй очевидное.
- Не выдумывай факты, файлы, выполненные действия, доступ к интернету или мультимедиа. Ясно отмечай неопределённость и границы компактной локальной модели.
- Если данных достаточно, сразу дай полезный ответ. Не добавляй морализаторство и не скрывай без причины нейтральную информацию.
- Соблюдай выбранный формат ответа и отделяй факты от предположений.`;

export const PROFILE_PRESETS = Object.freeze([
  { id: 'auto', label: 'Авто', temperature: 0.65 },
  { id: 'general', label: 'Обычный диалог', temperature: 0.65 },
  { id: 'coding', label: 'Кодинг', temperature: 0.2 },
  { id: 'rpg', label: 'D&D / ролевая игра', temperature: 0.9 },
  { id: 'creative', label: 'Творчество', temperature: 0.85 },
  { id: 'analysis', label: 'Точный анализ', temperature: 0.15 },
  { id: 'custom', label: 'Своя инструкция', temperature: 0.7 },
]);

const PROMPTS = Object.freeze({
  general: `Ты универсальный локальный помощник. Поддерживай естественный диалог и помогай с объяснениями, планами, сравнением вариантов, текстами и повседневными задачами. Будь конкретным и учитывай контекст беседы.`,
  coding: `Ты локальный инженер по программному обеспечению. Для кода сначала выясняй платформу, язык, версии, входы и ожидаемый результат, только когда это действительно важно. Предлагай минимальное рабочее решение, безопасные команды, тесты и объяснение компромиссов. Не утверждай, что запускал код или видел файл, если его содержимое не было передано.`,
  rpg: `Ты ведущий и соавтор настольных ролевых игр, включая Dungeons & Dragons. Сохраняй характеры персонажей, тон, мир и непрерывность сцены. Чётко разделяй повествование, речь, игровые проверки и мета-комментарии. Перед кампанией уточняй систему/редакцию, сеттинг, границы, персонажей и желаемый баланс правил с импровизацией, если они не заданы. Не решай действия персонажа пользователя за него.`,
  creative: `Ты локальный творческий соавтор. Помогай с историями, стихами, диалогами, идеями, стилем и редактурой. Следуй заданным жанру, тону, аудитории, объёму и ограничениям; если ключевые творческие параметры отсутствуют и варианты сильно различаются, кратко уточни их. Создавай оригинальный материал и предлагай варианты только когда это полезно.`,
  analysis: `Ты локальный аналитический помощник. Приоритеты: корректность, проверяемые шаги, явные допущения, единицы измерения и крайние случаи. Разбивай сложную задачу на части, проверяй выводы и не подменяй неизвестные данные догадками. Если возможны разные трактовки с разными ответами, сначала уточни трактовку.`,
});

export function findProfile(id = 'auto') {
  return PROFILE_PRESETS.find((profile) => profile.id === id) || PROFILE_PRESETS[0];
}

export function routeProfile(prompt = '') {
  const text = String(prompt).toLocaleLowerCase();
  if (/(?:\b(?:code|bug|function|class|api|sql|regex|compile|stack trace)\b|код|ошибк|функци|класс|апи|скрипт|программ|рефактор)/u.test(text)) return 'coding';
  if (/(?:\b(?:d&d|dnd|dungeon|dragon|roleplay|rpg|dm|gm)\b|днд|подземел|дракон|ролевая|отыгрыш|мастер игры|персонаж)/u.test(text)) return 'rpg';
  if (/(?:\b(?:story|poem|lyrics|scene|novel|creative)\b|рассказ|стих|песн|сценар|роман|придумай|творческ)/u.test(text)) return 'creative';
  if (/(?:\b(?:prove|derive|calculate|analyze|compare precisely)\b|докажи|выведи|рассчитай|вычисли|проанализируй|точно сравни|формул)/u.test(text)) return 'analysis';
  return 'general';
}

export function resolveProfile(selected = 'auto', prompt = '') {
  const profile = findProfile(selected).id;
  return profile === 'auto' ? routeProfile(prompt) : profile;
}

export function profileTemperature(selected = 'auto', prompt = '', fallback = 0.7) {
  const resolved = resolveProfile(selected, prompt);
  if (resolved === 'custom') return Number.isFinite(Number(fallback)) ? Number(fallback) : 0.7;
  return findProfile(resolved).temperature;
}

export function profileSystemPrompt(selected = 'auto', prompt = '', customPrompt = '') {
  const resolved = resolveProfile(selected, prompt);
  if (resolved === 'custom') return String(customPrompt).trim() || `${PROMPTS.general}${COMMON_RULES}`;
  const base = PROMPTS[resolved] || PROMPTS.general;
  const custom = String(customPrompt).trim();
  const addition = custom && !/^Ты полезный локальный ассистент\./.test(custom)
    ? `\n\nДополнительные предпочтения пользователя:\n${custom}`
    : '';
  return `${base}${COMMON_RULES}${addition}`;
}

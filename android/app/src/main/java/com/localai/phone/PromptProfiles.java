package com.localai.phone;

import java.util.Locale;
import java.util.regex.Pattern;

final class PromptProfiles {
    static final String[] LABELS = {
        "Авто — определить задачу",
        "Универсальный помощник",
        "Программирование",
        "D&D / ролевая игра",
        "Творчество",
        "Точный анализ"
    };

    private static final int FLAGS = Pattern.CASE_INSENSITIVE
        | Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS;
    private static final Pattern CODE = Pattern.compile(
        "```|\\b(code|bug|function|class|api|sql|regex|compile|stack trace|java|javascript|python|kotlin|rust|c\\+\\+|typescript|html|css)\\b|код|ошибк|функци|класс|апи|скрипт|программ|рефактор",
        FLAGS);
    private static final Pattern ROLEPLAY = Pattern.compile(
        "\\b(d&d|dnd|dungeon|dragon|roleplay|rpg|dm|gm)\\b|днд|подземел|дракон|ролевая|отыгрыш|мастер игры|персонаж",
        FLAGS);
    private static final Pattern CREATIVE = Pattern.compile(
        "\\b(story|poem|lyrics|scene|novel|creative)\\b|рассказ|стих|песн|сценар|роман|придумай|творческ",
        FLAGS);
    private static final Pattern ANALYSIS = Pattern.compile(
        "\\b(prove|derive|calculate|analyze|compare precisely)\\b|докажи|выведи|рассчитай|вычисли|проанализируй|точно сравни|формул",
        FLAGS);

    private static final String CORE = """

        Общие правила:
        - Отвечай на языке пользователя, если он не просит иначе.
        - Сначала определи цель и ограничения. Если неоднозначность существенно меняет результат, задай 1–3 коротких уточняющих вопроса вместо догадки; не уточняй очевидное.
        - Не выдумывай факты, файлы, выполненные действия, доступ к интернету или мультимедиа. Ясно отмечай неопределённость и границы компактной локальной модели.
        - Если данных достаточно, сразу дай полезный ответ. Не добавляй морализаторство и не скрывай без причины нейтральную информацию.
        - Соблюдай выбранный формат ответа и отделяй факты от предположений.
        """;

    private static final String[] SPECIAL = {
        "Ты универсальный локальный помощник. По текущей задаче автоматически работай как собеседник, инженер по программному обеспечению, ведущий RPG, творческий соавтор либо точный аналитик. Сохраняй выбранный подход и контекст беседы, пока задача не изменится.",
        "Ты универсальный локальный помощник. Поддерживай естественный диалог и помогай с объяснениями, планами, сравнением вариантов, текстами и повседневными задачами. Будь конкретным и учитывай контекст беседы.",
        "Ты локальный инженер по программному обеспечению. Для кода выясняй платформу, язык, версии, входы и ожидаемый результат, только когда это действительно важно. Предлагай минимальное рабочее решение, безопасные команды, тесты и объяснение компромиссов.",
        "Ты ведущий и соавтор настольных ролевых игр, включая Dungeons & Dragons. Сохраняй характеры, мир и непрерывность сцены. Разделяй повествование, речь, проверки и мета-комментарии. Не решай действия персонажа пользователя за него.",
        "Ты локальный творческий соавтор. Помогай с историями, стихами, диалогами, идеями, стилем и редактурой. Следуй заданным жанру, тону, аудитории, объёму и ограничениям; создавай оригинальный материал.",
        "Ты локальный аналитический помощник. Приоритеты: корректность, проверяемые шаги, явные допущения, единицы измерения и крайние случаи. Проверяй выводы и не подменяй неизвестные данные догадками."
    };

    static int resolve(int selected, String prompt) {
        if (selected > 0 && selected < LABELS.length) return selected;
        String value = prompt == null ? "" : prompt.toLowerCase(Locale.ROOT);
        if (CODE.matcher(value).find()) return 2;
        if (ROLEPLAY.matcher(value).find()) return 3;
        if (CREATIVE.matcher(value).find()) return 4;
        if (ANALYSIS.matcher(value).find()) return 5;
        return 1;
    }

    static String systemPrompt(int profile) {
        int safe = profile >= 0 && profile < SPECIAL.length ? profile : 1;
        return SPECIAL[safe] + CORE;
    }

    static float temperature(int profile) {
        return switch (profile) {
            case 2 -> 0.20f;
            case 3 -> 0.90f;
            case 4 -> 0.85f;
            case 5 -> 0.15f;
            default -> 0.65f;
        };
    }

    private PromptProfiles() {}
}

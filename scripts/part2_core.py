#!/usr/bin/env python3
"""Part 2: Generate Kotlin game engine source files for all 3 versions"""
import os

BASE = "/home/z/my-project"
VERSIONS = [
    {"name": "heroes-lore-v1", "pkg": "com.heroeslore.v1", "variant": 1},
    {"name": "heroes-lore-v2", "pkg": "com.heroeslore.v2", "variant": 2},
    {"name": "heroes-lore-v3", "pkg": "com.heroeslore.v3", "variant": 3},
]

def w(path, content):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, 'w', encoding='utf-8') as f:
        f.write(content)

# ============================================================
# Shared game constants and data
# ============================================================
GAME_DATA_KT = r'''package {pkg}

object GameData {
    // Screen
    const val DESIGN_WIDTH = 320
    const val DESIGN_HEIGHT = 240
    const val TILE_W = 32
    const val TILE_H = 16
    
    // Game states
    const val STATE_TITLE = 0
    const val STATE_CLASS_SELECT = 1
    const val STATE_GAMEPLAY = 2
    const val STATE_INVENTORY = 3
    const val STATE_DIALOG = 4
    const val STATE_PAUSED = 5
    const val STATE_GAME_OVER = 6
    const val STATE_SKILLS = 7
    
    // Character classes (6 classes from original game)
    data class HeroClass(val id: Int, val nameRu: String, val baseHp: Int, val baseAtk: Int, val baseDef: Int, val baseSpd: Int, val desc: String)
    
    val CLASSES = arrayOf(
        HeroClass(0, "Воин", 150, 18, 12, 8, "Могучий воин ближнего боя. Высокое здоровье и атака."),
        HeroClass(1, "Ассасин", 100, 20, 6, 15, "Ловкий убийца. Быстрые атаки и критический урон."),
        HeroClass(2, "Рыцарь", 180, 15, 16, 6, "Закрытый рыцарь. Лучшая защита и выживаемость."),
        HeroClass(3, "Стрелок", 90, 22, 5, 12, "Меткий стрелок. Атаки на дальнюю дистанцию."),
        HeroClass(4, "Ганблейдер", 120, 21, 10, 10, "Мастер огнестрельного оружия. Сбалансированный боец."),
        HeroClass(5, "Элементалист", 80, 25, 4, 10, "Маг стихий. Мощные заклинания, слабая защита.")
    )
    
    // Items
    data class Item(val id: Int, val nameRu: String, val desc: String, val type: Int, val value: Int, val price: Int)
    
    val ITEMS = arrayOf(
        Item(0, "Малое зелье HP", "Восстанавливает 50 HP", 0, 50, 10),
        Item(1, "Зелье HP", "Восстанавливает 150 HP", 0, 150, 30),
        Item(2, "Большое зелье HP", "Восстанавливает 500 HP", 0, 500, 80),
        Item(3, "Железный меч", "Базовый меч", 1, 5, 50),
        Item(4, "Стальной меч", "Улучшенный меч", 1, 12, 150),
        Item(5, "Меч теней", "Тёмный меч с бонусом крита", 1, 20, 400),
        Item(6, "Кожаная броня", "Лёгкая броня", 2, 5, 60),
        Item(7, "Кольчуга", "Средняя броня", 2, 12, 200),
        Item(8, "Платиновая броня", "Тяжёлая броня", 2, 22, 600),
        Item(9, "Кольцо силы", "+5 к атаке", 3, 5, 100),
        Item(10, "Амулет защиты", "+8 к защите", 3, 8, 120),
        Item(11, "Ботинки скорости", "+3 к скорости", 3, 3, 90),
    )
    
    // Enemies
    data class EnemyDef(val id: Int, val nameRu: String, val hp: Int, val atk: Int, val def: Int, val spd: Int, val exp: Int, val gold: Int)
    
    val ENEMIES = arrayOf(
        EnemyDef(0, "Слизень", 30, 5, 2, 3, 10, 5),
        EnemyDef(1, "Летучая мышь", 25, 8, 1, 7, 12, 6),
        EnemyDef(2, "Гоблин", 50, 10, 5, 5, 20, 12),
        EnemyDef(3, "Скелет", 60, 12, 8, 4, 25, 15),
        EnemyDef(4, "Орк", 100, 15, 10, 4, 40, 25),
        EnemyDef(5, "Тёмный рыцарь", 150, 20, 15, 5, 60, 40),
        EnemyDef(6, "Дракон", 300, 30, 20, 8, 150, 100),
        EnemyDef(7, "Демон", 250, 28, 18, 10, 120, 80),
        EnemyDef(8, "Некромант", 120, 25, 8, 6, 80, 50),
        EnemyDef(9, "Босс: Тёмный Властелин", 500, 35, 25, 6, 300, 200),
    )
    
    // Skills
    data class Skill(val id: Int, val nameRu: String, val desc: String, val manaCost: Int, val damage: Int, val reqLevel: Int)
    
    val SKILLS = arrayOf(
        Skill(0, "Удар мечом", "Мощный удар оружием", 5, 30, 1),
        Skill(1, "Вихрь", "Атака по площади", 15, 50, 3),
        Skill(2, "Огненный шар", "Запускает огненный снаряд", 10, 40, 2),
        Skill(3, "Ледяная стрела", "Ледяная атака замедляет врага", 12, 45, 4),
        Skill(4, "Молния", "Удар молнией", 20, 70, 5),
        Skill(5, "Лечение", "Восстанавливает HP", 15, -80, 3),
    )
    
    // Map tile types
    const val TILE_GRASS = 0
    const val TILE_WALL = 1
    const val TILE_WATER = 2
    const val TILE_PATH = 3
    const val TILE_SAND = 4
    const val TILE_TREE = 5
    const val TILE_FLOOR = 6
    
    // Map data (sample map 20x20)
    val SAMPLE_MAP = arrayOf(
        intArrayOf(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5),
        intArrayOf(5,3,3,3,3,5,0,0,0,0,0,0,0,0,5,3,3,3,3,5),
        intArrayOf(5,3,0,0,3,3,0,0,0,0,0,0,0,0,3,3,0,0,3,5),
        intArrayOf(5,3,0,0,0,3,0,0,0,0,0,0,0,0,3,0,0,0,3,5),
        intArrayOf(5,3,0,0,0,3,0,0,6,6,6,6,0,0,3,0,0,0,3,5),
        intArrayOf(5,3,3,3,3,1,0,0,6,6,6,6,0,0,1,3,3,3,3,5),
        intArrayOf(5,0,0,0,0,1,0,0,1,6,6,1,0,0,1,0,0,0,0,5),
        intArrayOf(5,0,0,0,0,0,0,0,1,6,6,1,0,0,0,0,0,0,0,5),
        intArrayOf(5,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,5),
        intArrayOf(5,0,0,2,2,2,0,0,0,0,0,0,0,2,2,2,0,0,0,5),
        intArrayOf(5,0,0,2,2,2,0,0,0,0,0,0,0,2,2,2,0,0,0,5),
        intArrayOf(5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),
        intArrayOf(5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),
        intArrayOf(5,3,3,3,1,1,1,3,3,0,3,3,1,1,1,3,3,3,5),
        intArrayOf(5,3,0,0,0,0,0,0,3,0,3,0,0,0,0,0,0,3,5),
        intArrayOf(5,3,0,0,0,0,0,0,3,0,3,0,0,0,0,0,0,3,5),
        intArrayOf(5,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,5),
        intArrayOf(5,3,0,0,0,0,0,0,3,0,3,0,0,0,0,0,0,3,5),
        intArrayOf(5,3,3,3,3,3,3,3,3,0,3,3,3,3,3,3,3,3,5),
        intArrayOf(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5),
    )

    const val MAP_W = 20
    const val MAP_H = 20
    
    // Russian text strings
    object Strings {
        val TITLE = "Герои Лор: Ноль"
        val PRESS_START = "Нажмите чтобы начать"
        val SELECT_CLASS = "Выберите класс"
        val START_GAME = "Начать игру"
        val HP = "HP"
        val MP = "МП"
        val EXP = "Опыт"
        val LEVEL = "Уровень"
        val GOLD = "Золото"
        val ATTACK = "Атака"
        val DEFENSE = "Защита"
        val SPEED = "Скорость"
        val INVENTORY = "Инвентарь"
        val SKILLS = "Навыки"
        val EQUIP = "Экипировать"
        val USE = "Использовать"
        val DROP = "Выбросить"
        val BACK = "Назад"
        val PAUSED = "Пауза"
        val RESUME = "Продолжить"
        val QUIT = "Выйти"
        val GAME_OVER = "Игра окончена"
        val VICTORY = "Победа!"
        val LEVEL_UP = "Новый уровень!"
        val NEW_SKILL = "Новый навык доступен!"
        val DAMAGE = "Урон"
        val HEAL = "Лечение"
        val CRIT = "Критический удар!"
        val ENEMY_DEFEATED = "Враг повержен!"
        val LOOT = "Добыча"
    }
}
'''
package com.heroeslore.v1

object GameData {
    const val TILE_W = 40
    const val TILE_H = 20
    const val MAP_W = 20
    const val MAP_H = 20
    
    const val ST_TITLE = 0
    const val ST_CLASS_SEL = 1
    const val ST_PLAY = 2
    const val ST_INV = 3
    const val ST_PAUSE = 4
    const val ST_DEAD = 5
    const val ST_DIALOG = 6
    
    data class Cls(val id: Int, val name: String, val hp: Int, val atk: Int, val def: Int, val spd: Int, val desc: String)
    val CLASSES = arrayOf(
        Cls(0, "Воин", 150, 18, 12, 8, "Могучий воин ближнего боя"),
        Cls(1, "Ассасин", 100, 20, 6, 15, "Ловкий убийца, быстрые атаки"),
        Cls(2, "Рыцарь", 180, 15, 16, 6, "Лучшая защита"),
        Cls(3, "Стрелок", 90, 22, 5, 12, "Меткий стрелок, дальний бой"),
        Cls(4, "Ганблейдер", 120, 21, 10, 10, "Огнестрельное оружие"),
        Cls(5, "Элементалист", 80, 25, 4, 10, "Маг стихий")
    )

    data class Itm(val id: Int, val name: String, val desc: String, val type: Int, val value: Int, val price: Int)
    val ITEMS = arrayOf(
        Itm(0, "Зелье HP", "+50 HP", 0, 50, 10),
        Itm(1, "Зелье HP+", "+150 HP", 0, 150, 30),
        Itm(2, "Зелье MP", "+30 МП", 0, 30, 15),
        Itm(3, "Железный меч", "Атака +5", 1, 5, 50),
        Itm(4, "Стальной меч", "Атака +12", 1, 12, 150),
        Itm(5, "Меч теней", "Атака +20, крит", 1, 20, 400),
        Itm(6, "Кожаная броня", "Защита +5", 2, 5, 60),
        Itm(7, "Кольчуга", "Защита +12", 2, 12, 200),
        Itm(8, "Кольцо силы", "Атака +3", 3, 3, 80),
        Itm(9, "Амулет защиты", "Защита +5", 3, 5, 100),
        Itm(10, "Ботинки скорости", "Скорость +3", 3, 3, 90)
    )

    data class EDef(val id: Int, val name: String, val hp: Int, val atk: Int, val def: Int, val spd: Int, val exp: Int, val gold: Int)
    val ENEMIES = arrayOf(
        EDef(0, "Слизень", 30, 5, 2, 3, 10, 5),
        EDef(1, "Летучая мышь", 25, 8, 1, 7, 12, 6),
        EDef(2, "Гоблин", 50, 10, 5, 5, 20, 12),
        EDef(3, "Скелет", 60, 12, 8, 4, 25, 15),
        EDef(4, "Орк", 100, 15, 10, 4, 40, 25),
        EDef(5, "Тёмный рыцарь", 150, 20, 15, 5, 60, 40),
        EDef(6, "Дракон", 300, 30, 20, 8, 150, 100),
        EDef(7, "Демон", 250, 28, 18, 10, 120, 80),
        EDef(8, "Некромант", 120, 25, 8, 6, 80, 50),
        EDef(9, "Тёмный Властелин", 500, 35, 25, 6, 300, 200)
    )

    data class Skl(val id: Int, val name: String, val mp: Int, val dmg: Int, val lvl: Int)
    val SKILLS = arrayOf(
        Skl(0, "Удар мечом", 5, 30, 1),
        Skl(1, "Вихрь", 15, 50, 3),
        Skl(2, "Огненный шар", 10, 40, 2),
        Skl(3, "Ледяная стрела", 12, 45, 4),
        Skl(4, "Молния", 20, 70, 5),
        Skl(5, "Лечение", 15, -80, 3)
    )

    const val T_GRASS = 0; const val T_WALL = 1; const val T_WATER = 2
    const val T_PATH = 3; const val T_TREE = 5; const val T_FLOOR = 6

    val MAP = arrayOf(
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
        intArrayOf(5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)
    )

    object T {
        val TITLE = "Герои Лор: Ноль"
        val TAP = "Нажмите чтобы начать"
        val SEL_CLS = "Выберите класс героя"
        val HP = "HP"; val MP = "МП"; val EXP = "Опыт"
        val LVL = "Ур."; val GOLD = "Золото"
        val ATK = "Атака"; val DEF = "Защита"; val SPD = "Скорость"
        val INV = "Инвентарь"; val SKL = "Навыки"
        val BACK = "Назад"; val PAUSE = "Пауза"
        val RESUME = "Продолжить"; val QUIT = "Выйти"
        val DEAD = "Герой погиб!"; val WIN = "Победа!"
        val LVLUP = "Новый уровень!"
        val CRIT = "КРИТ!"; val MISS = "Промах!"
        val NO_MP = "Недостаточно МП!"
    }
}

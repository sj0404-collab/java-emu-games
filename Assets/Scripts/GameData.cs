using UnityEngine;
using System.Collections.Generic;

namespace HeroesLore
{
    public static class GameData
    {
        public const int TILE_W = 40;
        public const int TILE_H = 20;
        public const int MAP_W = 20;
        public const int MAP_H = 20;

        public const int ST_TITLE = 0;
        public const int ST_CLASS_SEL = 1;
        public const int ST_PLAY = 2;
        public const int ST_INV = 3;
        public const int ST_PAUSE = 4;
        public const int ST_DEAD = 5;
        public const int ST_DIALOG = 6;

        public const int T_GRASS = 0;
        public const int T_WALL = 1;
        public const int T_WATER = 2;
        public const int T_PATH = 3;
        public const int T_SAND = 4;
        public const int T_TREE = 5;
        public const int T_FLOOR = 6;

        public class ClsDef
        {
            public int id; public string name; public int hp; public int atk; public int def; public int spd; public string desc;
            public ClsDef(int id, string name, int hp, int atk, int def, int spd, string desc)
            { this.id = id; this.name = name; this.hp = hp; this.atk = atk; this.def = def; this.spd = spd; this.desc = desc; }
        }

        public static readonly ClsDef[] CLASSES = new ClsDef[]
        {
            new ClsDef(0, "Воин", 150, 18, 12, 8, "Могучий воин ближнего боя"),
            new ClsDef(1, "Ассасин", 100, 20, 6, 15, "Ловкий убийца, быстрые атаки"),
            new ClsDef(2, "Рыцарь", 180, 15, 16, 6, "Лучшая защита"),
            new ClsDef(3, "Стрелок", 90, 22, 5, 12, "Меткий стрелок, дальний бой"),
            new ClsDef(4, "Ганблейдер", 120, 21, 10, 10, "Огнестрельное оружие"),
            new ClsDef(5, "Элементалист", 80, 25, 4, 10, "Маг стихий")
        };

        public class ItemDef
        {
            public int id; public string name; public string desc; public int type; public int value; public int price;
            public ItemDef(int id, string name, string desc, int type, int value, int price)
            { this.id = id; this.name = name; this.desc = desc; this.type = type; this.value = value; this.price = price; }
        }

        public static readonly ItemDef[] ITEMS = new ItemDef[]
        {
            new ItemDef(0, "Зелье HP", "+50 HP", 0, 50, 10),
            new ItemDef(1, "Зелье HP+", "+150 HP", 0, 150, 30),
            new ItemDef(2, "Зелье MP", "+30 МП", 0, 30, 15),
            new ItemDef(3, "Железный меч", "Атака +5", 1, 5, 50),
            new ItemDef(4, "Стальной меч", "Атака +12", 1, 12, 150),
            new ItemDef(5, "Меч теней", "Атака +20, крит", 1, 20, 400),
            new ItemDef(6, "Кожаная броня", "Защита +5", 2, 5, 60),
            new ItemDef(7, "Кольчуга", "Защита +12", 2, 12, 200),
            new ItemDef(8, "Кольцо силы", "Атака +3", 3, 3, 80),
            new ItemDef(9, "Амулет защиты", "Защита +5", 3, 5, 100),
            new ItemDef(10, "Ботинки скорости", "Скорость +3", 3, 3, 90)
        };

        public class EnemyDef
        {
            public int id; public string name; public int hp; public int atk; public int def; public int spd; public int exp; public int gold;
            public EnemyDef(int id, string name, int hp, int atk, int def, int spd, int exp, int gold)
            { this.id = id; this.name = name; this.hp = hp; this.atk = atk; this.def = def; this.spd = spd; this.exp = exp; this.gold = gold; }
        }

        public static readonly EnemyDef[] ENEMIES = new EnemyDef[]
        {
            new EnemyDef(0, "Слизень", 30, 5, 2, 3, 10, 5),
            new EnemyDef(1, "Летучая мышь", 25, 8, 1, 7, 12, 6),
            new EnemyDef(2, "Гоблин", 50, 10, 5, 5, 20, 12),
            new EnemyDef(3, "Скелет", 60, 12, 8, 4, 25, 15),
            new EnemyDef(4, "Орк", 100, 15, 10, 4, 40, 25),
            new EnemyDef(5, "Тёмный рыцарь", 150, 20, 15, 5, 60, 40),
            new EnemyDef(6, "Дракон", 300, 30, 20, 8, 150, 100),
            new EnemyDef(7, "Демон", 250, 28, 18, 10, 120, 80),
            new EnemyDef(8, "Некромант", 120, 25, 8, 6, 80, 50),
            new EnemyDef(9, "Тёмный Властелин", 500, 35, 25, 6, 300, 200)
        };

        public class SkillDef
        {
            public int id; public string name; public int mp; public int dmg; public int lvl;
            public SkillDef(int id, string name, int mp, int dmg, int lvl)
            { this.id = id; this.name = name; this.mp = mp; this.dmg = dmg; this.lvl = lvl; }
        }

        public static readonly SkillDef[] SKILLS = new SkillDef[]
        {
            new SkillDef(0, "Удар мечом", 5, 30, 1),
            new SkillDef(1, "Вихрь", 15, 50, 3),
            new SkillDef(2, "Огненный шар", 10, 40, 2),
            new SkillDef(3, "Ледяная стрела", 12, 45, 4),
            new SkillDef(4, "Молния", 20, 70, 5),
            new SkillDef(5, "Лечение", 15, -80, 3)
        };

        public static readonly int[,] MAP = new int[,]
        {
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,3,3,3,3,5,0,0,0,0,0,0,0,0,5,3,3,3,3,5},
            {5,3,0,0,3,3,0,0,0,0,0,0,0,0,3,3,0,0,3,5},
            {5,3,0,0,0,3,0,0,0,0,0,0,0,0,3,0,0,0,3,5},
            {5,3,0,0,0,3,0,0,6,6,6,6,0,0,3,0,0,0,3,5},
            {5,3,3,3,3,1,0,0,6,6,6,6,0,0,1,3,3,3,3,5},
            {5,0,0,0,0,1,0,0,1,6,6,1,0,0,1,0,0,0,0,5},
            {5,0,0,0,0,0,0,0,1,6,6,1,0,0,0,0,0,0,0,5},
            {5,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,5},
            {5,0,0,2,2,2,0,0,0,0,0,0,0,2,2,2,0,0,0,5},
            {5,0,0,2,2,2,0,0,0,0,0,0,0,2,2,2,0,0,0,5},
            {5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5},
            {5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5},
            {5,3,3,3,1,1,1,3,3,0,3,3,1,1,1,3,3,3,5},
            {5,3,0,0,0,0,0,0,3,0,3,0,0,0,0,0,0,3,5},
            {5,3,0,0,0,0,0,0,3,0,3,0,0,0,0,0,0,3,5},
            {5,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,5},
            {5,3,0,0,0,0,0,0,3,0,3,0,0,0,0,0,0,3,5},
            {5,3,3,3,3,3,3,3,3,0,3,3,3,3,3,3,3,3,5},
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}
        };

        public static class T
        {
            public const string TITLE = "Герои Лор: Ноль";
            public const string TAP = "Нажмите чтобы начать";
            public const string SEL_CLS = "Выберите класс героя";
            public const string HP = "HP"; public const string MP = "МП"; public const string EXP = "Опыт";
            public const string LVL = "Ур."; public const string GOLD = "Золото";
            public const string ATK = "Атака"; public const string DEF = "Защита"; public const string SPD = "Скорость";
            public const string INV = "Инвентарь"; public const string SKL = "Навыки";
            public const string BACK = "Назад"; public const string PAUSE = "Пауза";
            public const string RESUME = "Продолжить"; public const string QUIT = "Выйти";
            public const string DEAD = "Герой погиб!"; public const string WIN = "Победа!";
            public const string LVLUP = "Новый уровень!";
            public const string CRIT = "КРИТ!"; public const string MISS = "Промах!";
            public const string NO_MP = "Недостаточно МП!";
        }

        public static readonly Color[] TILE_COLORS = new Color[]
        {
            new Color(0.29f, 0.55f, 0.25f),  // grass
            new Color(0.4f, 0.4f, 0.4f),     // wall
            new Color(0.2f, 0.4f, 0.67f),    // water
            new Color(0.77f, 0.66f, 0.38f),  // path
            new Color(0.83f, 0.75f, 0.56f),  // sand
            new Color(0.18f, 0.42f, 0.12f),  // tree
            new Color(0.55f, 0.45f, 0.33f)   // floor
        };

        public static readonly Color[] TILE_DARK = new Color[]
        {
            new Color(0.24f, 0.48f, 0.20f),
            new Color(0.33f, 0.33f, 0.33f),
            new Color(0.16f, 0.33f, 0.56f),
            new Color(0.66f, 0.56f, 0.31f),
            new Color(0.73f, 0.66f, 0.47f),
            new Color(0.14f, 0.35f, 0.09f),
            new Color(0.48f, 0.39f, 0.28f)
        };

        public static readonly Color[] CLASS_COLORS = new Color[]
        {
            new Color(1f, 0.27f, 0.27f),  // Warrior - red
            new Color(0.27f, 1f, 0.27f),  // Assassin - green
            new Color(0.27f, 0.27f, 1f),   // Knight - blue
            new Color(1f, 1f, 0.27f),      // Archer - yellow
            new Color(0.27f, 1f, 1f),      // Gunblader - cyan
            new Color(1f, 0.27f, 1f)       // Elementalist - magenta
        };
    }
}

using UnityEngine;
using System.Collections.Generic;

namespace HeroesLore
{
    public class Hero
    {
        public int clsId;
        public string clsName;
        public float x = 5f, y = 5f;
        public int dir; // 0=down,1=left,2=right,3=up
        public bool moving, attacking;
        public int attackTimer, animFrame, animTimer;

        public int level = 1, exp, expNext = 50, gold;
        public int maxHp, hp, maxMp, mp;
        public int baseAtk, baseDef, baseSpd;
        public int bonusAtk, bonusDef, bonusSpd;
        public int attackCd, hurtTimer;

        public int[] equipment = new int[3] { -1, -1, -1 };
        public List<int> inventory = new List<int>();
        public List<int> learnedSkills = new List<int> { 0 };

        public int Atk => baseAtk + bonusAtk + level * 2;
        public int Def => baseDef + bonusDef + level;
        public int Spd => baseSpd + bonusSpd;

        public Hero(int clsId)
        {
            this.clsId = clsId;
            clsName = GameData.CLASSES[clsId].name;
            var c = GameData.CLASSES[clsId];
            maxHp = c.hp; hp = maxHp;
            maxMp = 30 + clsId * 5; mp = maxMp;
            baseAtk = c.atk; baseDef = c.def; baseSpd = c.spd;
        }

        public void AddExp(int amount)
        {
            exp += amount;
            while (exp >= expNext)
            {
                exp -= expNext;
                level++;
                expNext = (int)(expNext * 1.5f);
                maxHp += 10 + clsId * 2;
                maxMp += 3 + clsId;
                hp = maxHp; mp = maxMp;
                foreach (var sk in GameData.SKILLS)
                {
                    if (sk.lvl == level && !learnedSkills.Contains(sk.id))
                        learnedSkills.Add(sk.id);
                }
            }
        }

        public void AddItem(int id) { inventory.Add(id); }

        public bool UseItem(int id)
        {
            var item = GameData.ITEMS[id];
            if (item.type == 0)
            {
                if (item.value > 0 && item.name.Contains("HP"))
                    hp = Mathf.Min(hp + item.value, maxHp);
                else if (item.name.Contains("МП"))
                    mp = Mathf.Min(mp + item.value, maxMp);
                inventory.Remove(id);
                return true;
            }
            return false;
        }

        public void EquipItem(int id)
        {
            var item = GameData.ITEMS[id];
            int slot = item.type == 1 ? 0 : item.type == 2 ? 1 : item.type == 3 ? 2 : -1;
            if (slot < 0) return;

            if (equipment[slot] >= 0)
            {
                inventory.Add(equipment[slot]);
                var old = GameData.ITEMS[equipment[slot]];
                if (slot == 0) bonusAtk -= old.value;
                else if (slot == 1) bonusDef -= old.value;
                else bonusSpd -= old.value;
            }
            equipment[slot] = id;
            inventory.Remove(id);
            if (slot == 0) bonusAtk += item.value;
            else if (slot == 1) bonusDef += item.value;
            else bonusSpd += item.value;
        }

        public void TakeDamage(int dmg)
        {
            int actual = Mathf.Max(1, dmg - Def / 2);
            hp -= actual; hurtTimer = 15;
            if (hp < 0) hp = 0;
        }

        public void Heal(int amount) { hp = Mathf.Min(hp + amount, maxHp); }
    }

    public class Enemy
    {
        public GameData.EnemyDef def;
        public float x, y;
        public int hp, maxHp;
        public bool alive = true;
        public int dir, animFrame, animTimer, attackCd, hurtTimer, aiTimer;

        public Enemy(int defId, int tx, int ty)
        {
            def = GameData.ENEMIES[defId];
            x = tx; y = ty;
            hp = def.hp; maxHp = def.hp;
        }

        public bool Update(float heroX, float heroY)
        {
            if (!alive) return false;
            if (hurtTimer > 0) hurtTimer--;
            if (attackCd > 0) attackCd--;
            animTimer++;
            if (animTimer > 8) { animTimer = 0; animFrame = (animFrame + 1) % 4; }

            aiTimer++;
            float dist = Mathf.Sqrt((x - heroX) * (x - heroX) + (y - heroY) * (y - heroY));

            if (dist < 2.0f && attackCd <= 0)
            {
                attackCd = 30 - def.spd;
                return true;
            }

            if (dist < 6.0f && aiTimer % Mathf.Max(1, 12 - def.spd / 2) == 0)
            {
                float dx = heroX - x, dy = heroY - y;
                float nx = x + (dx > 0.3f ? 0.5f : dx < -0.3f ? -0.5f : 0f);
                float ny = y + (dy > 0.3f ? 0.5f : dy < -0.3f ? -0.5f : 0f);
                int nxi = (int)nx, nyi = (int)ny;
                if (nxi >= 0 && nxi < GameData.MAP_W && nyi >= 0 && nyi < GameData.MAP_H)
                {
                    int tile = GameData.MAP[nyi, nxi];
                    if (tile != GameData.T_WALL && tile != GameData.T_WATER && tile != GameData.T_TREE)
                    { x = nx; y = ny; }
                }
            }
            return false;
        }

        public int TakeDamage(int dmg)
        {
            int actual = Mathf.Max(1, dmg - def.def / 3);
            hp -= actual; hurtTimer = 10;
            if (hp <= 0) { hp = 0; alive = false; }
            return actual;
        }
    }

    public class FloatText
    {
        public string text;
        public float x, y;
        public Color color;
        public int life = 60;
        public FloatText(string text, float x, float y, Color color)
        { this.text = text; this.x = x; this.y = y; this.color = color; }
        public bool Update() { y += 0.01f; life--; return life > 0; }
    }

    public class Drop
    {
        public int itemId; public float x, y;
        public Drop(int itemId, float x, float y) { this.itemId = itemId; this.x = x; this.y = y; }
    }

    public class GameCore
    {
        public int state = GameData.ST_TITLE;
        public Hero hero;
        public List<Enemy> enemies = new List<Enemy>();
        public List<FloatText> floatTexts = new List<FloatText>();
        public List<Drop> drops = new List<Drop>();

        public float cameraX, cameraY;
        public int classSelIndex;
        public int invScroll;
        public string dialogText = "";
        public int dialogTimer;
        public int titleBlink;
        public int killCount, totalKills = 10;
        public int screenW, screenH;

        // Input
        public float inputDx, inputDy;
        public bool inputAttack, inputSkill, inputMenu;
        public bool inputConfirm, inputCancel;
        private bool _confirm, _cancel, _menu;

        public System.Random rng = new System.Random();

        public GameCore(int w, int h) { screenW = w; screenH = h; SpawnEnemies(); }

        public void SetConfirm() { _confirm = true; }
        public void SetCancel() { _cancel = true; }
        public void SetMenu() { _menu = true; }

        void SpawnEnemies()
        {
            enemies.Clear();
            var positions = new List<Vector2>();
            for (int y = 0; y < GameData.MAP_H; y++)
                for (int x = 0; x < GameData.MAP_W; x++)
                {
                    int t = GameData.MAP[y, x];
                    if ((t == GameData.T_GRASS || t == GameData.T_PATH || t == GameData.T_FLOOR)
                        && x > 3 && y > 3 && Mathf.Abs(x - 5f) > 2f && Mathf.Abs(y - 5f) > 2f)
                        positions.Add(new Vector2(x, y));
                }
            Shuffle(positions);
            int count = Mathf.Min(15, positions.Count);
            int maxE = Mathf.Min(GameData.ENEMIES.Length, 3 + killCount / 3);
            for (int i = 0; i < count; i++)
            {
                int eid = rng.Next(0, maxE);
                enemies.Add(new Enemy(eid, (int)positions[i].x, (int)positions[i].y));
            }
        }

        void Shuffle<T>(List<T> list)
        {
            for (int i = list.Count - 1; i > 0; i--)
            {
                int j = rng.Next(i + 1);
                T tmp = list[i]; list[i] = list[j]; list[j] = tmp;
            }
        }

        public void StartGame(int clsId)
        {
            hero = new Hero(clsId);
            hero.x = 5f; hero.y = 5f;
            killCount = 0; totalKills = 10;
            enemies.Clear(); floatTexts.Clear(); drops.Clear();
            SpawnEnemies();
            state = GameData.ST_PLAY;
        }

        public void Update()
        {
            titleBlink++;
            inputConfirm = _confirm; inputCancel = _cancel; inputMenu = _menu;
            _confirm = _cancel = _menu = false;

            switch (state)
            {
                case GameData.ST_TITLE:
                    if (inputConfirm || inputAttack) state = GameData.ST_CLASS_SEL;
                    break;
                case GameData.ST_CLASS_SEL:
                    if (inputDy > 0.3f) { classSelIndex = (classSelIndex + 1) % GameData.CLASSES.Length; inputDy = 0f; }
                    if (inputDy < -0.3f) { classSelIndex = (classSelIndex - 1 + GameData.CLASSES.Length) % GameData.CLASSES.Length; inputDy = 0f; }
                    if (inputConfirm || inputAttack) StartGame(classSelIndex);
                    break;
                case GameData.ST_PLAY: UpdateGameplay(); break;
                case GameData.ST_INV: UpdateInventory(); break;
                case GameData.ST_PAUSE:
                    if (inputConfirm) state = GameData.ST_PLAY;
                    if (inputCancel || inputMenu) state = GameData.ST_PLAY;
                    break;
                case GameData.ST_DEAD:
                    dialogTimer++;
                    if (inputConfirm && dialogTimer > 60) state = GameData.ST_TITLE;
                    break;
                case GameData.ST_DIALOG:
                    dialogTimer--;
                    if (dialogTimer <= 0 || inputConfirm) state = GameData.ST_PLAY;
                    break;
            }
            inputConfirm = false; inputCancel = false; inputMenu = false;
        }

        void UpdateGameplay()
        {
            var h = hero; if (h == null) return;

            if (inputMenu) { state = GameData.ST_PAUSE; inputMenu = false; return; }

            // Movement
            if (h.attackTimer <= 0)
            {
                float dx = inputDx, dy = inputDy;
                if (dx != 0f || dy != 0f)
                {
                    float len = Mathf.Sqrt(dx * dx + dy * dy);
                    if (len > 0) { dx /= len; dy /= len; }
                    float speed = 0.08f + h.Spd * 0.005f;
                    float nx = h.x + dx * speed, ny = h.y + dy * speed;

                    if (Mathf.Abs(dx) > Mathf.Abs(dy))
                        h.dir = dx > 0 ? 2 : 1;
                    else
                        h.dir = dy > 0 ? 0 : 3;
                    h.moving = true;

                    int nxi = (int)nx, nyi = (int)ny;
                    if (nxi >= 0 && nxi < GameData.MAP_W && nyi >= 0 && nyi < GameData.MAP_H)
                    {
                        int tile = GameData.MAP[nyi, nxi];
                        if (tile != GameData.T_WALL && tile != GameData.T_WATER && tile != GameData.T_TREE)
                        { h.x = nx; h.y = ny; }
                    }
                    h.animTimer++;
                    if (h.animTimer > 6) { h.animTimer = 0; h.animFrame = (h.animFrame + 1) % 4; }
                }
                else { h.moving = false; h.animFrame = 0; }
            }

            if (h.attackTimer > 0) h.attackTimer--;
            if (h.attackCd > 0) h.attackCd--;
            if (h.hurtTimer > 0) h.hurtTimer--;

            // Hero attack
            if (inputAttack && h.attackCd <= 0 && h.attackTimer <= 0)
            {
                h.attackTimer = 12;
                h.attackCd = 15 - h.Spd / 3;
                h.attacking = true;
                float range = 1.8f;
                foreach (var e in enemies)
                {
                    if (!e.alive) continue;
                    float dist = Mathf.Sqrt((h.x - e.x) * (h.x - e.x) + (h.y - e.y) * (h.y - e.y));
                    if (dist < range)
                    {
                        bool crit = rng.Next(10) < 2;
                        int dmg = h.Atk + rng.Next(0, h.Atk / 2 + 1);
                        if (crit) dmg = (int)(dmg * 1.8f);
                        int actual = e.TakeDamage(dmg);
                        Color c = crit ? Color.yellow : Color.white;
                        floatTexts.Add(new FloatText(crit ? actual + " " + GameData.T.CRIT : "-" + actual, e.x, e.y - 0.5f, c));
                        if (!e.alive)
                        {
                            h.AddExp(e.def.exp); h.gold += e.def.gold; killCount++;
                            floatTexts.Add(new FloatText("+" + e.def.exp + "xp +" + e.def.gold + "g", e.x, e.y - 1f, Color.green));
                            if (rng.Next(5) == 0)
                            {
                                int itemId = rng.Next(0, Mathf.Min(3, GameData.ITEMS.Length));
                                drops.Add(new Drop(itemId, e.x, e.y));
                            }
                            int oldLvl = h.level;
                            if (h.level > oldLvl)
                                floatTexts.Add(new FloatText(GameData.T.LVLUP, h.x, h.y - 1.5f, new Color(1f, 0.84f, 0f)));
                            if (enemies.FindAll(e2 => e2.alive).Count < 3)
                            { SpawnEnemies(); totalKills += 5; }
                        }
                    }
                }
            }
            else { h.attacking = false; }

            // Skill
            if (inputSkill && h.attackCd <= 0)
            {
                int lastSk = h.learnedSkills.Count > 0 ? h.learnedSkills[h.learnedSkills.Count - 1] : 0;
                var sk = GameData.SKILLS[lastSk];
                if (h.mp >= sk.mp)
                {
                    h.mp -= sk.mp; h.attackCd = 20;
                    if (sk.dmg < 0)
                    {
                        h.Heal(-sk.dmg);
                        floatTexts.Add(new FloatText("+" + (-sk.dmg) + "HP", h.x, h.y - 1f, Color.green));
                    }
                    else
                    {
                        foreach (var e in enemies)
                        {
                            if (!e.alive) continue;
                            float dist = Mathf.Sqrt((h.x - e.x) * (h.x - e.x) + (h.y - e.y) * (h.y - e.y));
                            if (dist < 3.5f)
                            {
                                int actual = e.TakeDamage(sk.dmg + h.Atk / 2);
                                floatTexts.Add(new FloatText("-" + actual, e.x, e.y - 0.5f, new Color(1f, 0.4f, 0f)));
                                if (!e.alive) { h.AddExp(e.def.exp); h.gold += e.def.gold; killCount++; }
                            }
                        }
                    }
                }
                else { floatTexts.Add(new FloatText(GameData.T.NO_MP, h.x, h.y - 1f, Color.red)); }
                inputSkill = false;
            }

            // Pick up drops
            for (int i = drops.Count - 1; i >= 0; i--)
            {
                var d = drops[i];
                float dist = Mathf.Sqrt((h.x - d.x) * (h.x - d.x) + (h.y - d.y) * (h.y - d.y));
                if (dist < 1.2f)
                {
                    h.AddItem(d.itemId);
                    floatTexts.Add(new FloatText("+" + GameData.ITEMS[d.itemId].name, h.x, h.y - 1f, Color.cyan));
                    drops.RemoveAt(i);
                }
            }

            // Update enemies
            for (int i = enemies.Count - 1; i >= 0; i--)
            {
                var e = enemies[i];
                if (!e.alive) { enemies.RemoveAt(i); continue; }
                bool attacks = e.Update(h.x, h.y);
                if (attacks && h.hurtTimer <= 0)
                {
                    int dmg = e.def.atk + rng.Next(0, e.def.atk / 2 + 1);
                    h.TakeDamage(dmg);
                    floatTexts.Add(new FloatText("-" + dmg, h.x, h.y - 0.5f, new Color(1f, 0.27f, 0.27f)));
                }
            }

            // Float texts
            for (int i = floatTexts.Count - 1; i >= 0; i--)
                if (!floatTexts[i].Update()) floatTexts.RemoveAt(i);

            // Camera
            float isoX = (h.x - h.y) * GameData.TILE_W / 2f;
            float isoY = (h.x + h.y) * GameData.TILE_H / 2f;
            cameraX += (isoX - screenW / 2f - cameraX) * 0.1f;
            cameraY += (isoY - screenH / 2f - cameraY) * 0.1f;

            // MP regen
            if (h.hp > 0 && h.attackTimer <= 0) h.mp = Mathf.Min(h.mp + 1, h.maxMp);

            // Death
            if (h.hp <= 0)
            { state = GameData.ST_DEAD; dialogText = GameData.T.DEAD; dialogTimer = 0; }

            // Win
            if (killCount >= totalKills)
            {
                state = GameData.ST_DIALOG;
                dialogText = GameData.T.WIN + " Убито: " + killCount;
                dialogTimer = 120; killCount = 0; totalKills += 10;
                SpawnEnemies();
            }
        }

        void UpdateInventory()
        {
            var h = hero; if (h == null) return;
            if (inputCancel || inputMenu) { state = GameData.ST_PLAY; inputCancel = false; inputMenu = false; return; }
            if (h.inventory.Count > 0)
            {
                if (inputDy > 0.3f) { invScroll = (invScroll + 1) % h.inventory.Count; inputDy = 0f; }
                if (inputDy < -0.3f) { invScroll = (invScroll - 1 + h.inventory.Count) % h.inventory.Count; inputDy = 0f; }
                if (inputConfirm && invScroll < h.inventory.Count)
                {
                    int itemId = h.inventory[invScroll];
                    var item = GameData.ITEMS[itemId];
                    if (item.type == 0) { h.UseItem(itemId); if (invScroll >= h.inventory.Count) invScroll = Mathf.Max(0, h.inventory.Count - 1); }
                    else { h.EquipItem(itemId); if (invScroll >= h.inventory.Count) invScroll = Mathf.Max(0, h.inventory.Count - 1); }
                }
            }
            inputConfirm = false;
        }

        public Vector2 IsoToScreen(float tx, float ty)
        {
            float ix = (tx - ty) * GameData.TILE_W / 2f - cameraX;
            float iy = (tx + ty) * GameData.TILE_H / 2f - cameraY;
            return new Vector2(ix + screenW / 2f, iy + screenH / 2f);
        }
    }
}
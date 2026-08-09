using UnityEngine;
using UnityEngine.UI;
using System.Collections.Generic;

namespace HeroesLore
{
    public class GameBootstrap : MonoBehaviour
    {
        GameCore core;
        Camera cam;
        Canvas uiCanvas;
        CanvasScaler scaler;
        GameObject worldRoot;
        Transform tilesParent;
        Transform entitiesParent;
        Transform floatsParent;
        Transform dropsParent;
        Transform waterParent;

        // Tile renderers
        SpriteRenderer[,] tileRenderers;
        SpriteRenderer[] waterHighlights;
        SpriteRenderer[] treeTops;

        // Hero visual
        GameObject heroObj;
        SpriteRenderer heroBody, heroHead, heroWeapon, heroShadow;
        Text heroNameText;
        Image heroHpBar, heroHpBarBg;

        // Enemy visuals
        List<EnemyVisual> enemyVisuals = new List<EnemyVisual>();
        class EnemyVisual
        {
            public GameObject obj;
            public SpriteRenderer body, head, eyeL, eyeR, shadow, nameBg, hpBar, hpBarBg;
            public Text nameText;
            public Enemy enemy;
        }

        // Drop visuals
        List<GameObject> dropVisuals = new List<GameObject>();
        List<Drop> dropData = new List<Drop>();

        // Float text visuals
        List<GameObject> floatVisuals = new List<GameObject>();
        List<FloatText> floatData = new List<FloatText>();

        // HUD
        GameObject hudPanel;
        Text hpText, mpText, expText, statsText, infoText, skillText;
        Image hpBarImg, mpBarImg;

        // Title screen
        GameObject titlePanel;
        Text titleText, tapText, versionText;

        // Class select
        GameObject classPanel;
        Text classTitleText;
        GameObject[] classItems;
        Text[] classNames, classStats, classDescs;
        Image[] classBgs, classIcons;

        // Pause
        GameObject pausePanel;
        Text pauseText, pauseHint;

        // Death
        GameObject deathPanel;
        Text deathText, deathHint;

        // Dialog
        GameObject dialogPanel;
        Text dialogContent;

        // Inventory
        GameObject invPanel;
        Text invTitle, invHint, invEmpty;
        Text[] invItemTexts;
        Image[] invItemBgs;

        // Virtual D-pad
        VirtualDPad dpad;

        // Gamepad
        GamepadInput gamepad;

        // Design resolution (reference)
        float designW = 800f, designH = 480f;

        void Awake()
        {
            Screen.orientation = ScreenOrientation.LandscapeLeft;
            Screen.sleepTimeout = SleepTimeout.NeverSleep;
            Application.targetFrameRate = 60;
            QualitySettings.vSyncCount = 0;
        }

        void Start()
        {
            designW = Screen.width;
            designH = Screen.height;

            // Setup camera
            cam = Camera.main;
            cam.orthographic = true;
            cam.orthographicSize = designH / 2f;
            cam.backgroundColor = Color.black;
            cam.transform.position = new Vector3(0, 0, -100f);

            // Generate sprites
            ProceduralSprites.GenerateAll();

            // Create world root
            worldRoot = new GameObject("World");
            tilesParent = new GameObject("Tiles").transform;
            tilesParent.SetParent(worldRoot.transform);
            entitiesParent = new GameObject("Entities").transform;
            entitiesParent.SetParent(worldRoot.transform);
            floatsParent = new GameObject("Floats").transform;
            floatsParent.SetParent(worldRoot.transform);
            dropsParent = new GameObject("Drops").transform;
            dropsParent.SetParent(worldRoot.transform);
            waterParent = new GameObject("Water").transform;
            waterParent.SetParent(worldRoot.transform);

            // Create UI Canvas
            CreateUICanvas();
            CreateHUD();
            CreateTitleScreen();
            CreateClassSelect();
            CreatePauseScreen();
            CreateDeathScreen();
            CreateDialogBox();
            CreateInventoryUI();

            // Create D-pad
            dpad = gameObject.AddComponent<VirtualDPad>();
            dpad.Init(uiCanvas.transform, designW, designH);

            // Gamepad
            gamepad = gameObject.AddComponent<GamepadInput>();

            // Create tile map visuals
            CreateTileMap();

            // Create hero visual
            CreateHeroVisual();

            // Init game core
            core = new GameCore((int)designW, (int)designH);

            // Hide all UI initially
            HideAllUI();
            titlePanel.SetActive(true);
        }

        void CreateUICanvas()
        {
            GameObject canvasObj = new GameObject("UICanvas");
            uiCanvas = canvasObj.AddComponent<Canvas>();
            uiCanvas.renderMode = RenderMode.ScreenSpaceOverlay;
            uiCanvas.sortingOrder = 100;
            scaler = canvasObj.AddComponent<CanvasScaler>();
            scaler.uiScaleMode = CanvasScaler.ScaleMode.ConstantPixelSize;
            scaler.scaleFactor = 1f;
            canvasObj.AddComponent<GraphicRaycaster>();
        }

        void CreateHUD()
        {
            hudPanel = CreatePanel(uiCanvas.transform, new Rect(0, 0, 250, 80), new Color(0, 0, 0, 0.63f));
            hudPanel.SetActive(false);

            // HP
            hpText = CreateText(hudPanel.transform, "HP: 0/0", 14, TextAnchor.UpperLeft,
                new Vector2(4, -14), Color.white, FontStyle.Bold);
            var hpBg = CreateImage(hudPanel.transform, new Rect(4, -28, 200, 10), Color.gray);
            hpBarImg = CreateImage(hudPanel.transform, new Rect(4, -28, 200, 10), Color.green);

            // MP
            mpText = CreateText(hudPanel.transform, "МП: 0/0", 14, TextAnchor.UpperLeft,
                new Vector2(4, -46), Color.white, FontStyle.Bold);
            CreateImage(hudPanel.transform, new Rect(4, -56, 200, 10), Color.gray);
            mpBarImg = CreateImage(hudPanel.transform, new Rect(4, -56, 200, 10), Color.blue);

            // EXP
            expText = CreateText(hudPanel.transform, "Опыт: 0/0", 12, TextAnchor.UpperLeft,
                new Vector2(4, -72), Color.white);

            // Stats (top-right)
            var statsPanel = CreatePanel(uiCanvas.transform, new Rect(designW - 210, 0, 210, 60), new Color(0, 0, 0, 0.63f));
            statsPanel.SetActive(false);
            statsText = CreateText(statsPanel.transform, "", 13, TextAnchor.UpperRight,
                new Vector2(-4, -14), Color.white);
            skillText = CreateText(statsPanel.transform, "", 11, TextAnchor.UpperRight,
                new Vector2(-4, -46), Color.cyan);

            // Bottom info
            var infoPanel = CreatePanel(uiCanvas.transform, new Rect(0, designH - 26, 350, 26), new Color(0, 0, 0, 0.47f));
            infoPanel.SetActive(false);
            infoText = CreateText(infoPanel.transform, "", 11, TextAnchor.MiddleLeft,
                new Vector2(4, -16), Color.gray);

            // Store panels for show/hide
            hudPanel.GetComponent<RectTransform>().SetSiblingIndex(0);
            statsPanel.transform.SetAsFirstSibling();
            infoPanel.transform.SetAsFirstSibling();
        }

        GameObject CreatePanel(Transform parent, Rect rect, Color bg)
        {
            var go = new GameObject("Panel");
            go.transform.SetParent(parent);
            var rt = go.AddComponent<RectTransform>();
            rt.anchorMin = rt.anchorMax = Vector2.zero;
            rt.pivot = new Vector2(0, 1);
            rt.anchoredPosition = new Vector2(rect.x, -rect.y);
            rt.sizeDelta = new Vector2(rect.width, rect.height);
            var img = go.AddComponent<Image>();
            img.color = bg;
            return go;
        }

        Text CreateText(Transform parent, string text, int fontSize, TextAnchor anchor, Vector2 pos, Color color, FontStyle style = FontStyle.Normal)
        {
            var go = new GameObject("Text");
            go.transform.SetParent(parent);
            var rt = go.AddComponent<RectTransform>();
            rt.anchorMin = rt.anchorMax = new Vector2(0, 1);
            rt.pivot = new Vector2(0, 1);
            rt.anchoredPosition = pos;
            var txt = go.AddComponent<Text>();
            txt.text = text;
            txt.fontSize = fontSize;
            txt.alignment = anchor;
            txt.color = color;
            txt.fontStyle = style;
            txt.font = Resources.GetBuiltinResource<Font>("Arial.ttf");
            return txt;
        }

        Image CreateImage(Transform parent, Rect rect, Color color)
        {
            var go = new GameObject("Img");
            go.transform.SetParent(parent);
            var rt = go.AddComponent<RectTransform>();
            rt.anchorMin = rt.anchorMax = new Vector2(0, 1);
            rt.pivot = new Vector2(0, 1);
            rt.anchoredPosition = new Vector2(rect.x, -rect.y);
            rt.sizeDelta = new Vector2(rect.width, rect.height);
            var img = go.AddComponent<Image>();
            img.color = color;
            return img;
        }

        void CreateTitleScreen()
        {
            titlePanel = new GameObject("Title");
            titlePanel.transform.SetParent(uiCanvas.transform);
            var rt = titlePanel.AddComponent<RectTransform>();
            rt.anchorMin = Vector2.zero; rt.anchorMax = Vector2.one;
            rt.sizeDelta = Vector2.zero;

            titleText = CreateText(titlePanel.transform, GameData.T.TITLE, 40, TextAnchor.MiddleCenter,
                new Vector2(designW / 2, -designH * 0.35f), Color.white, FontStyle.Bold);
            tapText = CreateText(titlePanel.transform, GameData.T.TAP, 20, TextAnchor.MiddleCenter,
                new Vector2(designW / 2, -designH * 0.55f), Color.yellow);
            versionText = CreateText(titlePanel.transform, "v2.0 Unity | Android", 14, TextAnchor.MiddleCenter,
                new Vector2(designW / 2, -designH * 0.85f), Color.gray);
            titlePanel.SetActive(false);
        }

        void CreateClassSelect()
        {
            classPanel = new GameObject("ClassSel");
            classPanel.transform.SetParent(uiCanvas.transform);
            var rt = classPanel.AddComponent<RectTransform>();
            rt.anchorMin = Vector2.zero; rt.anchorMax = Vector2.one;
            rt.sizeDelta = Vector2.zero;

            classTitleText = CreateText(classPanel.transform, GameData.T.SEL_CLS, 26, TextAnchor.MiddleCenter,
                new Vector2(designW / 2, -40), Color.white, FontStyle.Bold);

            classItems = new GameObject[GameData.CLASSES.Length];
            classNames = new Text[GameData.CLASSES.Length];
            classStats = new Text[GameData.CLASSES.Length];
            classDescs = new Text[GameData.CLASSES.Length];
            classBgs = new Image[GameData.CLASSES.Length];
            classIcons = new Image[GameData.CLASSES.Length];

            float startY = 70f;
            float itemH = (designH - startY - 20f) / GameData.CLASSES.Length;

            for (int i = 0; i < GameData.CLASSES.Length; i++)
            {
                float y = startY + i * itemH;
                var cls = GameData.CLASSES[i];
                classItems[i] = CreatePanel(classPanel.transform,
                    new Rect(20, y, designW - 40, itemH - 4), new Color(0.12f, 0.12f, 0.24f, 0.4f));
                classBgs[i] = classItems[i].GetComponent<Image>();

                // Class icon
                classIcons[i] = CreateImage(classItems[i].transform, new Rect(10, itemH / 2 - 18, 32, 32), GameData.CLASS_COLORS[i]);

                classNames[i] = CreateText(classItems[i].transform, cls.name, 20, TextAnchor.UpperLeft,
                    new Vector2(55, -20), Color.white, FontStyle.Bold);
                classStats[i] = CreateText(classItems[i].transform,
                    "HP:" + cls.hp + " ATK:" + cls.atk + " DEF:" + cls.def + " SPD:" + cls.spd,
                    14, TextAnchor.UpperLeft, new Vector2(55, -38), Color.lightGray);
                classDescs[i] = CreateText(classItems[i].transform, cls.desc,
                    12, TextAnchor.UpperLeft, new Vector2(55, -52), Color.gray);
            }
            classPanel.SetActive(false);
        }

        void CreatePauseScreen()
        {
            pausePanel = new GameObject("Pause");
            pausePanel.transform.SetParent(uiCanvas.transform);
            var rt = pausePanel.AddComponent<RectTransform>();
            rt.anchorMin = Vector2.zero; rt.anchorMax = Vector2.one;
            rt.sizeDelta = Vector2.zero;
            pausePanel.AddComponent<Image>().color = new Color(0, 0, 0, 0.63f);

            pauseText = CreateText(pausePanel.transform, GameData.T.PAUSE, 32, TextAnchor.MiddleCenter,
                new Vector2(designW / 2, -designH / 2 + 20), Color.white, FontStyle.Bold);
            pauseHint = CreateText(pausePanel.transform,
                GameData.T.RESUME + ": [OK]  " + GameData.T.QUIT + ": [X]",
                18, TextAnchor.MiddleCenter, new Vector2(designW / 2, -designH / 2 - 20), Color.yellow);
            pausePanel.SetActive(false);
        }

        void CreateDeathScreen()
        {
            deathPanel = new GameObject("Death");
            deathPanel.transform.SetParent(uiCanvas.transform);
            var rt = deathPanel.AddComponent<RectTransform>();
            rt.anchorMin = Vector2.zero; rt.anchorMax = Vector2.one;
            rt.sizeDelta = Vector2.zero;
            deathPanel.AddComponent<Image>().color = new Color(0, 0, 0, 0.59f);

            deathText = CreateText(deathPanel.transform, GameData.T.DEAD, 36, TextAnchor.MiddleCenter,
                new Vector2(designW / 2, -designH / 2), Color.red, FontStyle.Bold);
            deathHint = CreateText(deathPanel.transform, GameData.T.TAP, 18, TextAnchor.MiddleCenter,
                new Vector2(designW / 2, -designH / 2 + 40), Color.white);
            deathPanel.SetActive(false);
        }

        void CreateDialogBox()
        {
            dialogPanel = new GameObject("Dialog");
            dialogPanel.transform.SetParent(uiCanvas.transform);
            var rt = dialogPanel.AddComponent<RectTransform>();
            rt.anchorMin = rt.anchorMax = new Vector2(0.5f, 0.5f);
            rt.pivot = new Vector2(0.5f, 0.5f);
            rt.anchoredPosition = Vector2.zero;
            rt.sizeDelta = new Vector2(designW * 0.8f, 50);
            var img = dialogPanel.AddComponent<Image>();
            img.color = new Color(0.08f, 0.08f, 0.2f, 0.78f);

            dialogContent = CreateText(dialogPanel.transform, "", 18, TextAnchor.MiddleCenter,
                new Vector2(designW * 0.4f, -30), Color.white, FontStyle.Bold);
            dialogPanel.SetActive(false);
        }

        void CreateInventoryUI()
        {
            float pw = designW * 0.6f, ph = designH * 0.7f;
            float px = (designW - pw) / 2f, py = (designH - ph) / 2f;

            invPanel = CreatePanel(uiCanvas.transform, new Rect(px, py, pw, ph), new Color(0.08f, 0.08f, 0.16f, 0.78f));
            invPanel.SetActive(false);

            invTitle = CreateText(invPanel.transform, GameData.T.INV, 20, TextAnchor.MiddleCenter,
                new Vector2(pw / 2, -24), Color.yellow, FontStyle.Bold);
            invHint = CreateText(invPanel.transform,
                GameData.T.BACK + ":[M] Исп./Экип.:[OK]",
                12, TextAnchor.MiddleCenter, new Vector2(pw / 2, -ph + 12), Color.gray);
            invEmpty = CreateText(invPanel.transform, "Пусто", 16, TextAnchor.MiddleCenter,
                new Vector2(pw / 2, -ph / 2), Color.gray);

            invItemTexts = new Text[8];
            invItemBgs = new Image[8];
            for (int i = 0; i < 8; i++)
            {
                float iy = 44 + i * 22;
                invItemBgs[i] = CreateImage(invPanel.transform, new Rect(8, iy, pw - 16, 20), Color.clear);
                invItemTexts[i] = CreateText(invPanel.transform, "", 15, TextAnchor.UpperLeft,
                    new Vector2(16, -iy - 2), Color.white);
            }
        }

        void CreateTileMap()
        {
            tileRenderers = new SpriteRenderer[GameData.MAP_W, GameData.MAP_H];
            var waterList = new List<SpriteRenderer>();
            var treeList = new List<SpriteRenderer>();

            for (int my = 0; my < GameData.MAP_H; my++)
            {
                for (int mx = 0; mx < GameData.MAP_W; mx++)
                {
                    int tile = GameData.MAP[my, mx];
                    float ix = (mx - my) * GameData.TILE_W / 2f;
                    float iy = (mx + my) * GameData.TILE_H / 2f;

                    var go = new GameObject("Tile_" + mx + "_" + my);
                    go.transform.SetParent(tilesParent);
                    go.transform.position = new Vector3(ix, iy, my * 0.01f);

                    var sr = go.AddComponent<SpriteRenderer>();
                    sr.sprite = ProceduralSprites.tileSprites[tile];
                    sr.sortingOrder = my;
                    tileRenderers[mx, my] = sr;

                    if (tile == GameData.T_WATER)
                    {
                        var wh = new GameObject("Water_" + mx + "_" + my);
                        wh.transform.SetParent(waterParent);
                        wh.transform.position = new Vector3(ix, iy, my * 0.01f + 0.001f);
                        var wsr = wh.AddComponent<SpriteRenderer>();
                        wsr.sprite = ProceduralSprites.waterHighlight;
                        wsr.sortingOrder = my + 1;
                        waterList.Add(wsr);
                    }

                    if (tile == GameData.T_TREE)
                    {
                        var tt = new GameObject("TreeTop_" + mx + "_" + my);
                        tt.transform.SetParent(entitiesParent);
                        tt.transform.position = new Vector3(ix, iy - 8f, my * 0.01f + 0.01f);
                        var tsr = tt.AddComponent<SpriteRenderer>();
                        tsr.sprite = ProceduralSprites.treeTopSprite;
                        tsr.sortingOrder = (int)(my * 100 + 50);
                        treeList.Add(tsr);
                    }
                }
            }
            waterHighlights = waterList.ToArray();
            treeTops = treeList.ToArray();
        }

        void CreateHeroVisual()
        {
            heroObj = new GameObject("Hero");
            heroObj.transform.SetParent(entitiesParent);

            heroShadow = CreateSR(heroObj, Color.black, "Shadow");
            heroShadow.transform.localScale = new Vector3(2f, 0.5f, 1f);
            heroShadow.sortingOrder = 0;

            heroBody = CreateSR(heroObj, Color.red, "Body");
            heroBody.transform.localScale = new Vector3(1.6f, 2f, 1f);
            heroBody.sortingOrder = 1;

            heroHead = CreateSR(heroObj, new Color(1f, 0.84f, 0.63f), "Head");
            heroHead.sortingOrder = 2;

            heroWeapon = CreateSR(heroObj, Color.lightGray, "Weapon");
            heroWeapon.sortingOrder = 2;
            heroWeapon.transform.localScale = new Vector3(0.2f, 1.4f, 1f);

            heroObj.SetActive(false);
        }

        SpriteRenderer CreateSR(GameObject parent, Color color, string name)
        {
            var go = new GameObject(name);
            go.transform.SetParent(parent.transform);
            var sr = go.AddComponent<SpriteRenderer>();
            sr.color = color;
            sr.sprite = ProceduralSprites.dropSprite; // reuse circle sprite
            return sr;
        }

        void HideAllUI()
        {
            titlePanel.SetActive(false);
            classPanel.SetActive(false);
            pausePanel.SetActive(false);
            deathPanel.SetActive(false);
            dialogPanel.SetActive(false);
            invPanel.SetActive(false);
            hudPanel.SetActive(false);
            // Hide HUD sub-panels
            foreach (Transform t in uiCanvas.transform)
            {
                if (t.gameObject != titlePanel && t.gameObject != classPanel &&
                    t.gameObject != pausePanel && t.gameObject != deathPanel &&
                    t.gameObject != dialogPanel && t.gameObject != invPanel &&
                    t.gameObject != hudPanel && t.name != "DpadRoot")
                    t.gameObject.SetActive(false);
            }
        }

        void ShowHUD(bool show)
        {
            hudPanel.SetActive(show);
            foreach (Transform t in uiCanvas.transform)
            {
                if (t.gameObject != titlePanel && t.gameObject != classPanel &&
                    t.gameObject != pausePanel && t.gameObject != deathPanel &&
                    t.gameObject != dialogPanel && t.gameObject != invPanel &&
                    t.gameObject != hudPanel && t.name != "DpadRoot")
                    t.gameObject.SetActive(show);
            }
        }

        // ---- UPDATE ----
        void Update()
        {
            // Input from D-pad
            if (dpad != null)
            {
                core.inputDx = dpad.Direction.x;
                core.inputDy = dpad.Direction.y;
                if (dpad.AttackPressed) { core.inputAttack = true; dpad.AttackPressed = false; }
                if (dpad.SkillPressed) { core.inputSkill = true; dpad.SkillPressed = false; }
                if (dpad.MenuPressed) core.SetMenu();
                if (dpad.ConfirmPressed) core.SetConfirm();
                if (dpad.CancelPressed) core.SetCancel();
            }
            // Gamepad
            if (gamepad != null)
            {
                core.inputDx = Mathf.Max(Mathf.Abs(core.inputDx), Mathf.Abs(gamepad.Dx)) > 0.1f
                    ? (core.inputDx + gamepad.Dx) : gamepad.Dx;
                core.inputDy = Mathf.Max(Mathf.Abs(core.inputDy), Mathf.Abs(gamepad.Dy)) > 0.1f
                    ? (core.inputDy + gamepad.Dy) : gamepad.Dy;
                if (gamepad.AttackPressed) { core.inputAttack = true; }
                if (gamepad.SkillPressed) { core.inputSkill = true; }
                if (gamepad.MenuPressed) core.SetMenu();
                if (gamepad.ConfirmPressed) core.SetConfirm();
                if (gamepad.CancelPressed) core.SetCancel();
            }

            core.Update();
            UpdateVisuals();
            UpdateUI();
        }

        void UpdateVisuals()
        {
            if (core.hero != null)
            {
                var h = core.hero;
                var sp = core.IsoToScreen(h.x, h.y);
                // Convert screen to world (screen center = world 0,0)
                Vector3 wpos = ScreenToWorld(sp);
                heroObj.transform.position = wpos;
                heroObj.SetActive(true);

                // Update body color
                bool isHurt = h.hurtTimer > 0 && (h.hurtTimer / 2) % 2 == 0;
                heroBody.color = isHurt ? Color.red : GameData.CLASS_COLORS[h.clsId];
                heroBody.transform.localPosition = new Vector3(0, -0.4f, 0);
                heroHead.transform.localPosition = new Vector3(0, -0.8f, 0);
                heroShadow.transform.localPosition = new Vector3(0, 0.2f, 0);

                // Direction
                float eyeOff = 0;
                if (h.dir == 1) eyeOff = -0.15f;
                else if (h.dir == 2) eyeOff = 0.15f;
                // Weapon
                if (h.attacking && h.attackTimer > 0)
                {
                    float progress = 1f - h.attackTimer / 12f;
                    float angle = -90f + progress * 180f;
                    float rad = angle * Mathf.Deg2Rad;
                    heroWeapon.transform.localPosition = new Vector3(Mathf.Cos(rad) * 0.9f, -0.4f + Mathf.Sin(rad) * 0.9f, 0);
                    heroWeapon.transform.rotation = Quaternion.Euler(0, 0, angle);
                }
                else
                {
                    float wx = h.dir == 1 ? -0.6f : 0.6f;
                    heroWeapon.transform.localPosition = new Vector3(wx, -0.4f, 0);
                    heroWeapon.transform.rotation = Quaternion.identity;
                }

                // Sort order based on Y
                int sortOrder = (int)(h.y * 100);
                heroBody.sortingOrder = sortOrder + 1;
                heroHead.sortingOrder = sortOrder + 2;
                heroWeapon.sortingOrder = sortOrder + 2;
                heroShadow.sortingOrder = sortOrder;
            }
            else
            {
                heroObj.SetActive(false);
            }

            // Update enemies
            SyncEnemyVisuals();

            // Update drops
            SyncDropVisuals();

            // Update float texts
            SyncFloatVisuals();

            // Water animation
            for (int i = 0; i < waterHighlights.Length; i++)
            {
                if (waterHighlights[i] != null)
                {
                    float wave = Mathf.Sin((i + core.titleBlink * 0.05f) * 1.5f) * 0.15f;
                    Vector3 p = waterHighlights[i].transform.position;
                    p.x = ((int)(i / 2) - (i % 2) * 0) * 1f + wave; // subtle
                    waterHighlights[i].transform.position = p;
                }
            }
        }

        Vector3 ScreenToWorld(Vector2 screen)
        {
            return new Vector3(screen.x - designW / 2f, -(screen.y - designH / 2f), 0);
        }

        void SyncEnemyVisuals()
        {
            // Remove dead enemy visuals
            for (int i = enemyVisuals.Count - 1; i >= 0; i--)
            {
                if (!enemyVisuals[i].enemy.alive || !core.enemies.Contains(enemyVisuals[i].enemy))
                {
                    Destroy(enemyVisuals[i].obj);
                    enemyVisuals.RemoveAt(i);
                }
            }

            // Create/update
            foreach (var e in core.enemies)
            {
                if (!e.alive) continue;
                var vis = enemyVisuals.Find(v => v.enemy == e);
                if (vis == null)
                {
                    vis = CreateEnemyVisual(e);
                    enemyVisuals.Add(vis);
                }

                var sp = core.IsoToScreen(e.x, e.y);
                vis.obj.transform.position = ScreenToWorld(sp);
                int sortOrder = (int)(e.y * 100);
                vis.body.sortingOrder = sortOrder + 1;

                bool isHurt = e.hurtTimer > 0 && (e.hurtTimer / 2) % 2 == 0;
                vis.body.color = isHurt ? Color.white : GameData.CLASS_COLORS[e.def.id % 5];

                // HP bar
                float hpRatio = (float)e.hp / e.maxHp;
                vis.hpBar.rectTransform.sizeDelta = new Vector2(20 * hpRatio, 3);
            }
        }

        EnemyVisual CreateEnemyVisual(Enemy e)
        {
            var go = new GameObject("Enemy_" + e.def.name);
            go.transform.SetParent(entitiesParent);

            var vis = new EnemyVisual { obj = go, enemy = e };

            vis.shadow = CreateSR(go, new Color(0, 0, 0, 0.24f), "Shadow");
            vis.shadow.transform.localScale = new Vector3(1.6f, 0.4f, 1f);

            int typeIdx = e.def.id % 5;
            vis.body = CreateSR(go, Color.white, "Body");
            vis.body.sprite = ProceduralSprites.enemySprites[typeIdx];

            vis.obj.SetActive(true);
            return vis;
        }

        void SyncDropVisuals()
        {
            // Clear old
            foreach (var dv in dropVisuals) Destroy(dv);
            dropVisuals.Clear();
            dropData.Clear();

            foreach (var d in core.drops)
            {
                var sp = core.IsoToScreen(d.x, d.y);
                var go = new GameObject("Drop");
                go.transform.SetParent(dropsParent);
                go.transform.position = ScreenToWorld(new Vector2(sp.x, sp.y - 6f));
                var sr = go.AddComponent<SpriteRenderer>();
                sr.sprite = ProceduralSprites.dropSprite;
                sr.sortingOrder = (int)(d.y * 100);
                // Bob animation
                float bob = Mathf.Sin(core.titleBlink * 0.1f) * 0.1f;
                go.transform.position += new Vector3(0, bob, 0);
                dropVisuals.Add(go);
                dropData.Add(d);
            }
        }

        void SyncFloatVisuals()
        {
            // Clear old
            foreach (var fv in floatVisuals) Destroy(fv);
            floatVisuals.Clear();
            floatData.Clear();

            foreach (var ft in core.floatTexts)
            {
                var sp = core.IsoToScreen(ft.x, ft.y);
                var go = new GameObject("Float");
                go.transform.SetParent(floatsParent);
                go.transform.position = ScreenToWorld(sp);

                var textGo = new GameObject("FText");
                textGo.transform.SetParent(go.transform);
                var txt = textGo.AddComponent<Text>();
                txt.text = ft.text;
                txt.fontSize = 14;
                txt.fontStyle = FontStyle.Bold;
                txt.color = ft.color;
                txt.alignment = TextAnchor.MiddleCenter;
                txt.font = Resources.GetBuiltinResource<Font>("Arial.ttf");

                // Billboard - face camera (for world-space text)
                go.transform.rotation = Quaternion.identity;

                floatVisuals.Add(go);
                floatData.Add(ft);
            }
        }

        void UpdateUI()
        {
            HideAllUI();

            switch (core.state)
            {
                case GameData.ST_TITLE:
                    titlePanel.SetActive(true);
                    tapText.enabled = (core.titleBlink / 30) % 2 == 0;
                    dpad.Visible = false;
                    break;

                case GameData.ST_CLASS_SEL:
                    classPanel.SetActive(true);
                    for (int i = 0; i < GameData.CLASSES.Length; i++)
                    {
                        bool sel = i == core.classSelIndex;
                        classBgs[i].color = sel ? new Color(0.24f, 0.24f, 0.47f, 0.71f) : new Color(0.12f, 0.12f, 0.24f, 0.4f);
                        classNames[i].color = sel ? Color.yellow : Color.white;
                    }
                    dpad.Visible = false;
                    break;

                case GameData.ST_PLAY:
                    ShowHUD(true);
                    UpdateHUD();
                    dpad.Visible = true;
                    break;

                case GameData.ST_INV:
                    ShowHUD(true);
                    UpdateHUD();
                    invPanel.SetActive(true);
                    UpdateInventoryUI();
                    dpad.Visible = true;
                    break;

                case GameData.ST_PAUSE:
                    ShowHUD(true);
                    pausePanel.SetActive(true);
                    dpad.Visible = false;
                    break;

                case GameData.ST_DEAD:
                    ShowHUD(true);
                    deathPanel.SetActive(true);
                    deathHint.enabled = core.dialogTimer > 60;
                    dpad.Visible = false;
                    break;

                case GameData.ST_DIALOG:
                    ShowHUD(true);
                    dialogPanel.SetActive(true);
                    dialogContent.text = core.dialogText;
                    dpad.Visible = false;
                    break;
            }
        }

        void UpdateHUD()
        {
            var h = core.hero; if (h == null) return;
            hpText.text = GameData.T.HP + ": " + h.hp + "/" + h.maxHp;
            mpText.text = GameData.T.MP + ": " + h.mp + "/" + h.maxMp;
            expText.text = GameData.T.EXP + ": " + h.exp + "/" + h.expNext;
            hpBarImg.rectTransform.sizeDelta = new Vector2(200 * ((float)h.hp / h.maxHp), 10);
            hpBarImg.color = h.hp > h.maxHp * 0.3f ? Color.green : Color.red;
            mpBarImg.rectTransform.sizeDelta = new Vector2(200 * ((float)h.mp / h.maxMp), 10);

            statsText.text = GameData.T.LVL + " " + h.level + " | " + GameData.T.GOLD + ": " + h.gold + "\n" +
                GameData.T.ATK + ":" + h.Atk + " " + GameData.T.DEF + ":" + h.Def + " " + GameData.T.SPD + ":" + h.Spd;
            int lastSk = h.learnedSkills.Count > 0 ? h.learnedSkills[h.learnedSkills.Count - 1] : 0;
            skillText.text = GameData.T.SKL + ": " + GameData.SKILLS[lastSk].name;
            infoText.text = "Меню:[M] Навык:[B] Инвентарь:[I] Убито:" + core.killCount;
        }

        void UpdateInventoryUI()
        {
            var h = core.hero; if (h == null) return;
            var inv = h.inventory;
            invEmpty.enabled = inv.Count == 0;

            int startI = Mathf.Max(0, core.invScroll - 4);
            for (int i = 0; i < 8; i++)
            {
                int idx = startI + i;
                if (idx < inv.Count)
                {
                    var item = GameData.ITEMS[inv[idx]];
                    invItemTexts[i].text = item.name + " - " + item.desc;
                    bool sel = idx == core.invScroll;
                    invItemBgs[i].color = sel ? new Color(0.31f, 0.31f, 0.59f, 0.4f) : Color.clear;
                    invItemTexts[i].color = sel ? Color.yellow : Color.white;
                    invItemTexts[i].fontStyle = sel ? FontStyle.Bold : FontStyle.Normal;
                    invItemTexts[i].enabled = true;
                }
                else
                {
                    invItemTexts[i].enabled = false;
                    invItemBgs[i].color = Color.clear;
                }
            }
        }
    }
}
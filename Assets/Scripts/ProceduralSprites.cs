using UnityEngine;

namespace HeroesLore
{
    public static class ProceduralSprites
    {
        static Texture2D CreateTileTexture(Color topColor, Color sideColor)
        {
            int w = GameData.TILE_W, h = GameData.TILE_H + 6; // extra for side
            var tex = new Texture2D(w, h, TextureFormat.RGBA32, false);
            Color[] pixels = new Color[w * h];
            float cx = w / 2f, cy = GameData.TILE_H / 2f;
            float hw = w / 2f, hh = GameData.TILE_H / 2f;

            for (int py = 0; py < h; py++)
            {
                for (int px = 0; px < w; px++)
                {
                    float dx = (px - cx) / hw;
                    float dy = (py - cy) / hh;

                    // Top face (diamond)
                    if (py < GameData.TILE_H && Mathf.Abs(dx) + Mathf.Abs(dy) <= 1f)
                    {
                        pixels[py * w + px] = topColor;
                    }
                    // Side face (bottom-right edge, 3D effect)
                    else if (py >= GameData.TILE_H - 1)
                    {
                        float sdy = (py - (GameData.TILE_H - 1)) / 3f;
                        float sdx = (px - cx + hw * sdy) / hw;
                        float sdy2 = (py - cy - hh) / (h - cy - hh);
                        if (Mathf.Abs(sdx) <= 1f && sdy2 <= 1f && sdy2 >= 0f)
                        {
                            pixels[py * w + px] = sideColor;
                        }
                    }
                    else
                    {
                        pixels[py * w + px] = Color.clear;
                    }
                }
            }
            tex.SetPixels(pixels);
            tex.Apply();
            tex.filterMode = FilterMode.Point;
            return tex;
        }

        public static Sprite[] tileSprites;
        public static Sprite treeTopSprite;
        public static Sprite heroSprite;
        public static Sprite[] enemySprites;
        public static Sprite dropSprite;
        public static Sprite waterHighlight;

        public static void GenerateAll()
        {
            tileSprites = new Sprite[GameData.TILE_COLORS.Length];
            for (int i = 0; i < GameData.TILE_COLORS.Length; i++)
            {
                var tex = CreateTileTexture(GameData.TILE_COLORS[i], GameData.TILE_DARK[i]);
                tileSprites[i] = Sprite.Create(tex, new Rect(0, 0, tex.width, tex.height),
                    new Vector2(0.5f, (GameData.TILE_H / 2f) / (GameData.TILE_H + 6f)), GameData.TILE_W);
            }

            // Tree top
            treeTopSprite = CreateCircleSprite(new Color(0.1f, 0.36f, 0.05f), 24);

            // Water highlight
            waterHighlight = CreateCircleSprite(new Color(0.39f, 0.71f, 1f, 0.31f), 12);

            // Drop sprite
            dropSprite = CreateCircleSprite(Color.yellow, 10);

            // Enemy sprites (by type category)
            enemySprites = new Sprite[5];
            enemySprites[0] = CreateOvalSprite(new Color(0.53f, 0.8f, 0.27f), 20, 12); // slime
            enemySprites[1] = CreateCircleSprite(new Color(0.53f, 0.27f, 0.67f), 12); // bat
            enemySprites[2] = CreateRoundRectSprite(new Color(0.67f, 0.4f, 0.2f), 14, 18); // goblin
            enemySprites[3] = CreateRoundRectSprite(new Color(0.8f, 0.8f, 0.67f), 14, 18); // skeleton
            enemySprites[4] = CreateRoundRectSprite(new Color(0.8f, 0.2f, 0.2f), 14, 18); // boss
        }

        static Sprite CreateCircleSprite(Color color, int radius)
        {
            int size = radius * 2 + 2;
            var tex = new Texture2D(size, size, TextureFormat.RGBA32, false);
            Color[] p = new Color[size * size];
            for (int y = 0; y < size; y++)
                for (int x = 0; x < size; x++)
                {
                    float d = Vector2.Distance(new Vector2(x, y), new Vector2(radius, radius));
                    p[y * size + x] = d <= radius ? color : Color.clear;
                }
            tex.SetPixels(p); tex.Apply(); tex.filterMode = FilterMode.Point;
            return Sprite.Create(tex, new Rect(0, 0, size, size), new Vector2(0.5f, 0.5f), 20f);
        }

        static Sprite CreateOvalSprite(Color color, int rw, int rh)
        {
            int w = rw * 2 + 2, h = rh * 2 + 2;
            var tex = new Texture2D(w, h, TextureFormat.RGBA32, false);
            Color[] p = new Color[w * h];
            for (int y = 0; y < h; y++)
                for (int x = 0; x < w; x++)
                {
                    float dx = (x - rw) / (float)rw;
                    float dy = (y - rh) / (float)rh;
                    p[y * w + x] = dx * dx + dy * dy <= 1f ? color : Color.clear;
                }
            tex.SetPixels(p); tex.Apply(); tex.filterMode = FilterMode.Point;
            return Sprite.Create(tex, new Rect(0, 0, w, h), new Vector2(0.5f, 0.5f), 20f);
        }

        static Sprite CreateRoundRectSprite(Color color, int w, int h)
        {
            var tex = new Texture2D(w, h, TextureFormat.RGBA32, false);
            Color[] p = new Color[w * h];
            for (int y = 0; y < h; y++)
                for (int x = 0; x < w; x++)
                {
                    bool inside = x > 2 && x < w - 3 && y > 2 && y < h - 3;
                    p[y * w + x] = inside ? color : Color.clear;
                }
            tex.SetPixels(p); tex.Apply(); tex.filterMode = FilterMode.Point;
            return Sprite.Create(tex, new Rect(0, 0, w, h), new Vector2(0.5f, 0.5f), 20f);
        }
    }
}
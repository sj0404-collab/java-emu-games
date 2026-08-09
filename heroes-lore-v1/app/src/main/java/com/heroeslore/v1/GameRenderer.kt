package com.heroeslore.v1

import android.graphics.*
import kotlin.math.*

class GameRenderer(val engine: GameEngine) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val tileColors = intArrayOf(
        Color.parseColor("#4a8c3f"), // grass
        Color.parseColor("#666666"), // wall
        Color.parseColor("#3366aa"), // water
        Color.parseColor("#c4a862"), // path
        Color.parseColor("#d4c090"), // sand
        Color.parseColor("#2d6b1e"), // tree
        Color.parseColor("#8b7355")  // floor
    )
    private val tileDark = intArrayOf(
        Color.parseColor("#3d7a34"),
        Color.parseColor("#555555"),
        Color.parseColor("#285590"),
        Color.parseColor("#a89050"),
        Color.parseColor("#bba878"),
        Color.parseColor("#245a18"),
        Color.parseColor("#7a6348")
    )

    private var titleBmp: Bitmap? = null
    private var faceBmps = arrayOfNulls<Bitmap>(3)
    
    fun loadAssets(am: android.content.res.AssetManager) {
        try { titleBmp = BitmapFactory.decodeStream(am.open("title.png")) } catch(_: Exception) {}
        for (i in 0..2) {
            try { faceBmps[i] = BitmapFactory.decodeStream(am.open("img/face_${i}.png")) } catch(_: Exception) {}
        }
    }

    fun render(canvas: Canvas) {
        canvas.drawColor(Color.BLACK)
        when (engine.state) {
            GameData.ST_TITLE -> drawTitle(canvas)
            GameData.ST_CLASS_SEL -> drawClassSelect(canvas)
            GameData.ST_PLAY, GameData.ST_DEAD, GameData.ST_DIALOG -> drawGameplay(canvas)
            GameData.ST_INV -> { drawGameplay(canvas); drawInventory(canvas) }
            GameData.ST_PAUSE -> { drawGameplay(canvas); drawPause(canvas) }
        }
    }

    private fun drawTitle(canvas: Canvas) {
        val w = engine.w; val h = engine.h
        
        // Draw title image centered
        titleBmp?.let {
            val scale = minOf(w / 400f, h / 200f)
            val bw = it.width * scale
            val bh = it.height * scale
            canvas.drawBitmap(it, null, RectF((w-bw)/2, h*0.15f, (w+bw)/2, h*0.15f+bh), paint)
        }

        // Title text
        paint.color = Color.WHITE
        paint.textSize = 36f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText(GameData.T.TITLE, w/2f, h * 0.35f, paint)

        // Blink "press start"
        if ((engine.titleBlink / 30) % 2 == 0) {
            paint.textSize = 18f
            paint.color = Color.YELLOW
            canvas.drawText(GameData.T.TAP, w/2f, h * 0.55f, paint)
        }

        // Version info
        paint.textSize = 12f
        paint.color = Color.GRAY
        canvas.drawText("v1.0 | Kotlin | Android", w/2f, h * 0.85f, paint)
    }

    private fun drawClassSelect(canvas: Canvas) {
        val w = engine.w; val h = engine.h
        paint.color = Color.WHITE
        paint.textAlign = Paint.Align.CENTER
        paint.textSize = 24f
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText(GameData.T.SEL_CLS, w/2f, 40f, paint)

        val startY = 70f
        val itemH = (h - startY - 20f) / GameData.CLASSES.size

        for (i in GameData.CLASSES.indices) {
            val cls = GameData.CLASSES[i]
            val y = startY + i * itemH
            val selected = i == engine.classSelIndex

            // Background
            paint.color = if (selected) Color.argb(180, 60, 60, 120) else Color.argb(100, 30, 30, 60)
            canvas.drawRect(20f, y, w - 20f, y + itemH - 4f, paint)

            // Class icon (colored circle)
 val colors = intArrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA)
            paint.color = colors[i % colors.size]
            canvas.drawCircle(50f, y + itemH / 2 - 2f, 16f, paint)

            // Face icon if available
            if (i < faceBmps.size && faceBmps[i] != null) {
                canvas.drawBitmap(faceBmps[i]!!, null, RectF(34f, y + itemH/2 - 18f, 66f, y + itemH/2 + 14f), paint)
            }

            // Name
            paint.color = if (selected) Color.YELLOW else Color.WHITE
            paint.textSize = 18f
            paint.textAlign = Paint.Align.LEFT
            canvas.drawText(cls.name, 75f, y + 20f, paint)

            // Stats
            paint.textSize = 12f
            paint.color = Color.LTGRAY
            val stats = "HP:${cls.hp} ATK:${cls.atk} DEF:${cls.def} SPD:${cls.spd}"
            canvas.drawText(stats, 75f, y + 36f, paint)

            // Description
            paint.textSize = 11f
            paint.color = Color.GRAY
            canvas.drawText(cls.desc, 75f, y + 50f, paint)
        }
    }

    private fun drawGameplay(canvas: Canvas) {
        val w = engine.w; val h = engine.h

        // Draw isometric map
        drawIsoMap(canvas)

        // Sort all entities by Y for proper overlap (painter's algorithm)
        val entities = mutableListOf<Triple<Float, Int, Any>>() // sortY, type(0=enemy,1=hero,2=drop), obj
        for (e in engine.enemies) {
            if (e.alive) entities.add(Triple(e.y, 0, e))
        }
        engine.hero?.let { entities.add(Triple(it.y, 1, it)) }
        for (d in engine.drops) {
            entities.add(Triple(d.third, 2, d))
        }
        entities.sortBy { it.first }

        for (ent in entities) {
            when (ent.second) {
                0 -> drawEnemy(canvas, ent.third as Enemy)
                1 -> drawHero(canvas, ent.third as Hero)
                2 -> drawDrop(canvas, ent.third as Triple<Int, Float, Float>)
            }
        }

        // Float texts
        for (ft in engine.floatTexts) {
            val (sx, sy) = engine.isoToScreen(ft.x, ft.y)
            paint.color = ft.color
            paint.textSize = 14f
            paint.textAlign = Paint.Align.CENTER
            paint.typeface = Typeface.DEFAULT_BOLD
            canvas.drawText(ft.text, sx, sy, paint)
        }

        // HUD
        drawHUD(canvas)

        // Overlays
        if (engine.state == GameData.ST_DEAD) {
            paint.color = Color.argb(150, 0, 0, 0)
            canvas.drawRect(0f, 0f, w.toFloat(), h.toFloat(), paint)
            paint.color = Color.RED
            paint.textSize = 32f
            paint.textAlign = Paint.Align.CENTER
            canvas.drawText(GameData.T.DEAD, w/2f, h/2f, paint)
            if (engine.dialogTimer > 60) {
                paint.color = Color.WHITE
                paint.textSize = 16f
                canvas.drawText(GameData.T.TAP, w/2f, h/2f + 40f, paint)
            }
        }
        if (engine.state == GameData.ST_DIALOG) {
            drawDialogBox(canvas, engine.dialogText, w/2f, h * 0.7f, w * 0.8f)
        }
    }

    private fun drawIsoMap(canvas: Canvas) {
        val tw = GameData.TILE_W
        val th = GameData.TILE_H
        val mapW = GameData.MAP_W
        val mapH = GameData.MAP_H

        for (my in 0 until mapH) {
            for (mx in 0 until mapW) {
                val (sx, sy) = engine.isoToScreen(mx.toFloat(), my.toFloat())
                // Cull off-screen
                if (sx < -tw || sx > engine.w + tw || sy < -th * 2 || sy > engine.h + th * 2) continue

                val tile = GameData.MAP[my][mx]
                if (tile < 0 || tile >= tileColors.size) continue

                // Draw diamond tile
                val cx = sx
                val cy = sy + th / 2f
                paint.color = tileColors[tile]
                val path = Path()
                path.moveTo(cx, cy - th/2f)        // top
                path.lineTo(cx + tw/2f, cy)          // right
                path.lineTo(cx, cy + th/2f)           // bottom
                path.lineTo(cx - tw/2f, cy)           // left
                path.close()
                canvas.drawPath(path, paint)

                // Tile edge (dark bottom-right)
                paint.color = tileDark[tile]
                val path2 = Path()
                path2.moveTo(cx, cy + th/2f)
                path2.lineTo(cx + tw/2f, cy)
                path2.lineTo(cx, cy + th/2f + 3f)
                path2.lineTo(cx - tw/2f, cy + 3f)
                path2.close()
                canvas.drawPath(path2, paint)

                // Water animation
                if (tile == GameData.T_WATER) {
                    paint.color = Color.argb(80, 100, 180, 255)
                    val wave = sin((mx + my + engine.titleBlink * 0.05f) * 1.5f) * 3f
                    canvas.drawCircle(cx + wave, cy, tw / 6f, paint)
                }

                // Tree top
                if (tile == GameData.T_TREE) {
                    paint.color = Color.parseColor("#1a5c0e")
                    canvas.drawCircle(cx, cy - 8f, 12f, paint)
                    paint.color = Color.parseColor("#228b22")
                    canvas.drawCircle(cx - 3f, cy - 10f, 8f, paint)
                }
            }
        }
    }

    private fun drawHero(canvas: Canvas, h: Hero) {
        val (sx, sy) = engine.isoToScreen(h.x, h.y)

        // Shadow
        paint.color = Color.argb(80, 0, 0, 0)
        canvas.drawOval(sx - 10f, sy - 2f, sx + 10f, sy + 4f, paint)

        // Flash red when hurt
        val isHurt = h.hurtTimer > 0 && (h.hurtTimer / 2) % 2 == 0
        
        val classColors = intArrayOf(0xFF4444.toInt(), 0x44FF44.toInt(), 0x4444FF.toInt(), 0xFFFF44.toInt(), 0x44FFFF.toInt(), 0xFF44FF.toInt())
        val bodyColor = if (isHurt) Color.RED else classColors[h.clsId % classColors.size]

        // Body
        paint.color = bodyColor
        canvas.drawRoundRect(sx - 8f, sy - 24f, sx + 8f, sy - 4f, 4f, 4f, paint)

        // Head
        paint.color = Color.parseColor("#FFD5A0")
        canvas.drawCircle(sx, sy - 28f, 7f, paint)

        // Eyes based on direction
        paint.color = Color.BLACK
        val eyeOffX = when(h.dir) { 1 -> -3f; 2 -> 3f; else -> 0f }
        canvas.drawCircle(sx + eyeOffX - 2f, sy - 29f, 1f, paint)
        canvas.drawCircle(sx + eyeOffX + 2f, sy - 29f, 1f, paint)

        // Weapon / attack animation
        if (h.attacking) {
            val progress = 1f - h.attackTimer / 12f
            val angle = -90f + progress * 180f
            paint.color = Color.LTGRAY
            paint.strokeWidth = 3f
            val rad = Math.toRadians(angle.toDouble())
            val wx = sx + cos(rad).toFloat() * 18f
            val wy = sy - 16f + sin(rad).toFloat() * 18f
            canvas.drawLine(sx, sy - 16f, wx, wy, paint)
            paint.strokeWidth = 1f
        } else {
 // Idle weapon
            paint.color = Color.LTGRAY
            val weaponX = when(h.dir) { 1 -> sx - 12f; 2 -> sx + 12f; else -> sx + 10f }
            canvas.drawRect(weaponX - 1f, sy - 22f, weaponX + 1f, sy - 8f, paint)
        }

        // Name
        paint.color = Color.WHITE
        paint.textSize = 10f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT
        canvas.drawText(h.clsName, sx, sy - 36f, paint)

        // HP bar above hero
        val barW = 24f
        paint.color = Color.DKGRAY
        canvas.drawRect(sx - barW/2, sy - 42f, sx + barW/2, sy - 39f, paint)
        paint.color = if (h.hp > h.maxHp * 0.3f) Color.GREEN else Color.RED
        canvas.drawRect(sx - barW/2, sy - 42f, sx - barW/2 + barW * (h.hp.toFloat() / h.maxHp), sy - 39f, paint)
    }

    private fun drawEnemy(canvas: Canvas, e: Enemy) {
        val (sx, sy) = engine.isoToScreen(e.x, e.y)

        // Shadow
        paint.color = Color.argb(60, 0, 0, 0)
        canvas.drawOval(sx - 8f, sy - 1f, sx + 8f, sy + 3f, paint)

        val isHurt = e.hurtTimer > 0 && (e.hurtTimer / 2) % 2 == 0

        // Enemy body - different shapes per type
        paint.color = if (isHurt) Color.WHITE else when(e.def.id % 5) {
            0 -> Color.parseColor("#88CC44")  // slime
            1 -> Color.parseColor("#8844AA")  // bat
            2 -> Color.parseColor("#AA6633")  // goblin
            3 -> Color.parseColor("#CCCCAA")  // skeleton
            else -> Color.parseColor("#CC3333") // boss
        }

        val bob = (sin(e.animFrame * PI / 2.0) * 2.0).toFloat()
        when (e.def.id % 5) {
            0 -> { // Slime - blob
                canvas.drawOval(sx - 10f, sy - 14f + bob, sx + 10f, sy - 2f, paint)
            }
            1 -> { // Bat - wings
                canvas.drawCircle(sx, sy - 10f + bob, 6f, paint)
                val wingFlap = (sin(e.animFrame * PI) * 8.0).toFloat()
                canvas.drawOval(sx - 16f, sy - 14f + bob - wingFlap, sx - 4f, sy - 6f + bob, paint)
                canvas.drawOval(sx + 4f, sy - 14f + bob - wingFlap, sx + 16f, sy - 6f + bob, paint)
            }
            else -> { // Humanoid
                canvas.drawRoundRect(sx - 7f, sy - 20f + bob, sx + 7f, sy - 2f, 3f, 3f, paint)
                paint.color = Color.parseColor("#FFD5A0")
                canvas.drawCircle(sx, sy - 23f + bob, 5f, paint)
            }
        }
        // Eyes
        paint.color = Color.RED
        canvas.drawCircle(sx - 2f, sy - (if(e.def.id%5==0) 10 else 23) + bob, 1.5f, paint)
        canvas.drawCircle(sx + 2f, sy - (if(e.def.id%5==0) 10 else 23) + bob, 1.5f, paint)

        // Name
        paint.color = Color.LTGRAY
        paint.textSize = 9f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT
        canvas.drawText(e.name, sx, sy - (if(e.def.id%5==0) 18 else 30) + bob, paint)

        // HP bar
        val barW = 20f
        paint.color = Color.DKGRAY
        canvas.drawRect(sx - barW/2, sy - (if(e.def.id%5==0) 22 else 34) + bob, sx + barW/2, sy - (if(e.def.id%5==0) 19 else 31) + bob, paint)
        paint.color = Color.RED
        val hpRatio = e.hp.toFloat() / e.maxHp
        canvas.drawRect(sx - barW/2, sy - (if(e.def.id%5==0) 22 else 34) + bob, sx - barW/2 + barW * hpRatio, sy - (if(e.def.id%5==0) 19 else 31) + bob, paint)
    }

    private fun drawDrop(canvas: Canvas, drop: Triple<Int, Float, Float>) {
        val (sx, sy) = engine.isoToScreen(drop.second, drop.third)
        paint.color = Color.YELLOW
        val bob = (sin(engine.titleBlink * 0.1f) * 2.0).toFloat()
        canvas.drawCircle(sx, sy - 6f + bob, 5f, paint)
        paint.color = Color.WHITE
        paint.textSize = 8f
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(GameData.ITEMS[drop.first].name, sx, sy - 14f + bob, paint)
    }

    private fun drawHUD(canvas: Canvas) {
        val h = engine.hero ?: return
        val w = engine.w
        val pad = 10f

        // Top-left: HP/MP bars
        paint.color = Color.argb(160, 0, 0, 0)
        canvas.drawRect(pad, pad, 200f, 72f, paint)

        // HP bar
        paint.color = Color.WHITE
        paint.textSize = 12f
        paint.textAlign = Paint.Align.LEFT
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText("${GameData.T.HP}: ${h.hp}/${h.maxHp}", pad + 4, pad + 14f, paint)
        paint.color = Color.DKGRAY
        canvas.drawRect(pad + 4, pad + 18f, pad + 196, pad + 28f, paint)
        paint.color = Color.GREEN
        canvas.drawRect(pad + 4, pad + 18f, pad + 4 + 192 * (h.hp.toFloat() / h.maxHp), pad + 28f, paint)

        // MP bar
        paint.color = Color.WHITE
        canvas.drawText("${GameData.T.MP}: ${h.mp}/${h.maxMp}", pad + 4, pad + 42f, paint)
        paint.color = Color.DKGRAY
        canvas.drawRect(pad + 4, pad + 46f, pad + 196, pad + 56f, paint)
        paint.color = Color.BLUE
        canvas.drawRect(pad + 4, pad + 46f, pad + 4 + 192 * (h.mp.toFloat() / h.maxMp), pad + 56f, paint)

        // EXP bar
        paint.color = Color.WHITE
        paint.textSize = 10f
        canvas.drawText("${GameData.T.EXP}: ${h.exp}/${h.expNext}", pad + 4, pad + 68f, paint)

        // Top-right: stats
        paint.color = Color.argb(160, 0, 0, 0)
        canvas.drawRect(w - 170f, pad, w - pad, 52f, paint)
        paint.color = Color.WHITE
        paint.textSize = 11f
        paint.textAlign = Paint.Align.RIGHT
        val rx = w - pad - 4f
        canvas.drawText("${GameData.T.LVL} ${h.level} | ${GameData.T.GOLD}: ${h.gold}", rx, pad + 14f, paint)
        canvas.drawText("${GameData.T.ATK}:${h.atk} ${GameData.T.DEF}:${h.def} ${GameData.T.SPD}:${h.spd}", rx, pad + 30f, paint)
        canvas.drawText("${GameData.T.SKL}: ${GameData.SKILLS[h.learnedSkills.lastOrNull()?:0].name}", rx, pad + 46f, paint)

        // Bottom info
        paint.color = Color.argb(120, 0, 0, 0)
        canvas.drawRect(pad, engine.h - 24f, 280f, engine.h - pad, paint)
        paint.color = Color.GRAY
        paint.textSize = 10f
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText("Меню:[M] Навык:[B] Инвентарь:[I] Убито:${engine.killCount}", pad + 4, engine.h - 8f, paint)
    }

    private fun drawInventory(canvas: Canvas) {
        val w = engine.w; val h = engine.h
        val pad = 30f
        val pw = w * 0.6f
        val ph = h * 0.7f
        val px = (w - pw) / 2f
        val py = (h - ph) / 2f

        paint.color = Color.argb(200, 20, 20, 40)
        canvas.drawRoundRect(px, py, px + pw, py + ph, 8f, 8f, paint)
        paint.color = Color.WHITE
        paint.strokeWidth = 2f
        canvas.drawRoundRect(px, py, px + pw, py + ph, 8f, 8f, paint)
        paint.strokeWidth = 1f

        // Title
        paint.color = Color.YELLOW
        paint.textSize = 18f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText(GameData.T.INV, w/2f, py + 24f, paint)

        val inv = engine.hero?.inventory
        if (inv == null || inv.isEmpty()) {
            paint.color = Color.GRAY
            paint.textSize = 14f
            canvas.drawText("Пусто", w/2f, py + ph/2f, paint)
        } else {
            paint.textAlign = Paint.Align.LEFT
            paint.textSize = 13f
            val startI = maxOf(0, engine.invScroll - 4)
            for (i in startI until minOf(inv.size, startI + 8)) {
                val item = GameData.ITEMS[inv[i]]
                val iy = py + 44f + (i - startI) * 22f
                val sel = i == engine.invScroll
                paint.color = if (sel) Color.argb(100, 80, 80, 150) else Color.TRANSPARENT
                canvas.drawRect(px + 8, iy - 14f, px + pw - 8, iy + 6f, paint)
                paint.color = if (sel) Color.YELLOW else Color.WHITE
                paint.typeface = if (sel) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
                canvas.drawText("${item.name} - ${item.desc}", px + 16f, iy, paint)
            }
        }

        paint.color = Color.GRAY
        paint.textSize = 11f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT
        canvas.drawText("${GameData.T.BACK}:[M] Использовать/Экипировать:[OK]", w/2f, py + ph - 12f, paint)
    }

    private fun drawPause(canvas: Canvas) {
        val w = engine.w; val h = engine.h
        paint.color = Color.argb(160, 0, 0, 0)
        canvas.drawRect(0f, 0f, w.toFloat(), h.toFloat(), paint)

        paint.color = Color.WHITE
        paint.textSize = 28f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText(GameData.T.PAUSE, w/2f, h/2f - 20f, paint)

        paint.textSize = 16f
        paint.color = Color.YELLOW
        canvas.drawText("${GameData.T.RESUME}: [OK]  ${GameData.T.QUIT}: [X]", w/2f, h/2f + 20f, paint)
    }

    private fun drawDialogBox(canvas: Canvas, text: String, cx: Float, cy: Float, boxW: Float) {
        paint.color = Color.argb(200, 20, 20, 50)
        val boxH = 50f
        canvas.drawRoundRect(cx - boxW/2, cy - boxH/2, cx + boxW/2, cy + boxH/2, 6f, 6f, paint)
        paint.color = Color.WHITE
        paint.textSize = 16f
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText(text, cx, cy + 6f, paint)
    }
}
package com.heroeslore.v1

import android.graphics.*
import kotlin.math.*

object ControllerOverlay {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    fun draw(canvas: Canvas, w: Int, h: Int, state: Int, controller: VirtualController) {
        if (state == GameData.ST_TITLE || state == GameData.ST_CLASS_SEL) return

        // D-pad background
        val pcx = 90f
        val pcy = h - 100f
        paint.color = Color.argb(80, 255, 255, 255)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        canvas.drawCircle(pcx, pcy, 55f, paint)

        // D-pad sticks
        paint.style = Paint.Style.FILL
        paint.color = Color.argb(120, 255, 255, 255)
        val dx = controller.getDx()
        val dy = controller.getDy()
        val stx = pcx + dx * 40f
        val sty = pcy + dy * 40f
        canvas.drawCircle(stx, sty, 18f, paint)

        // Arrows on d-pad
        paint.color = Color.argb(150, 200, 200, 200)
        paint.textSize = 16f
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText("\u25B2", pcx, pcy - 42f, paint)  // up
        canvas.drawText("\u25BC", pcx, pcy + 52f, paint)  // down
        canvas.drawText("\u25C0", pcx - 42f, pcy + 5f, paint)  // left
        canvas.drawText("\u25B6", pcx + 42f, pcy + 5f, paint)  // right

        // Attack button (A) - red
        val ax = w - 100f
        val ay = h - 140f
        paint.style = Paint.Style.FILL
        paint.color = if (controller.isAttacking) Color.argb(200, 255, 80, 80) else Color.argb(120, 200, 60, 60)
        canvas.drawCircle(ax, ay, 30f, paint)
        paint.color = Color.WHITE
        paint.textSize = 18f
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText("A", ax, ay + 6f, paint)

        // Skill button (B) - blue
        val sx = ax + 70f
        val sy = ay + 30f
        paint.color = if (controller.isSkill) Color.argb(200, 80, 80, 255) else Color.argb(120, 60, 60, 200)
        canvas.drawCircle(sx, sy, 26f, paint)
        paint.color = Color.WHITE
        canvas.drawText("B", sx, sy + 6f, paint)

        // Menu button - small
        paint.color = Color.argb(100, 150, 150, 150)
        canvas.drawCircle(w - 50f, 40f, 20f, paint)
        paint.color = Color.WHITE
        paint.textSize = 12f
        canvas.drawText("M", w - 50f, 44f, paint)

        // OK/X buttons (for menus)
        if (state == GameData.ST_INV || state == GameData.ST_PAUSE) {
            paint.color = Color.argb(150, 80, 200, 80)
            canvas.drawCircle(w / 2f, h - 50f, 22f, paint)
            paint.color = Color.WHITE
            paint.textSize = 14f
            canvas.drawText("OK", w / 2f, h - 46f, paint)

            paint.color = Color.argb(150, 200, 80, 80)
            canvas.drawCircle(w / 2f + 60f, h - 50f, 22f, paint)
            paint.color = Color.WHITE
            canvas.drawText("X", w / 2f + 60f, h - 46f, paint)
        }

        paint.style = Paint.Style.FILL
        paint.strokeWidth = 1f
    }
}

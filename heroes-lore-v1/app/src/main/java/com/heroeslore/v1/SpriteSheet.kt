package com.heroeslore.v1

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF

/** Native 4x4 grid sprite sheet: columns are frames, rows are down/up/left/right. */
class SpriteSheet private constructor(private val bitmap: Bitmap, private val columns: Int, private val rows: Int) {
    fun draw(canvas: Canvas, cx: Float, feetY: Float, size: Float, direction: Int, frame: Int, paint: Paint) {
        val fw = bitmap.width / columns
        val fh = bitmap.height / rows
        val col = frame.coerceIn(0, columns - 1)
        val row = direction.coerceIn(0, rows - 1)
        val src = Rect(col * fw, row * fh, (col + 1) * fw, (row + 1) * fh)
        val dst = RectF(cx - size / 2f, feetY - size, cx + size / 2f, feetY)
        canvas.drawBitmap(bitmap, src, dst, paint)
    }
    companion object {
        fun load(assets: AssetManager, path: String): SpriteSheet? = try {
            val bitmap = BitmapFactory.decodeStream(assets.open(path)) ?: return null
            SpriteSheet(bitmap, 4, 4)
        } catch (_: Exception) { null }
    }
}

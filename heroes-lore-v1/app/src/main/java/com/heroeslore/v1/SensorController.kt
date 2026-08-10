package com.heroeslore.v1

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlin.math.abs

/**
 * Опциональное сенсорное управление наклоном.
 * Полностью нативно, без MIDlet. По умолчанию выключено — включается тап по центру экрана.
 * Используется только когда виртуальный пад не трогают.
 */
class SensorController(ctx: Context) : SensorEventListener {
    private val sm = ctx.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer: Sensor? = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    var enabled: Boolean = false
    var tiltX: Float = 0f
        private set
    var tiltY: Float = 0f
        private set

    fun start() {
        accelerometer?.let { sm.registerListener(this, it, SensorManager.SENSOR_DELAY_GAME) }
    }
    fun stop() { sm.unregisterListener(this) }

    override fun onSensorChanged(e: SensorEvent?) {
        if (!enabled || e == null) return
        // e.values[0]=x (left/right), [1]=y (forward/back)
        // Инвертируем чтобы наклон вправо = движение вправо
        var x = -e.values[0] / 6f  // 6 m/s2 ~ 45°
        var y = e.values[1] / 6f
        if (abs(x) < 0.12f) x = 0f
        if (abs(y) < 0.12f) y = 0f
        tiltX = x.coerceIn(-1f, 1f)
        tiltY = y.coerceIn(-1f, 1f)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}

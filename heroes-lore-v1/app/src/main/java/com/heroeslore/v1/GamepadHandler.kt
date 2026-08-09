package com.heroeslore.v1

import android.content.Context
import android.view.InputDevice
import android.view.KeyEvent
import android.view.MotionEvent

class GamepadHandler {
    var isConnected = false
        private set
    var leftX = 0f
        private set
    var leftY = 0f
        private set

    private var _buttonA = false
    private var _buttonB = false
    private var _buttonStart = false
    private var _buttonX = false  // confirm

    // Edge-triggered (consumed on read)
    private var _startPressed = false
    private var _xPressed = false

    val buttonA: Boolean get() = _buttonA
    val buttonB: Boolean get() = _buttonB
    val buttonStart: Boolean get() { val v = _startPressed; _startPressed = false; return v }
    val buttonX: Boolean get() { val v = _xPressed; _xPressed = false; return v }

    private var deviceId = -1

    fun init(ctx: Context) {
        val ids = InputDevice.getDeviceIds()
        for (id in ids) {
            val dev = InputDevice.getDevice(id) ?: continue
            if (dev.sources and InputDevice.SOURCE_GAMEPAD == InputDevice.SOURCE_GAMEPAD) {
                isConnected = true
                deviceId = id
                break
            }
        }
    }

    fun handleKey(event: KeyEvent): Boolean {
        if (!isConnected) return false
        if (event.deviceId != deviceId) return false
        val down = event.action == KeyEvent.ACTION_DOWN
        when (event.keyCode) {
            KeyEvent.KEYCODE_BUTTON_A -> { _buttonA = down; return true }
            KeyEvent.KEYCODE_BUTTON_B -> { _buttonB = down; return true }
            KeyEvent.KEYCODE_BUTTON_START -> { if (down) _startPressed = true; return true }
            KeyEvent.KEYCODE_BUTTON_X -> { if (down) _xPressed = true; return true }
            KeyEvent.KEYCODE_BUTTON_Y -> { if (down) _startPressed = true; return true }
        }
        return false
    }

    fun handleMotion(event: MotionEvent): Boolean {
        if (!isConnected) return false
        if (event.deviceId != deviceId) return false

        // Left stick
        leftX = event.getAxisValue(MotionEvent.AXIS_X)
        leftY = event.getAxisValue(MotionEvent.AXIS_Y)

        // D-pad as hat
        leftX += event.getAxisValue(MotionEvent.AXIS_HAT_X)
        leftY += event.getAxisValue(MotionEvent.AXIS_HAT_Y)

        // Deadzone
        if (kotlin.math.abs(leftX) < 0.15f) leftX = 0f
        if (kotlin.math.abs(leftY) < 0.15f) leftY = 0f

        // L2/R2 triggers
        val l2 = event.getAxisValue(MotionEvent.AXIS_LTRIGGER)
        val r2 = event.getAxisValue(MotionEvent.AXIS_RTRIGGER)
        if (l2 > 0.5f && !_startPressed) _startPressed = true
        if (r2 > 0.5f) _buttonB = true

        return true
    }
}

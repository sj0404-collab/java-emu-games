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
    var buttonA = false
        private set
    var buttonB = false
        private set
    var buttonStart = false
        private set

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
        when (event.keyCode) {
            KeyEvent.KEYCODE_BUTTON_A -> {
                buttonA = event.action == KeyEvent.ACTION_DOWN; return true
            }
            KeyEvent.KEYCODE_BUTTON_B -> {
                buttonB = event.action == KeyEvent.ACTION_DOWN; return true
            }
            KeyEvent.KEYCODE_BUTTON_START -> {
                buttonStart = event.action == KeyEvent.ACTION_DOWN; return true
            }
            KeyEvent.KEYCODE_BUTTON_X -> {
                if (event.action == KeyEvent.ACTION_DOWN) buttonB = true
                return true
            }
            KeyEvent.KEYCODE_BUTTON_Y -> {
                if (event.action == KeyEvent.ACTION_DOWN) buttonStart = true
                return true
            }
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

        // L2/R2 triggers for menu/skill
        val l2 = event.getAxisValue(MotionEvent.AXIS_LTRIGGER)
        val r2 = event.getAxisValue(MotionEvent.AXIS_RTRIGGER)
        if (l2 > 0.5f) buttonStart = true
        if (r2 > 0.5f) buttonB = true

        return true
    }
}
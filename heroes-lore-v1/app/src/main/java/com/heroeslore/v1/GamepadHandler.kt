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
    private var _buttonBHold = false
    private var _bEdge = false

    // Edge-triggered
    private var _startPressed = false
    private var _xPressed = false
    private var _confirmEdge = false

    val buttonA: Boolean get() = _buttonA
    val buttonB: Boolean get() = _buttonBHold
    // consumed on read
    val buttonStart: Boolean get() { val v = _startPressed; _startPressed = false; return v }
    val buttonX: Boolean get() { val v = _xPressed; _xPressed = false; return v }

    val hasAnyButton: Boolean get() = _buttonA || _buttonBHold || _startPressed || _xPressed || _confirmEdge || _bEdge

    private var deviceId = -1

    fun init(ctx: Context) {
        refreshConnection()
    }

    private fun refreshConnection() {
        val ids = InputDevice.getDeviceIds()
        for (id in ids) {
            val dev = InputDevice.getDevice(id) ?: continue
            val src = dev.sources
            if ((src and InputDevice.SOURCE_GAMEPAD == InputDevice.SOURCE_GAMEPAD) ||
                (src and InputDevice.SOURCE_JOYSTICK == InputDevice.SOURCE_JOYSTICK)) {
                isConnected = true
                deviceId = id
                return
            }
        }
        // fallback: any device with DPAD/keys
        isConnected = deviceId != -1
    }

    fun consumeButtonB(): Boolean { val v = _bEdge; _bEdge = false; return v }
    fun consumeConfirm(): Boolean { val v = _confirmEdge; _confirmEdge = false; return v }
    fun consumeCancel(): Boolean { val v = _xPressed; _xPressed = false; return v }

    fun handleKey(event: KeyEvent): Boolean {
        // allow any device if not yet connected, then latch
        if (deviceId != -1 && event.deviceId != deviceId) {
            // still try to handle if it looks like a gamepad key
        }
        val down = event.action == KeyEvent.ACTION_DOWN
        when (event.keyCode) {
            KeyEvent.KEYCODE_BUTTON_A, KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> {
                _buttonA = down
                if (down) _confirmEdge = true
                isConnected = true; if (deviceId == -1) deviceId = event.deviceId
                return true
            }
            KeyEvent.KEYCODE_BUTTON_B -> {
                _buttonBHold = down
                if (down) _bEdge = true
                isConnected = true; if (deviceId == -1) deviceId = event.deviceId
                return true
            }
            KeyEvent.KEYCODE_BUTTON_START, KeyEvent.KEYCODE_BUTTON_Y, KeyEvent.KEYCODE_MENU -> {
                if (down) _startPressed = true
                isConnected = true; if (deviceId == -1) deviceId = event.deviceId
                return true
            }
            KeyEvent.KEYCODE_BUTTON_X, KeyEvent.KEYCODE_DEL, KeyEvent.KEYCODE_ESCAPE -> {
                if (down) _xPressed = true
                isConnected = true; if (deviceId == -1) deviceId = event.deviceId
                return true
            }
        }
        return false
    }

    fun handleMotion(event: MotionEvent): Boolean {
        if (event.deviceId != deviceId && deviceId != -1) {
            // allow first motion to latch device
            refreshConnection()
            if (event.deviceId != deviceId) return false
        }
        if (deviceId == -1) deviceId = event.deviceId
        isConnected = true

        var lx = event.getAxisValue(MotionEvent.AXIS_X)
        var ly = event.getAxisValue(MotionEvent.AXIS_Y)
        // fallback for some controllers
        if (lx == 0f && ly == 0f) {
            lx = event.getAxisValue(MotionEvent.AXIS_Z)
            ly = event.getAxisValue(MotionEvent.AXIS_RZ)
        }
        // D-pad hat
        val hatX = event.getAxisValue(MotionEvent.AXIS_HAT_X)
        val hatY = event.getAxisValue(MotionEvent.AXIS_HAT_Y)
        if (hatX != 0f) lx = hatX
        if (hatY != 0f) ly = hatY

        // Deadzone
        if (kotlin.math.abs(lx) < 0.2f) lx = 0f
        if (kotlin.math.abs(ly) < 0.2f) ly = 0f

        leftX = lx.coerceIn(-1f, 1f)
        leftY = ly.coerceIn(-1f, 1f)

        // Triggers: L2 = menu, R2 = skill (edge once per press)
        val l2 = event.getAxisValue(MotionEvent.AXIS_LTRIGGER)
        val r2 = event.getAxisValue(MotionEvent.AXIS_RTRIGGER)
        val brake = event.getAxisValue(MotionEvent.AXIS_BRAKE)
        val gas = event.getAxisValue(MotionEvent.AXIS_GAS)
        val lTrig = maxOf(l2, brake)
        val rTrig = maxOf(r2, gas)
        if (lTrig > 0.5f) {
            if (!_startPressed) _startPressed = true
        }
        if (rTrig > 0.5f) {
            _buttonBHold = true
            if (!_bEdge) _bEdge = true
        } else {
            // if no trigger held, don't force release if B button still held via key
            if (!_buttonBHold) _buttonBHold = false
        }

        return true
    }
}

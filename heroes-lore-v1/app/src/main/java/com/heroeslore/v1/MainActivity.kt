package com.heroeslore.v1

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.view.WindowManager

class MainActivity : Activity() {
    private lateinit var gameView: GameSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE

        gameView = GameSurfaceView(this)
        setContentView(gameView)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // Physical keyboard / gamepad fallback
        val eng = (gameView.getTag() as? GameEngine) ?: return super.onKeyDown(keyCode, event)
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> eng.inputDy = -1f
            KeyEvent.KEYCODE_DPAD_DOWN -> eng.inputDy = 1f
            KeyEvent.KEYCODE_DPAD_LEFT -> eng.inputDx = -1f
            KeyEvent.KEYCODE_DPAD_RIGHT -> eng.inputDx = 1f
            KeyEvent.KEYCODE_SPACE, KeyEvent.KEYCODE_ENTER -> eng.inputAttack = true
            KeyEvent.KEYCODE_B -> eng.inputSkill = true
            KeyEvent.KEYCODE_M, KeyEvent.KEYCODE_MENU -> eng.inputMenu = true
            KeyEvent.KEYCODE_I -> { eng.inputMenu = true; if (eng.state == GameData.ST_PLAY) eng.state = GameData.ST_INV }
            KeyEvent.KEYCODE_ESCAPE -> eng.inputCancel = true
        }
        if (gameView.onGamepadKeyEvent(event)) return true
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        val eng = (gameView.getTag() as? GameEngine) ?: return super.onKeyUp(keyCode, event)
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP, KeyEvent.KEYCODE_DPAD_DOWN -> eng.inputDy = 0f
            KeyEvent.KEYCODE_DPAD_LEFT, KeyEvent.KEYCODE_DPAD_RIGHT -> eng.inputDx = 0f
        }
        if (gameView.onGamepadKeyEvent(event)) return true
        return super.onKeyUp(keyCode, event)
    }

    override fun onGenericMotionEvent(event: android.view.MotionEvent): Boolean {
        return gameView.onGenericMotionEvent(event) || super.onGenericMotionEvent(event)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}
package com.heroeslore.v1

import android.app.Activity
import android.os.Build
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
        // immersive sticky для полного погружения — полностью нативный Android, без хаков MIDlet
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            )
        }
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE

        gameView = GameSurfaceView(this)
        setContentView(gameView)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // Let GamepadHandler try first (it knows gamepad keys)
        if (gameView.onGamepadKeyEvent(event)) return true
        val eng = (gameView.getTag() as? GameEngine) ?: return super.onKeyDown(keyCode, event)
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> eng.inputDy = -1f
            KeyEvent.KEYCODE_DPAD_DOWN -> eng.inputDy = 1f
            KeyEvent.KEYCODE_DPAD_LEFT -> eng.inputDx = -1f
            KeyEvent.KEYCODE_DPAD_RIGHT -> eng.inputDx = 1f
            KeyEvent.KEYCODE_SPACE, KeyEvent.KEYCODE_ENTER -> eng.inputConfirm = true
            KeyEvent.KEYCODE_Z -> eng.inputAttack = true
            KeyEvent.KEYCODE_X, KeyEvent.KEYCODE_B -> eng.inputSkill = true
            KeyEvent.KEYCODE_M, KeyEvent.KEYCODE_MENU -> eng.inputMenu = true
            KeyEvent.KEYCODE_I -> { if (eng.state == GameData.ST_PLAY) eng.state = GameData.ST_INV else eng.inputMenu = true }
            KeyEvent.KEYCODE_ESCAPE, KeyEvent.KEYCODE_BACK -> eng.inputCancel = true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        if (gameView.onGamepadKeyEvent(event)) return true
        val eng = (gameView.getTag() as? GameEngine) ?: return super.onKeyUp(keyCode, event)
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP, KeyEvent.KEYCODE_DPAD_DOWN -> eng.inputDy = 0f
            KeyEvent.KEYCODE_DPAD_LEFT, KeyEvent.KEYCODE_DPAD_RIGHT -> eng.inputDx = 0f
            KeyEvent.KEYCODE_Z, KeyEvent.KEYCODE_SPACE -> eng.inputAttack = false
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun onGenericMotionEvent(event: android.view.MotionEvent): Boolean {
        return gameView.onGenericMotionEvent(event) || super.onGenericMotionEvent(event)
    }

    override fun onResume() {
        super.onResume()
        gameView.onResume()
        // re-apply immersive
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )
    }

    override fun onPause() {
        gameView.onPause()
        super.onPause()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            )
        }
    }
}
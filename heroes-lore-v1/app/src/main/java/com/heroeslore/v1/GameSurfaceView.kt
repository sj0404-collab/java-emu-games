package com.heroeslore.v1

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameSurfaceView @JvmOverloads constructor(
    ctx: Context, attrs: AttributeSet? = null
) : SurfaceView(ctx, attrs), SurfaceHolder.Callback {

    private var engine: GameEngine? = null
    private var renderer: GameRenderer? = null
    private var thread: Thread? = null
    private var running = false
    private var lastTime = 0L
    private val targetFps = 30
    private val frameTime = 1000L / targetFps

    // Virtual controller state
    private val vPad = VirtualController()
    private val gamepad = GamepadHandler()

    fun initGame() {
        engine = GameEngine(width, height)
        renderer = GameRenderer(engine!!)
        renderer!!.loadAssets(context.assets)
        gamepad.init(context)
        setTag(engine)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        if (width > 0 && height > 0 && engine == null) {
            initGame()
        }
        running = true
        thread = Thread {
            lastTime = System.currentTimeMillis()
            while (running) {
                val now = System.currentTimeMillis()
                val delta = now - lastTime
                if (delta >= frameTime) {
                    lastTime = now - (delta % frameTime)
                    updateInput()
                    engine?.update()
                    val eng = engine
                    val ren = renderer
                    if (eng != null && ren != null) {
                        val c = holder.lockCanvas() ?: continue
                        try {
                            ren.render(c)
                            ControllerOverlay.draw(c, width, height, eng.state, vPad)
                        } finally {
                            holder.unlockCanvasAndPost(c)
                        }
                    }
                } else {
                    Thread.sleep(frameTime - delta)
                }
            }
        }
        thread?.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, fmt: Int, w: Int, h: Int) {
        engine?.let {
            // Update engine dimensions if resized
            if (it.w != w || it.h != h) {
                val newEngine = GameEngine(w, h)
                newEngine.state = it.state
                newEngine.hero = it.hero
                newEngine.enemies.addAll(it.enemies)
                newEngine.classSelIndex = it.classSelIndex
                newEngine.killCount = it.killCount
                engine = newEngine
                renderer = GameRenderer(newEngine)
                renderer!!.loadAssets(context.assets)
            }
        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        running = false
        thread?.join(5000)
    }

    private fun updateInput() {
        val e = engine ?: return
        // Gamepad takes priority
        if (gamepad.isConnected) {
            e.inputDx = gamepad.leftX
            e.inputDy = gamepad.leftY
            e.inputAttack = gamepad.buttonA
            e.inputSkill = gamepad.buttonB
            e.inputMenu = gamepad.buttonStart
            e.inputConfirm = gamepad.buttonA
            e.inputCancel = gamepad.buttonB
        } else {
            // Virtual controller
            e.inputDx = vPad.getDx()
            e.inputDy = vPad.getDy()
            e.inputAttack = vPad.isAttacking
            e.inputSkill = vPad.isSkill
            e.inputMenu = vPad.isMenu
            e.inputConfirm = vPad.isConfirm
            e.inputCancel = vPad.isCancel
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        vPad.handleTouch(event, width, height, engine?.state ?: 0)
        return true
    }

    override fun onGenericMotionEvent(event: MotionEvent): Boolean {
        gamepad.handleMotion(event)
        return super.onGenericMotionEvent(event)
    }

    fun onGamepadKeyEvent(event: android.view.KeyEvent): Boolean {
        return gamepad.handleKey(event)
    }
}
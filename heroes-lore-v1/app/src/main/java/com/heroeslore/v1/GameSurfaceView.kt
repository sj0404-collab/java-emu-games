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
    @Volatile
    private var thread: Thread? = null
    @Volatile
    private var running = false
    private var lastTime = 0L
    private val targetFps = 30
    private val frameTime = 1000L / targetFps

    // Virtual controller state
    private val vPad = VirtualController()
    private val gamepad = GamepadHandler()

    init {
        holder.addCallback(this)
    }

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
        if (engine == null) return
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
                        } catch (e: Exception) {
                            // Catch rendering errors to prevent crash loop
                            android.util.Log.e("HLZ", "Render error", e)
                        } finally {
                            holder.unlockCanvasAndPost(c)
                        }
                    }
                } else {
                    Thread.sleep(frameTime - delta)
                }
            }
        }.apply {
            name = "GameLoop"
            start()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, fmt: Int, w: Int, h: Int) {
        engine?.let {
            if (it.w != w || it.h != h) {
                val newEngine = GameEngine(w, h)
                newEngine.state = it.state
                newEngine.hero = it.hero
                newEngine.enemies.addAll(it.enemies)
                newEngine.floatTexts.addAll(it.floatTexts)
                newEngine.drops.addAll(it.drops)
                newEngine.classSelIndex = it.classSelIndex
                newEngine.invScroll = it.invScroll
                newEngine.killCount = it.killCount
                newEngine.totalKills = it.totalKills
                newEngine.cameraX = it.cameraX
                newEngine.cameraY = it.cameraY
                newEngine.dialogText = it.dialogText
                newEngine.dialogTimer = it.dialogTimer
                newEngine.titleBlink = it.titleBlink
                engine = newEngine
                renderer = GameRenderer(newEngine)
                renderer!!.loadAssets(context.assets)
            }
        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        running = false
        try { thread?.join(1000) } catch (_: InterruptedException) {}
        thread = null
    }

    private fun updateInput() {
        val e = engine ?: return
        // Gamepad takes priority when actually providing input
        val usingGamepad = gamepad.isConnected && (gamepad.leftX != 0f || gamepad.leftY != 0f || gamepad.hasAnyButton)
        if (usingGamepad) {
            e.inputDx = gamepad.leftX
            e.inputDy = gamepad.leftY
            e.inputAttack = gamepad.buttonA
            // B is skill (hold) — consume edge separately
            if (gamepad.consumeButtonB()) e.inputSkill = true
            if (gamepad.buttonStart) e.inputMenu = true
            // A as confirm is edge via separate flag to avoid double-fire on hold
            if (gamepad.consumeConfirm()) e.inputConfirm = true
            if (gamepad.consumeCancel()) e.inputCancel = true
        } else {
            // Virtual controller
            e.inputDx = vPad.getDx()
            e.inputDy = vPad.getDy()
            e.inputAttack = vPad.isAttacking
            if (vPad.consumeSkill()) e.inputSkill = true
            if (vPad.isMenu) e.inputMenu = true
            if (vPad.isConfirm) e.inputConfirm = true
            if (vPad.isCancel) e.inputCancel = true
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
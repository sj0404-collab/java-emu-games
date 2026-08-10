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

    // Virtual controller state — полностью нативный Android, без MIDlet-эмуляции
    private val vPad = VirtualController()
    private val gamepad = GamepadHandler()
    private var sensorCtrl: SensorController? = null

    init {
        holder.addCallback(this)
        isFocusable = true
        isFocusableInTouchMode = true
    }

    fun onResume() { sensorCtrl?.start() }
    fun onPause() { sensorCtrl?.stop() }

    fun initGame() {
        val w = if (width > 0) width else 800
        val h = if (height > 0) height else 480
        engine = GameEngine(w, h)
        renderer = GameRenderer(engine!!)
        renderer!!.loadAssets(context.assets)
        gamepad.init(context)
        sensorCtrl = SensorController(context)
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
        // 1. Геймпад — приоритет если реально шлёт данные
        val usingGamepad = gamepad.isConnected && (gamepad.leftX != 0f || gamepad.leftY != 0f || gamepad.hasAnyButton)
        if (usingGamepad) {
            e.inputDx = gamepad.leftX
            e.inputDy = gamepad.leftY
            e.inputAttack = gamepad.buttonA
            if (gamepad.consumeButtonB()) e.inputSkill = true
            if (gamepad.buttonStart) e.inputMenu = true
            if (gamepad.consumeConfirm()) e.inputConfirm = true
            if (gamepad.consumeCancel()) e.inputCancel = true
            return
        }
        // 2. Сенсор наклона — только если пад не трогают и сенсор включён
        val sc = sensorCtrl
        val usingSensor = sc != null && sc.enabled && vPad.getDx() == 0f && vPad.getDy() == 0f
        if (usingSensor) {
            e.inputDx = sc!!.tiltX
            e.inputDy = sc!!.tiltY
        } else {
            e.inputDx = vPad.getDx()
            e.inputDy = vPad.getDy()
        }
        e.inputAttack = vPad.isAttacking
        if (vPad.consumeSkill()) e.inputSkill = true
        if (vPad.isMenu) e.inputMenu = true
        if (vPad.isConfirm) e.inputConfirm = true
        if (vPad.isCancel) e.inputCancel = true
        // переключение сенсора — долгое нажатие в центре включает/выключает (обрабатывается в VirtualController)
        if (vPad.consumeToggleSensor()) {
            sc?.let { it.enabled = !it.enabled; if (it.enabled) it.start() else it.stop() }
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

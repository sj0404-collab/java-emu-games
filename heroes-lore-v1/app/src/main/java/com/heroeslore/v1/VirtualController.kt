package com.heroeslore.v1

import android.view.MotionEvent
import kotlin.math.*

class VirtualController {
    // D-pad
    private var padTouchId = -1
    private var padCenterX = 0f
    private var padCenterY = 0f
    private var padRadius = 60f
    private var dx = 0f
    private var dy = 0f

    // Buttons - hold type (attack, skill)
    private var attackTouchId = -1
    private var skillTouchId = -1
    private var _skillEdge = false

    // Buttons - tap type (menu, confirm, cancel) - consumed after read
    private var menuTouchId = -1
    private var confirmTouchId = -1
    private var cancelTouchId = -1

    var isAttacking = false
        private set
    var isSkill = false
        private set

    // Tap buttons - read once then cleared
    private var _menuPressed = false
    private var _confirmPressed = false
    private var _cancelPressed = false

    val isMenu: Boolean get() {
        val v = _menuPressed
        _menuPressed = false
        return v
    }
    val isConfirm: Boolean get() {
        val v = _confirmPressed
        _confirmPressed = false
        return v
    }
    val isCancel: Boolean get() {
        val v = _cancelPressed
        _cancelPressed = false
        return v
    }

    fun consumeSkill(): Boolean { val v = _skillEdge; _skillEdge = false; return v }

    // Button regions
    private data class Btn(val name: String, var x: Float, var y: Float, var r: Float)
    private val buttons = mutableListOf<Btn>()

    fun handleTouch(event: MotionEvent, screenW: Int, screenH: Int, state: Int) {
        val padCX = 90f
        val padCY = screenH - 100f
        padRadius = 55f
        padCenterX = padCX
        padCenterY = padCY

        buttons.clear()
        // Right side buttons
        val bx = screenW - 100f
        val by = screenH - 140f
        buttons.add(Btn("attack", bx, by, 32f))          // A - attack
        buttons.add(Btn("skill", bx + 70f, by + 30f, 28f)) // B - skill
        buttons.add(Btn("menu", screenW - 50f, 40f, 22f))  // Menu
        buttons.add(Btn("confirm", screenW / 2f, screenH - 50f, 24f))  // OK
        buttons.add(Btn("cancel", screenW / 2f + 60f, screenH - 50f, 24f)) // X

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                val idx = event.actionIndex
                val px = event.getX(idx)
                val py = event.getY(idx)
                val pid = event.getPointerId(idx)

                // Check D-pad first
                val dist = sqrt((px - padCenterX).pow(2) + (py - padCenterY).pow(2))
                if (dist < padRadius * 1.5f && padTouchId == -1) {
                    padTouchId = pid
                    updateDpad(px, py)
                    return
                }

                // Check buttons
                for (btn in buttons) {
                    if (sqrt((px - btn.x).pow(2) + (py - btn.y).pow(2)) < btn.r) {
                        when (btn.name) {
                            "attack" -> attackTouchId = pid
                            "skill" -> { skillTouchId = pid; _skillEdge = true; isSkill = true }
                            "menu" -> { menuTouchId = pid; _menuPressed = true }
                            "confirm" -> { confirmTouchId = pid; _confirmPressed = true }
                            "cancel" -> { cancelTouchId = pid; _cancelPressed = true }
                        }
                        return
                    }
                }
            }

            MotionEvent.ACTION_MOVE -> {
                for (i in 0 until event.pointerCount) {
                    val pid = event.getPointerId(i)
                    if (pid == padTouchId) {
                        updateDpad(event.getX(i), event.getY(i))
                    }
                }
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_CANCEL -> {
                val idx = event.actionIndex
                val pid = event.getPointerId(idx)
                when (pid) {
                    padTouchId -> { padTouchId = -1; dx = 0f; dy = 0f }
                    attackTouchId -> { attackTouchId = -1; isAttacking = false }
                    skillTouchId -> { skillTouchId = -1; isSkill = false }
                    menuTouchId -> menuTouchId = -1
                    confirmTouchId -> confirmTouchId = -1
                    cancelTouchId -> cancelTouchId = -1
                }
                // ACTION_CANCEL means all pointers cancelled
                if (event.actionMasked == MotionEvent.ACTION_CANCEL) {
                    padTouchId = -1; dx = 0f; dy = 0f
                    attackTouchId = -1; isAttacking = false
                    skillTouchId = -1; isSkill = false
                    menuTouchId = -1; confirmTouchId = -1; cancelTouchId = -1
                }
            }
        }

        // Set hold flags (attack is hold, skill hold for UI highlight)
        isAttacking = attackTouchId >= 0
        isSkill = skillTouchId >= 0
    }

    private fun updateDpad(px: Float, py: Float) {
        val ddx = px - padCenterX
        val ddy = py - padCenterY
        val dist = sqrt(ddx.pow(2) + ddy.pow(2))
        if (dist > 0) {
            val clamped = minOf(dist, padRadius) / padRadius
            dx = (ddx / dist) * clamped
            dy = (ddy / dist) * clamped
        }
    }

    fun getDx(): Float = dx
    fun getDy(): Float = dy
}

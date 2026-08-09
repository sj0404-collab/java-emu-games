package com.heroeslore.v1

class FloatText(val text: String, var x: Float, var y: Float, val color: Int) {
    var life: Int = 40
    var vy: Float = -1.5f
    
    fun update(): Boolean {
        life--
        y += vy
        vy *= 0.97f
        return life > 0
    }
}

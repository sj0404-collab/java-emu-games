package com.heroeslore.v1

class Enemy(val defId: Int, val tx: Int, val ty: Int) {
    val def = GameData.ENEMIES[defId]
    val name: String = def.name
    
    var x: Float = tx.toFloat()
    var y: Float = ty.toFloat()
    var hp: Int = def.hp
    val maxHp: Int = def.hp
    var alive: Boolean = true
    
    var dir: Int = 0
    var animFrame: Int = 0
    var animTimer: Int = 0
    var attackCd: Int = 0
    var hurtTimer: Int = 0
    
    // Simple AI state
    var aiTimer: Int = 0
    var moveDir: Int = 0
    
    fun update(heroX: Float, heroY: Float, map: Array<IntArray>): Boolean {
        if (!alive) return false
        
        if (hurtTimer > 0) hurtTimer--
        if (attackCd > 0) attackCd--
        animTimer++
        if (animTimer > 8) {
            animTimer = 0
            animFrame = (animFrame + 1) % 4
        }
        
        aiTimer++
        val dist = kotlin.math.sqrt((x - heroX) * (x - heroX) + (y - heroY) * (y - heroY))
        
        if (dist < 2.0f && attackCd <= 0) {
            // In range to attack hero
            attackCd = 30 - def.spd
            return true // signals: attack hero
        }
        
        if (dist < 6.0f && aiTimer % (12 - def.spd / 2) == 0) {
            // Move toward hero
            val dx = heroX - x
            val dy = heroY - y
            val nx = x + (if (dx > 0.3f) 0.5f else if (dx < -0.3f) -0.5f else 0f)
            val ny = y + (if (dy > 0.3f) 0.5f else if (dy < -0.3f) -0.5f else 0f)
            
            val nxi = nx.toInt()
            val nyi = ny.toInt()
            if (nxi >= 0 && nxi < GameData.MAP_W && nyi >= 0 && nyi < GameData.MAP_H) {
                val tile = map[nyi][nxi]
                if (tile != GameData.T_WALL && tile != GameData.T_WATER && tile != GameData.T_TREE) {
                    x = nx
                    y = ny
                }
            }
        }
        return false
    }
    
    fun takeDamage(dmg: Int): Int {
        val actual = maxOf(1, dmg - def.def / 3)
        hp -= actual
        hurtTimer = 10
        if (hp <= 0) {
            hp = 0
            alive = false
        }
        return actual
    }
}
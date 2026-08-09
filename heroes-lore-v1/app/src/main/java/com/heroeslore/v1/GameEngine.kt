package com.heroeslore.v1

import kotlin.math.*

class GameEngine(val w: Int, val h: Int) {
    var state: Int = GameData.ST_TITLE
    var hero: Hero? = null
    val enemies = mutableListOf<Enemy>()
    val floatTexts = mutableListOf<FloatText>()
    val drops = mutableListOf<Triple<Int, Float, Float>>() // itemId, x, y
    
    var cameraX: Float = 0f
    var cameraY: Float = 0f
    var classSelIndex: Int = 0
    var invScroll: Int = 0
    var dialogText: String = ""
    var dialogTimer: Int = 0
    var titleBlink: Int = 0
    var killCount: Int = 0
    var totalKills: Int = 10
    
    // Input state
    var inputDx: Float = 0f
    var inputDy: Float = 0f
    var inputAttack: Boolean = false
    var inputSkill: Boolean = false
    var inputMenu: Boolean = false
    var inputConfirm: Boolean = false
    var inputCancel: Boolean = false
    
    init {
        spawnEnemies()
    }
    
    fun spawnEnemies() {
        enemies.clear()
        // Spawn enemies on walkable tiles
        val positions = mutableListOf<Pair<Int,Int>>()
        for (y in 0 until GameData.MAP_H) {
            for (x in 0 until GameData.MAP_W) {
                val t = GameData.MAP[y][x]
                if (t == GameData.T_GRASS || t == GameData.T_PATH || t == GameData.T_FLOOR) {
                    if (x > 3 && y > 3 && abs(x - 5f) > 2f && abs(y - 5f) > 2f) {
                        positions.add(Pair(x, y))
                    }
                }
            }
        }
        positions.shuffle()
        val count = minOf(15, positions.size)
        for (i in 0 until count) {
            val maxE = minOf(GameData.ENEMIES.size, 3 + killCount / 3)
            val eid = (0 until maxE).random()
            enemies.add(Enemy(eid, positions[i].first, positions[i].second))
        }
    }
    
    fun startGame(clsId: Int) {
        hero = Hero(clsId)
        hero?.x = 5f
        hero?.y = 5f
        killCount = 0
        totalKills = 10
        enemies.clear()
        floatTexts.clear()
        drops.clear()
        spawnEnemies()
        state = GameData.ST_PLAY
    }
    
    fun update() {
        titleBlink++
        when (state) {
            GameData.ST_TITLE -> {
                if (inputConfirm || inputAttack) {
                    state = GameData.ST_CLASS_SEL
                }
            }
            GameData.ST_CLASS_SEL -> {
                if (inputDy > 0.3f) { classSelIndex = (classSelIndex + 1) % GameData.CLASSES.size; inputDy = 0f }
                if (inputDy < -0.3f) { classSelIndex = (classSelIndex - 1 + GameData.CLASSES.size) % GameData.CLASSES.size; inputDy = 0f }
                if (inputConfirm || inputAttack) {
                    startGame(classSelIndex)
                }
            }
            GameData.ST_PLAY -> updateGameplay()
            GameData.ST_INV -> updateInventory()
            GameData.ST_PAUSE -> {
                if (inputConfirm) { state = GameData.ST_PLAY }
                if (inputCancel || inputMenu) { state = GameData.ST_PLAY }
            }
            GameData.ST_DEAD -> {
                dialogTimer++
                if (inputConfirm && dialogTimer > 60) {
                    state = GameData.ST_TITLE
                }
            }
            GameData.ST_DIALOG -> {
                dialogTimer--
                if (dialogTimer <= 0 || inputConfirm) {
                    state = GameData.ST_PLAY
                }
            }
        }
        // Clear single-frame inputs
        inputConfirm = false
        inputCancel = false
        inputMenu = false
    }
    
    private fun updateGameplay() {
        val h = hero ?: return
        
        // Menu/pause
        if (inputMenu) { state = GameData.ST_PAUSE; inputMenu = false; return }
        
        // Hero movement
        if (h.attackTimer <= 0) {
            var dx = inputDx
            var dy = inputDy
            if (dx != 0f || dy != 0f) {
                val len = sqrt(dx*dx + dy*dy)
                if (len > 0) { dx /= len; dy /= len }
                val speed = 0.08f + h.spd * 0.005f
                val nx = h.x + dx * speed
                val ny = h.y + dy * speed
                
                // Direction
                if (abs(dx) > abs(dy)) {
                    h.dir = if (dx > 0) 2 else 1
                } else {
                    h.dir = if (dy > 0) 0 else 3
                }
                h.moving = true
                
                // Collision check
                val nxi = nx.toInt()
                val nyi = ny.toInt()
                if (nxi >= 0 && nxi < GameData.MAP_W && nyi >= 0 && nyi < GameData.MAP_H) {
                    val tile = GameData.MAP[nyi][nxi]
                    if (tile != GameData.T_WALL && tile != GameData.T_WATER && tile != GameData.T_TREE) {
                        h.x = nx
                        h.y = ny
                    }
                }
                // Animation
                h.animTimer++
                if (h.animTimer > 6) { h.animTimer = 0; h.animFrame = (h.animFrame + 1) % 4 }
            } else {
                h.moving = false
                h.animFrame = 0
            }
        }
        
        // Hero attack
        if (h.attackTimer > 0) h.attackTimer--
        if (h.attackCd > 0) h.attackCd--
        if (h.hurtTimer > 0) h.hurtTimer--
        
        if (inputAttack && h.attackCd <= 0 && h.attackTimer <= 0) {
            h.attackTimer = 12
            h.attackCd = 15 - h.spd / 3
            h.attacking = true
            // Check hit enemies in range
            val range = 1.8f
            for (e in enemies) {
                if (!e.alive) continue
                val dist = sqrt((h.x - e.x)*(h.x - e.x) + (h.y - e.y)*(h.y - e.y))
                if (dist < range) {
                    val crit = (0 until 10).random() < 2
                    var dmg = h.atk + (0 until h.atk / 2 + 1).random()
                    if (crit) dmg = (dmg * 1.8f).toInt()
                    val actual = e.takeDamage(dmg)
                    val color = if (crit) 0xFFFF00.toInt() else 0xFFFFFF.toInt()
                    floatTexts.add(FloatText(if(crit) "${actual} ${GameData.T.CRIT}" else "-$actual", e.x, e.y - 0.5f, color))
                    if (!e.alive) {
                        h.addExp(e.def.exp)
                        h.gold += e.def.gold
                        killCount++
                        floatTexts.add(FloatText("+${e.def.exp}xp +${e.def.gold}g", e.x, e.y - 1f, 0x00FF00.toInt()))
                        // Drop item chance
                        if ((0 until 5).random() == 0) {
                            val itemId = (0 until minOf(3, GameData.ITEMS.size)).random()
                            drops.add(Triple(itemId, e.x, e.y))
                        }
                        // Check level up
                        val oldLvl = h.level
                        if (h.level > oldLvl) {
                            floatTexts.add(FloatText(GameData.T.LVLUP, h.x, h.y - 1.5f, 0xFFD700.toInt()))
                        }
                        // Respawn if needed
                        if (enemies.count { it.alive } < 3) {
                            spawnEnemies()
                            totalKills += 5
                        }
                    }
                }
            }
        } else {
            h.attacking = false
        }
        
        // Skill use
        if (inputSkill && h.attackCd <= 0) {
            val sk = GameData.SKILLS.getOrNull(h.learnedSkills.lastOrNull() ?: 0) ?: return
            if (h.mp >= sk.mp) {
                h.mp -= sk.mp
                h.attackCd = 20
                if (sk.dmg < 0) {
                    // Heal skill
                    h.heal(-sk.dmg)
                    floatTexts.add(FloatText("+${-sk.dmg}HP", h.x, h.y - 1f, 0x00FF00.toInt()))
                } else {
                    // Damage skill - hit all nearby enemies
                    for (e in enemies) {
                        if (!e.alive) continue
                        val dist = sqrt((h.x - e.x)*(h.x - e.x) + (h.y - e.y)*(h.y - e.y))
                        if (dist < 3.5f) {
                            val actual = e.takeDamage(sk.dmg + h.atk / 2)
                            floatTexts.add(FloatText("-$actual", e.x, e.y - 0.5f, 0xFF6600.toInt()))
                            if (!e.alive) {
                                h.addExp(e.def.exp)
                                h.gold += e.def.gold
                                killCount++
                            }
                        }
                    }
                }
            } else {
                floatTexts.add(FloatText(GameData.T.NO_MP, h.x, h.y - 1f, 0xFF0000.toInt()))
            }
            inputSkill = false
        }
        
        // Pick up drops
        val dropIter = drops.iterator()
        while (dropIter.hasNext()) {
            val d = dropIter.next()
            val dist = sqrt((h.x - d.second)*(h.x - d.second) + (h.y - d.third)*(h.y - d.third))
            if (dist < 1.2f) {
                h.addItem(d.first)
                floatTexts.add(FloatText("+${GameData.ITEMS[d.first].name}", h.x, h.y - 1f, 0x00FFFF.toInt()))
                dropIter.remove()
            }
        }
        
        // Update enemies
        for (e in enemies) {
            if (!e.alive) continue
            val attacks = e.update(h.x, h.y, GameData.MAP)
            if (attacks && h.hurtTimer <= 0) {
                val dmg = e.def.atk + (0 until e.def.atk / 2 + 1).random()
                h.takeDamage(dmg)
                floatTexts.add(FloatText("-$dmg", h.x, h.y - 0.5f, 0xFF4444.toInt()))
            }
        }
        enemies.removeAll { !it.alive }
        
        // Update float texts
        floatTexts.removeAll { !it.update() }
        
        // Camera follow hero
        val isoX = (h.x - h.y) * GameData.TILE_W / 2f
        val isoY = (h.x + h.y) * GameData.TILE_H / 2f
        cameraX += (isoX - w / 2f - cameraX) * 0.1f
        cameraY += (isoY - this.h / 2f - cameraY) * 0.1f
        
        // MP regen
        if (h.hp > 0 && h.attackTimer <= 0) {
            h.mp = minOf(h.mp + 1, h.maxMp)
        }
        
        // Death check
        if (h.hp <= 0) {
            state = GameData.ST_DEAD
            dialogText = GameData.T.DEAD
            dialogTimer = 0
        }
        
        // Win check
        if (killCount >= totalKills) {
            state = GameData.ST_DIALOG
            dialogText = "${GameData.T.WIN} Убито: $killCount"
            dialogTimer = 120
            killCount = 0
            totalKills += 10
            spawnEnemies()
        }
    }
    
    private fun updateInventory() {
        val h = hero ?: return
        if (inputCancel || inputMenu) {
            state = GameData.ST_PLAY
            inputCancel = false; inputMenu = false
            return
        }
        val inv = h.inventory
        if (inv.isNotEmpty()) {
            if (inputDy > 0.3f) { invScroll = (invScroll + 1) % inv.size; inputDy = 0f }
            if (inputDy < -0.3f) { invScroll = (invScroll - 1 + inv.size) % inv.size; inputDy = 0f }
            if (inputConfirm && invScroll < inv.size) {
                val itemId = inv[invScroll]
                val item = GameData.ITEMS[itemId]
                if (item.type == 0) {
                    h.useItem(itemId)
                    if (invScroll >= inv.size) invScroll = maxOf(0, inv.size - 1)
                } else {
                    h.equipItem(itemId)
                    if (invScroll >= inv.size) invScroll = maxOf(0, inv.size - 1)
                }
            }
        }
        inputConfirm = false
    }
    
    fun isoToScreen(tx: Float, ty: Float): Pair<Float, Float> {
        val ix = (tx - ty) * GameData.TILE_W / 2f - cameraX
        val iy = (tx + ty) * GameData.TILE_H / 2f - cameraY
        return Pair(ix + w / 2f, iy + this.h / 2f)
    }
}

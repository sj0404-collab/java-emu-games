package com.heroeslore.v1

import java.util.concurrent.CopyOnWriteArrayList

class Hero(clsId: Int) {
    val clsId: Int = clsId
    val clsName: String = GameData.CLASSES[clsId].name
    
    var x: Float = 5f
    var y: Float = 5f
    var dir: Int = 0 // 0=down,1=left,2=right,3=up
    var moving: Boolean = false
    var attacking: Boolean = false
    var attackTimer: Int = 0
    var animFrame: Int = 0
    var animTimer: Int = 0
    
    // Stats
    var level: Int = 1
    var exp: Int = 0
    var expNext: Int = 50
    var gold: Int = 0
    var maxHp: Int = GameData.CLASSES[clsId].hp
    var hp: Int = maxHp
    var maxMp: Int = 30 + clsId * 5
    var mp: Int = maxMp
    var baseAtk: Int = GameData.CLASSES[clsId].atk
    var baseDef: Int = GameData.CLASSES[clsId].def
    var baseSpd: Int = GameData.CLASSES[clsId].spd
    var bonusAtk: Int = 0
    var bonusDef: Int = 0
    var bonusSpd: Int = 0
    
    val atk: Int get() = baseAtk + bonusAtk + level * 2
    val def: Int get() = baseDef + bonusDef + level
    val spd: Int get() = baseSpd + bonusSpd
    
    // Equipment slots: weapon, armor, accessory
    val equipment = IntArray(3) { -1 }
    val inventory = CopyOnWriteArrayList<Int>() // item ids
    
    // Skills
    val learnedSkills = mutableListOf(0) // start with basic attack
    
    // Combat cooldowns
    var attackCd: Int = 0
    var hurtTimer: Int = 0
    
    fun addExp(amount: Int) {
        exp += amount
        while (exp >= expNext) {
            exp -= expNext
            level++
            expNext = (expNext * 1.5f).toInt()
            maxHp += 10 + clsId * 2
            maxMp += 3 + clsId
            hp = maxHp
            mp = maxMp
            // Check new skills
            for (sk in GameData.SKILLS) {
                if (sk.lvl == level && sk.id !in learnedSkills) {
                    learnedSkills.add(sk.id)
                }
            }
        }
    }
    
    fun addItem(id: Int) {
        inventory.add(id)
    }
    
    fun useItem(id: Int): Boolean {
        val item = GameData.ITEMS.getOrNull(id) ?: return false
        if (item.type == 0) { // consumable
            // id 0,1 = HP potions, id 2 = MP potion (see GameData)
            when (id) {
                0, 1 -> hp = minOf(hp + item.value, maxHp)
                2 -> mp = minOf(mp + item.value, maxMp)
                else -> {
                    if (item.name.contains("HP")) hp = minOf(hp + item.value, maxHp)
                    else if (item.name.contains("MP") || item.name.contains("МП")) mp = minOf(mp + item.value, maxMp)
                    else hp = minOf(hp + item.value, maxHp)
                }
            }
            inventory.remove(Integer.valueOf(id))
            return true
        }
        return false
    }
    
    fun equipItem(id: Int) {
        val item = GameData.ITEMS.getOrNull(id) ?: return
        val slot = when (item.type) {
            1 -> 0 // weapon
            2 -> 1 // armor
            3 -> 2 // accessory
            else -> return
        }
        // Unequip old
        if (equipment[slot] >= 0) {
            inventory.add(equipment[slot])
            val old = GameData.ITEMS.getOrNull(equipment[slot]) ?: return
            when (slot) {
                0 -> bonusAtk -= old.value
                1 -> bonusDef -= old.value
                2 -> bonusSpd -= old.value
            }
        }
        equipment[slot] = id
        inventory.remove(Integer.valueOf(id))
        when (slot) {
            0 -> bonusAtk += item.value
            1 -> bonusDef += item.value
            2 -> bonusSpd += item.value
        }
    }
    
    fun takeDamage(dmg: Int) {
        val actual = maxOf(1, dmg - def / 2)
        hp -= actual
        hurtTimer = 15
        if (hp <= 0) hp = 0
    }
    
    fun heal(amount: Int) {
        hp = minOf(hp + amount, maxHp)
    }
}

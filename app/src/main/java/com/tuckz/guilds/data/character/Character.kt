package com.tuckz.guilds.data.character

class Character(var name: String, var description: String) {
    var race = Race.GOBLIN
    var job = Job.ADVENTURER
    var stats = Stats()
    var curSpeed = 0

    fun setSpeed(speed: Int) {
        stats.speed = speed
        curSpeed = speed
    }
    fun getCurrentSpeed(): Int {
        return curSpeed
    }

    fun getSpeed(): Int {
        return stats.speed
    }

}
package com.tuckz.guilds.data.adventure.event

import android.util.Log
import com.tuckz.guilds.data.adventure.Adventure
import com.tuckz.guilds.data.character.Character
import com.tuckz.guilds.data.character.Stats
import java.util.*
import kotlin.collections.ArrayList

class BattleEvent(msg: String) : Event(msg) {
    var characterList = ArrayList<Character>()
    var queue = Stack<Character>()
    var lastTimeCheck = 0;

    override fun runEvent(adventure: Adventure, steps: Int): Boolean {
        eventSteps += steps
        // Step 1: Create a queue of turns using an stack.
        Log.d("Battle", msg)
        // create a list of all the characters within the battle
        characterList.addAll(createMonstersToFight())
        characterList.addAll(adventure.getCharacters())
        sortBattleOrder()
        isComplete = false

        return isComplete
    }

    private fun runBattle() {
        var currentChar = queue.peek()
        // get currentTime

    }

    /*

     */
    private fun sortBattleOrder() {
        var sortedList = characterList.sortedWith(compareBy {
            it.stats.speed
        })
        queue.clear()
        queue.addAll(sortedList)
    }


    private fun createMonstersToFight(): ArrayList<Character> {
        // create some gobb lobs
        val list = ArrayList<Character>()
        for (i in 1..2) {
            var gob = Character("Goblin: $i", "Pointy-Monster")
            gob.stats.speed = 7
            list.add(gob)
        }
        return list
    }
}
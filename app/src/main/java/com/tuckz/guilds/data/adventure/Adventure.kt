package com.tuckz.guilds.data.adventure

import android.util.Log
import com.tuckz.guilds.data.adventure.route.Route
import com.tuckz.guilds.data.character.Character
import kotlin.collections.ArrayList

class Adventure(
    val uid: Int = 0,
    private var routesIndex: ArrayList<Int> = ArrayList<Int>(),
    var currentSteps: Int = 0,
    var curRoute: Int = 0,
    private var routes: ArrayList<Route> = ArrayList<Route>()
) {

    private var characters = ArrayList<Character>()

    init {
        createRoutes()
        var c = Character("Test Hero", "Used for testing")
        c.setSpeed(3)
        c.stats.attack = 3
        c.stats.defence = 3
        characters.add(c)
    }

    fun getCharacters(): ArrayList<Character> {
        return characters
    }

    /*
    runs the adventure here
     */
    fun runAdventure(stepsTaken: Int) {
        currentSteps += stepsTaken
        Log.d("Adventure", currentSteps.toString())
        increaseSteps(stepsTaken)
    }

    /*
    If the adventure has been finished return true
    */
    fun isComplete(): Boolean {
        return routes.isEmpty()
    }


    private fun increaseSteps(stepsTaken: Int) {
        // check eventTimes
        if (routes!![curRoute!!].checkForEvent(this)) {
            // if an event is found remove the
            // amount of steps from the currentSteps taken
            currentSteps -= stepsTaken
        }
    }

    private fun createRoutes() {
        for (i in routesIndex!!) {
            when (i) {
                1 -> routes!!.add(Route())
            }
        }
    }
}
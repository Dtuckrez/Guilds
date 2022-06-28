package com.tuckz.guilds.data.adventure.event

import android.util.Log
import com.tuckz.guilds.data.adventure.Adventure

open class Event(protected val msg: String) {
    // Type of event, monster fight, random npc, found item etc
    var eventSteps = 0;
    var isComplete = false


    open fun runEvent(adventure: Adventure, steps: Int): Boolean {
        eventSteps += steps
        Log.d("Adventure", msg)
        return true
    }
}
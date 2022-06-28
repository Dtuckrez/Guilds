package com.tuckz.guilds.data.adventure.route

import com.tuckz.guilds.data.adventure.Adventure
import com.tuckz.guilds.data.adventure.event.BattleEvent
import com.tuckz.guilds.data.adventure.event.Event
import kotlin.collections.ArrayDeque

class Route {
    val name = "Test Route"
    var currentSteps = 0
    // 60 steps = 30ish seconds
    var routeSteps = 60

    private val events = arrayOf<Event>(
        Event("Start of route"),
        BattleEvent("Battle"),
        Event("End of route"))
    private var eventStack = ArrayDeque<Event>()
    lateinit var curEvent: Event

    init {
        eventStack.addAll(events)
    }

    // Start at 0 so the first event is a new route event
    private var nextEventTime = 5;

    fun checkForEvent(adventure: Adventure): Boolean {
        // set the steps to the current adventure steps
        currentSteps = adventure.currentSteps
        var foundEvent = false
        if (currentSteps >= nextEventTime) {
            if (eventStack.size > 0) {
                curEvent = eventStack.first()
            }
            if (curEvent.runEvent(adventure, 0)) {
                eventStack.removeFirst()
            }
            foundEvent = true
        }

        return foundEvent
    }
}
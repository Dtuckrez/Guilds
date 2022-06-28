package com.tuckz.guilds

import android.app.Application
import android.util.Log
import com.tuckz.guilds.data.adventure.Adventure
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class GuildApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    lateinit var scope: CoroutineScope

    lateinit var a: Adventure
    override fun onCreate() {
        super.onCreate()
        val context: CoroutineContext = Job() + Dispatchers.Default
        scope = CoroutineScope(context)
        var routes = ArrayList<Int>()
        routes.add(1)
        a = Adventure(0, routes, 0, 0)
//        runAdventure()
    }

    // Launch new coroutine -> Adventure Run Service
    private fun runAdventure() {
        scope.launch(start = CoroutineStart.DEFAULT) {
            val startTime = System.currentTimeMillis()
            var curTime = startTime
            var lastTime = startTime
            var stepsTaken = 0
            while (!a.isComplete()) {
                val curSeconds = curTime / 1000;
                val lstSeconds = lastTime / 1000;
                var timePassed = curSeconds - lstSeconds
                if (timePassed >= 2L) {
                    // take one step along the adventure
                    a.runAdventure(1)
                }
                curTime = System.currentTimeMillis()
            }
        }

    }
}
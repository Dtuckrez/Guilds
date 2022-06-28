package com.tuckz.guilds.net

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.OutputStream
import java.net.Socket
import java.nio.charset.Charset
import java.util.*

class Client(var address: String, var port: Int) {
    private var connection: Socket? = null
    private var connected: Boolean = true

    init {
        println("Connected to server at $address on port $port")
    }

    private var reader: Scanner? = null
    private var writer: OutputStream? = null

    fun run() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                connection = Socket(address, port)

                reader = Scanner(connection!!.getInputStream())
                writer = connection!!.getOutputStream()
            } catch (e: Exception) {
                connected = false
                Log.e("Client.kt", "Could not connect to the socket")
            }
            while (connected) {
                read()
            }
        }


    }

    private fun write(message: String) {
        writer!!.write((message + '\n').toByteArray(Charset.defaultCharset()))
    }

    private fun read() {
//        while (connected)
//            println(reader!!.nextLine())
    }
}
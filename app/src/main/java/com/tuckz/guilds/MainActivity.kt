package com.tuckz.guilds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tuckz.guilds.navigation.SetupNavGraph
import com.tuckz.guilds.net.Client
import com.tuckz.guilds.ui.theme.GuildsTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    var client: Client? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuildsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()
                    SetupNavGraph(application, navController)
                }
            }
        }
        clientConnect()
    }

    private fun clientConnect() {
        lifecycleScope.launch {
            client = Client("10.0.2.2", 8080)
            client!!.run()
        }
    }
}
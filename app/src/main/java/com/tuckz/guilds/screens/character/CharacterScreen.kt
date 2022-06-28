package com.tuckz.guilds.screens.character

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tuckz.guilds.ui.theme.GuildsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterScreen(navController: NavHostController?) {
    // Find from db based on adventure GUID passed it from nav

    Box {
        Text("TEST ON SCREEN")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuildsTheme {
        var navController = rememberNavController()
        CharacterScreen(navController)
    }
}

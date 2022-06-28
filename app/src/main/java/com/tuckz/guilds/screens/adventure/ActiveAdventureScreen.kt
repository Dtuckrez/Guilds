package com.tuckz.guilds.screens.adventure

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tuckz.guilds.ui.theme.GuildsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ActiveAdventureScreen(navController: NavHostController?,
                          adventureViewModel: AdventureViewModel) {
    // Find from db based on adventure GUID passed it from nav

    val uiState by adventureViewModel.uiState.collectAsState()
    Box {
        Text(text = uiState.lastMsg)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GuildsTheme {
        var navController = rememberNavController()
        ActiveAdventureScreen(navController, AdventureViewModel(null))
    }
}

package com.tuckz.guilds.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tuckz.guilds.MainMenuScreen
import com.tuckz.guilds.screens.adventure.ActiveAdventureScreen
import com.tuckz.guilds.screens.adventure.AdventureViewModel
import com.tuckz.guilds.screens.character.CharacterScreen
import com.tuckz.guilds.screens.login.LoginScreen
import com.tuckz.guilds.screens.login.LoginViewModel
import com.tuckz.guilds.screens.tavern.TavernScreen

@Composable
fun SetupNavGraph(application: Application, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            var viewModel = LoginViewModel(application)
            LoginScreen(navController, viewModel)
        }
        composable(route = Screen.Home.route) {
            MainMenuScreen(navController)
        }
        composable(route = Screen.Tavern.route) {
            TavernScreen(navController)
        }
        composable(route = Screen.Adventure.route) {
            var viewModel = AdventureViewModel(application)
            ActiveAdventureScreen(navController, viewModel)
        }
        composable(route = Screen.Character.route) {
            CharacterScreen(navController)
        }
    }
}
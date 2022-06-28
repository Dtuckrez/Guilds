package com.tuckz.guilds.navigation

sealed class Screen(val route: String) {
    object Login: Screen(route = "login_screen")
    object Home: Screen(route = "main_menu_screen")
    object Tavern: Screen(route = "tavern_screen")
    object Adventure: Screen(route = "adventure_screen")
    object Character: Screen(route = "character_screen")

}
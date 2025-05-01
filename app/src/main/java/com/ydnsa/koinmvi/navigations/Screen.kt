package com.ydnsa.koinmvi.navigations

sealed class Screen(val route:String) {
    object Login : Screen("Login")
    object Home: Screen("Home")
    object NotesItemList: Screen("notelist")
}
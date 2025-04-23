package com.ydnsa.koinmvi.navigations


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ydnsa.koinmvi.presentation.login.composables.LoginScreen

@Composable
fun AppNavGraph(navHostController: NavHostController){

    NavHost(navHostController, startDestination = Screen.Login.route){

        composable(Screen.Login.route){
            LoginScreen()
        }
    }
}
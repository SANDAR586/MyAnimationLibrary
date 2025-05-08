package com.ydnsa.koinmvi.navigations


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ydnsa.koinmvi.presentation.home.HomeRoute
import com.ydnsa.koinmvi.presentation.login.LoginRoot
import com.ydnsa.koinmvi.presentation.noteitemlist.NoteItemListRoute
import com.ydnsa.koinmvi.presentation.noteitemlist.components.navdetail.NoteEditScreen

@Composable
fun AppNavGraph(navHostController: NavHostController){

    NavHost(navHostController, startDestination = Screen.Login.route){

        composable(Screen.Login.route){
            LoginRoot(navHostController)
        }
        composable(Screen.Home.route){
            HomeRoute(navHostController)
        }
        composable (Screen.NotesItemList.route){
            NoteItemListRoute(
                navHostController
            )
        }
        composable (Screen.NoteEdit.route){
            NoteEditScreen(navHostController)
        }
    }



}
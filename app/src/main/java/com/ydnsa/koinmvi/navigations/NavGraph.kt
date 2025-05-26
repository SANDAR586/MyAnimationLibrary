package com.ydnsa.koinmvi.navigations

import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.ydnsa.koinmvi.presentation.home.*
import com.ydnsa.koinmvi.presentation.login.*
import com.ydnsa.koinmvi.presentation.notebook.NoteList.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*

@Composable
fun AppNavGraph(navHostController : NavHostController)
{

    NavHost(navHostController , startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            LoginRoot(navHostController)
        }
        composable(Screen.Home.route) {
            HomeRoute(navHostController)
        }
        composable(Screen.NotesItemList.route) {
            NoteItemListRoute(
                    navHostController
                             )
        }
        composable(Screen.NoteEdit.route) {
            NoteDetailRoute(navHostController)
        }
    }

}
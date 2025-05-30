package com.ydnsa.koinmvi.navigations

import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.ydnsa.koinmvi.presentation.home.*
import com.ydnsa.koinmvi.presentation.login.*
import com.ydnsa.koinmvi.presentation.notebook.noteList.*
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
        composable(
            route = "editNote/{noteId}" ,
            arguments = listOf(navArgument("noteId") {
                type = NavType.StringType
            })
                  ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")
            NoteDetailRoute(navHostController , noteId ?: "")
        }
    }

}
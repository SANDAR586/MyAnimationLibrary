package com.ydnsa.koinmvi.presentation.notebook.noteList

import androidx.compose.runtime.*
import androidx.navigation.*
import com.ydnsa.koinmvi.presentation.notebook.noteList.components.*
import org.koin.androidx.compose.*

@Composable
fun NoteItemListRoute(
    navHostController : NavHostController ,
    viewModel : NoteItemListViewModel = koinViewModel<NoteItemListViewModel>()
                     )
{

    NoteItemListScreen(
        navHostController
                      )
}



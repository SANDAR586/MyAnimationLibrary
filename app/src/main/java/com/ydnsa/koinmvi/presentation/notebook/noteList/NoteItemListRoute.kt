package com.ydnsa.koinmvi.presentation.notebook.noteList

import androidx.compose.runtime.*
import androidx.lifecycle.compose.*
import androidx.navigation.*
import com.ydnsa.koinmvi.presentation.notebook.noteList.components.*

@Composable
fun NoteItemListRoute(
    navHostController : NavHostController
                     )
{
    val coordinator = rememberNoteItemListCoordinator()
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(NoteItemListState())

    // UI Actions
    val actionsHandler : (NoteItemListAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    NoteItemListScreen(
        state = uiState ,
        onAction = actionsHandler ,
        navHostController
                      )
}



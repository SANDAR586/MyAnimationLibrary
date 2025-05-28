package com.ydnsa.koinmvi.presentation.notebook.notedetail

import androidx.compose.runtime.*
import androidx.lifecycle.compose.*
import androidx.navigation.*
import com.mohamedrejeb.richeditor.model.*

@Composable
fun NoteDetailRoute(
    navHostController : NavHostController ,
    notedId : String ,
    coordinator : NoteDetailCoordinator =
        rememberNoteDetailCoordinator() ,

                   )
{
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(NoteDetailState())

    // UI Actions
    val actionsHandler : (NoteDetailAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    NoteDetailScreen(
        state = uiState ,
        onAction = actionsHandler ,
        navHostController ,
        notedId ,

                    )
}



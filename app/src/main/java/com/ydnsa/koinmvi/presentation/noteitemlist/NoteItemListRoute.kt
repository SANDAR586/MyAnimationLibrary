package com.ydnsa.koinmvi.presentation.noteitemlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember


import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController


@Composable
fun NoteItemListRoute(
        navHostController: NavHostController
) {
    val coordinator =rememberNoteItemListCoordinator()
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(NoteItemListState())

    // UI Actions
    val actionsHandler: (NoteItemListAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    NoteItemListScreen(
        state = uiState,
        onAction = actionsHandler,
        navHostController
    )
}



package com.ydnsa.koinmvi.presentation.notebook.notedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun NoteDetailRoute(
		coordinator : NoteDetailCoordinator = rememberNoteDetailCoordinator()
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
			onAction = actionsHandler
	                )
}



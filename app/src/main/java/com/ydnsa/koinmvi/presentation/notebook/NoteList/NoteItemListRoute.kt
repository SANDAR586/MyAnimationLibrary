package com.ydnsa.koinmvi.presentation.notebook.NoteList

import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.*
import com.ydnsa.koinmvi.presentation.notebook.NoteList.components.NoteItemListScreen

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



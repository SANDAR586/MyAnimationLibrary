package com.ydnsa.koinmvi.presentation.notebook.notedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.androidx.compose.koinViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class NoteDetailCoordinator(
		val viewModel : NoteDetailViewModel
                           )
{
	val screenStateFlow = viewModel.stateFlow
	fun handle(action : NoteDetailAction)
	{
		when (action)
		{
			NoteDetailAction.OnClick ->
			{ /* Handle action */
			}
		}
	}
	
}

@Composable
fun rememberNoteDetailCoordinator(
		viewModel : NoteDetailViewModel = koinViewModel()
                                 ) : NoteDetailCoordinator
{
	return remember(viewModel) {
		NoteDetailCoordinator(
				viewModel = viewModel
		                     )
	}
}
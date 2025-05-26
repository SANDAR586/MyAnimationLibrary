package com.ydnsa.koinmvi.presentation.notebook.notedetail

import androidx.compose.runtime.*
import org.koin.androidx.compose.*

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class NoteDetailCoordinator(val viewModel : NoteDetailViewModel)
{
    val screenStateFlow = viewModel.stateFlow
    fun handle(action : NoteDetailAction)
    {
        when (action)
        {
            NoteDetailAction.OnEditNote       ->
            {
            }

            is NoteDetailAction.OnSaveNewNote ->
            {
                viewModel.saveNewFiles(action.htmlString , action.title)
            }
        }
    }

}

@Composable
fun rememberNoteDetailCoordinator(
        viewModel : NoteDetailViewModel = koinViewModel() ,
                                 ) : NoteDetailCoordinator
{
    return remember(viewModel) {
        NoteDetailCoordinator(
                viewModel = viewModel
                             )
    }
}
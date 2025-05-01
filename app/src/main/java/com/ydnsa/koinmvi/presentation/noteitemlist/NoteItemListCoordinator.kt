package com.ydnsa.koinmvi.presentation.noteitemlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.androidx.compose.koinViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class NoteItemListCoordinator(
    val viewModel: NoteItemListViewModel,
) {
    val screenStateFlow = viewModel.stateFlow
    fun handle(action: NoteItemListAction) {
        when (action) {
            NoteItemListAction.OnClick -> { /* Handle action */
            }

            NoteItemListAction.OnCreate -> {
                viewModel.createFolder()
            }
        }
    }


}

@Composable
fun rememberNoteItemListCoordinator(
    viewModel: NoteItemListViewModel = koinViewModel(),
): NoteItemListCoordinator {
    return remember(viewModel) {
        NoteItemListCoordinator(
            viewModel = viewModel
        )
    }
}
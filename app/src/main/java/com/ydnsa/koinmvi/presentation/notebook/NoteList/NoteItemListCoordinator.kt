package com.ydnsa.koinmvi.presentation.notebook.NoteList

import androidx.compose.runtime.*
import org.koin.androidx.compose.*

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class NoteItemListCoordinator(
        val viewModel : NoteItemListViewModel ,
                             )
{
    val screenStateFlow = viewModel.stateFlow
    fun handle(action : NoteItemListAction)
    {
        when (action)
        {
            NoteItemListAction.OnEdit   ->
            {
            }

            NoteItemListAction.OnCreate ->
            {
            }

        }
    }

}

@Composable
fun rememberNoteItemListCoordinator(
        viewModel : NoteItemListViewModel = koinViewModel() ,
                                   ) : NoteItemListCoordinator
{
    return remember(viewModel) {
        NoteItemListCoordinator(
                viewModel = viewModel
                               )
    }
}
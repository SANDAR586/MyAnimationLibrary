package com.ydnsa.koinmvi.presentation.noteitemlist

import androidx.compose.ui.tooling.preview.PreviewParameterProvider


/**
 * UI State that represents NoteItemListScreen
 **/
data class NoteItemListState(
    val files : List<String> = emptyList<String>()
)

/**
 * NoteItemList Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface NoteItemListAction {
    data object OnClick : NoteItemListAction
    data object OnCreate: NoteItemListAction
}


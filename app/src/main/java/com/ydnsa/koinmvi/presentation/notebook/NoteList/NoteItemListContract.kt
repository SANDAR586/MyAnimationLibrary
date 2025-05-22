package com.ydnsa.koinmvi.presentation.notebook.NoteList

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

sealed interface NoteItemListAction
{
	data object OnClick : NoteItemListAction
	data object OnCreate : NoteItemListAction
    data object OnSaveNewFile: NoteItemListAction
    data object OnBackButtonClick: NoteItemListAction
}


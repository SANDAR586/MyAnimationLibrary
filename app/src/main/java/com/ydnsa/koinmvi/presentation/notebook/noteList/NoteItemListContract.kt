package com.ydnsa.koinmvi.presentation.notebook.noteList

import com.ydnsa.koinmvi.data.local.*

/**
 * UI State that represents NoteItemListScreen
 **/
data class NoteItemListState(
    val noteItems : List<FileEntity> = emptyList<FileEntity>() ,
                            )

/**
 * NoteItemList Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface NoteItemListAction
{
    data object OnEdit : NoteItemListAction
    data object OnCreate : NoteItemListAction

}


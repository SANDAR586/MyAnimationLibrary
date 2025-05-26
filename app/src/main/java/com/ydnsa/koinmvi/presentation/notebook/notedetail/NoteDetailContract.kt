package com.ydnsa.koinmvi.presentation.notebook.notedetail

import com.ydnsa.koinmvi.data.local.*

/**
 * UI State that represents NoteDetailScreen
 **/
data class NoteDetailState(
        val fileEntity : FileEntity? = null ,
                          )

/**
 * NoteDetail Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface NoteDetailAction
{
    data class OnSaveNewNote(val htmlString : String , val title : String) : NoteDetailAction
    data object OnEditNote : NoteDetailAction
}




package com.ydnsa.koinmvi.presentation.notebook.notedetail

/**
 * UI State that represents NoteDetailScreen
 **/
class NoteDetailState

/**
 * NoteDetail Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface NoteDetailAction
{
    data object OnSaveNewNote : NoteDetailAction
    data object OnEditNote : NoteDetailAction
}




package com.ydnsa.koinmvi.presentation.notebook.NoteList

import androidx.lifecycle.*
import com.ydnsa.koinmvi.data.local.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class NoteItemListViewModel(
        val savedStateHandle : SavedStateHandle ,
        val fileDao : FileDao ,
                           ) : ViewModel()
{
    init
    {
        listNotes()
    }

    private val _stateFlow : MutableStateFlow<NoteItemListState> =
            MutableStateFlow(NoteItemListState())

    val stateFlow : StateFlow<NoteItemListState> = _stateFlow.asStateFlow()

    fun listNotes()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val files = fileDao.getAllFiles()
            withContext(Dispatchers.Main) {
                _stateFlow.update { current ->
                    current.copy(
                            noteItems = files
                                )
                }
            }
        }
    }

}
package com.ydnsa.koinmvi.presentation.notebook.noteList

import android.util.*
import androidx.lifecycle.*
import com.ydnsa.koinmvi.data.local.*
import kotlinx.coroutines.flow.*

class NoteItemListViewModel(
    val savedStateHandle : SavedStateHandle ,
    val fileDao : FileDao ,
                           ) : ViewModel()
{

    val allFiles : StateFlow<List<FileEntity>> = fileDao.getAllFiles()
        .onStart {
            Log.d("room" , "file fetching started")
        }.stateIn(
            viewModelScope ,
            SharingStarted.WhileSubscribed(500) ,
            emptyList()
                 )

}
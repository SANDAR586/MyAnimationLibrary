package com.ydnsa.koinmvi.presentation.noteitemlist

import android.app.Application
import android.content.Context
import android.os.Environment
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.File

class NoteItemListViewModel(
   val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val myfile: String="my notes"

    private val _stateFlow: MutableStateFlow<NoteItemListState> =
        MutableStateFlow(NoteItemListState())

    val stateFlow: StateFlow<NoteItemListState> = _stateFlow.asStateFlow()

    fun  createFolder(){
        val rootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
       val directory=File(rootDir,myfile)
        if (!directory.exists()){
            directory.mkdirs() // true
        }
        listFiles()
    }

    fun listFiles(){
        val rootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
    val directory= File(rootDir,myfile)
         if(directory.exists() && directory.isDirectory){
           _stateFlow.update { current ->
               current.copy(files =  directory.list()?.toList() ?: emptyList())
           }
        } else {
             _stateFlow.update { current ->
                 current.copy(files =  directory.list()?.toList() ?: emptyList())
             }
        }
    }




}
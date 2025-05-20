package com.ydnsa.koinmvi.presentation.noteitemlist


import android.annotation.SuppressLint
import android.os.Environment
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.File
import java.io.FileOutputStream

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

    @SuppressLint("SuspiciousIndentation")
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


    fun saveFiles(htmlString: String){
        try{
            val rootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
            val testFile=File("$rootDir/$myfile","testing3.html")
            FileOutputStream(testFile).use { it.write(htmlString.toByteArray())
            }

        }catch (e: Exception){
            Log.e("Error",e.message.toString())

        }
    }




}
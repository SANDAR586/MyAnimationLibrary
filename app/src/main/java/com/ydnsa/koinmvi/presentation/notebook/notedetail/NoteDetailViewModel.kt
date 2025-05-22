package com.ydnsa.koinmvi.presentation.notebook.notedetail

import android.os.*
import android.util.*
import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import java.io.*
import java.time.*
import java.time.format.*

class NoteDetailViewModel(
        savedStateHandle : SavedStateHandle ,
                         ) : ViewModel()
{
    val myfile : String = "my notes"
    private val _stateFlow : MutableStateFlow<NoteDetailState> = MutableStateFlow(NoteDetailState())

    val stateFlow : StateFlow<NoteDetailState> = _stateFlow.asStateFlow()

    fun saveNewFiles(htmlString : String)
    {
        try
        {
            val rootDir =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
            val filename = getTimestampFileName()
            val testFile = File("$rootDir/$myfile" , "$filename.html")
            FileOutputStream(testFile).use {
                it.write(htmlString.toByteArray())
            }
        }
        catch (e : Exception)
        {
            Log.e("Error" , e.message.toString())
        }
    }

    fun getTimestampFileName() : String
    {
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
                .withZone(ZoneId.systemDefault())
        return formatter.format(Instant.now())
    }
}
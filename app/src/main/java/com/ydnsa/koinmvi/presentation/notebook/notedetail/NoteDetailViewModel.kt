package com.ydnsa.koinmvi.presentation.notebook.notedetail

import android.util.*
import androidx.lifecycle.*
import com.ydnsa.koinmvi.data.local.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.*

class NoteDetailViewModel(
    val savedStateHandle : SavedStateHandle ,
    val fileDao : FileDao ,
    val localAccessHelper : LocalAccessHelper
                         ) : ViewModel()
{

    val noteId : String? = savedStateHandle["noteId"]
    private val _editor = MutableStateFlow("")
    val contents : StateFlow<String> = _editor

    private val _title = MutableStateFlow("")
    val title : StateFlow<String> = _title
    private val _stateFlow : MutableStateFlow<NoteDetailState> = MutableStateFlow(NoteDetailState())
    val stateFlow : StateFlow<NoteDetailState> = _stateFlow.asStateFlow()

    init
    {
        readFile()

    }

    fun saveNewFiles(content : String , title : String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val file = localAccessHelper.writeFile(content)
            if (file != null)
            {
                addFileToRoom(file , content , title)
            }
        }
    }

    fun readFile()
    {
        viewModelScope.launch(Dispatchers.IO) {
            if (noteId != null && noteId != "empty" && noteId.isNotBlank())
            {
                val fileEntity = fileDao.findByNameFile(noteId)
                if (fileEntity != null)
                {
                    _title.value=fileEntity.title
                    _editor.value = localAccessHelper.readFile(fileEntity)
                }
            }
        }
    }

    fun addFileToRoom(filename : File , content : String , title : String)
    {
        val fileEnity = FileEntity(
            uid = filename.name ,
            folderName = "" ,
            fileLocation = filename.path ,
            title = title ,
            content = localAccessHelper.getDisplayContent(content) ,
            timestamp = System.currentTimeMillis()
                                  )
        try
        {
            fileDao.insertFile(fileEnity)
        } catch (e : Exception)
        {
            Log.e("Error" , e.message ?: e.toString())
        }

    }

}
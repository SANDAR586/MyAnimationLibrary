package com.ydnsa.koinmvi.presentation.notebook.notedetail

import android.os.*
import android.text.*
import android.util.*
import androidx.lifecycle.*
import com.ydnsa.koinmvi.data.local.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.*
import java.time.*
import java.time.format.*

class NoteDetailViewModel(
    val savedStateHandle : SavedStateHandle ,
    val fileDao : FileDao ,
                         ) : ViewModel()
{
    val noteId : String? = savedStateHandle["noteId"]
    val myfile : String = "my notes"
    private val _stateFlow : MutableStateFlow<NoteDetailState> = MutableStateFlow(NoteDetailState())
    val stateFlow : StateFlow<NoteDetailState> = _stateFlow.asStateFlow()

    init
    {
        Log.d("noteId" , noteId ?: "empty")
    }

    fun saveNewFiles(htmlString : String , title : String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            createFolder()
            val fileName = getFileLocation()
            writeFile(htmlString , title , fileName)
            addFileToRoom(htmlString , title , myfile , fileName)

        }

    }

    fun writeFile(htmlString : String , title : String , testFile : File)
    {
        {
            try
            {

                FileOutputStream(testFile).use {
                    it.write(htmlString.toByteArray())
                }

            } catch (e : Exception)
            {
                Log.e("Error" , e.message.toString())
            }
        }
    }

    fun createFolder()
    {
        val rootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val directory = File(rootDir , myfile)
        if (! directory.exists())
        {
            directory.mkdirs() // true
        }

    }

    fun getFileLocation() : File
    {
        val rootDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        val filename = getTimestampFileName()
        return File("$rootDir/$myfile" , "$filename.html")
    }

    fun getTimestampFileName() : String
    {
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
            .withZone(ZoneId.systemDefault())
        return formatter.format(Instant.now())
    }

    fun addFileToRoom(htmlString : String , title : String , fileId : String , filename : File)
    {
        val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy").withZone(ZoneId.systemDefault())
        formatter.format(Instant.now())
        val it = Instant.now()
        it.toString()
        val content = getContentfromHtml(htmlString)
        val fileEnity = FileEntity(
            uid = filename.name ,
            folderName = fileId ,
            fileLocation = filename.path ,
            title = title ,
            content = content ,
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

    fun getContentfromHtml(htmlString : String) : String
    {
        val content = Html.fromHtml(htmlString , Html.FROM_HTML_MODE_LEGACY)
        val words = content.trim().split("\\s+".toRegex())
        return if (words.size <= 5)
        {
            htmlString.trim()
        } else
        {
            words.take(5).joinToString(" ")
        }
    }
}
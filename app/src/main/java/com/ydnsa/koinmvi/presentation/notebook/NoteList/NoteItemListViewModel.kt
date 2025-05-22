package com.ydnsa.koinmvi.presentation.notebook.NoteList

import android.annotation.*
import android.os.*
import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import java.io.*

class NoteItemListViewModel(
		val savedStateHandle : SavedStateHandle ,
                           ) : ViewModel()
{
	val myfile : String = "my notes"
	
	private val _stateFlow : MutableStateFlow<NoteItemListState> =
			MutableStateFlow(NoteItemListState())
	
	val stateFlow : StateFlow<NoteItemListState> = _stateFlow.asStateFlow()
	
	fun createFolder()
	{
		val rootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
		val directory = File(rootDir , myfile)
		if (! directory.exists())
		{
			directory.mkdirs() // true
		}
		listFiles()
	}
	
	@SuppressLint("SuspiciousIndentation")
	fun listFiles()
	{
		val rootDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
		val directory = File(rootDir , myfile)
		if (directory.exists() && directory.isDirectory)
		{
			_stateFlow.update { current ->
				current.copy(files = directory.list()?.toList() ?: emptyList())
			}
		}
		else
		{
			_stateFlow.update { current ->
				current.copy(files = directory.list()?.toList() ?: emptyList())
			}
		}
	}
	
}
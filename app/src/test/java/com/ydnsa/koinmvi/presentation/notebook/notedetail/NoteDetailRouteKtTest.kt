package com.ydnsa.koinmvi.presentation.notebook.notedetail

import androidx.lifecycle.*
import com.ydnsa.koinmvi.data.local.*
import junit.framework.TestCase.assertEquals
import org.junit.*

class NoteDetailRouteKtTest
{

    @Test
    fun noteId_is_retrieved_from_savedStateHandle()
    {
        val handle = SavedStateHandle(mapOf("noteId" to "123"))
        val fakeDao = FakeFileDao() // Implement this as needed

        val viewModel = NoteDetailViewModel(handle , fakeDao)

        assertEquals("123" , viewModel.savedStateHandle.get<String>("noteId"))
    }

}
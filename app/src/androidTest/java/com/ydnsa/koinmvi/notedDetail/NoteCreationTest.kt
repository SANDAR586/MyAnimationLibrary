package com.ydnsa.koinmvi.notedDetail

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.*
import androidx.lifecycle.*
import androidx.navigation.compose.*
import androidx.test.ext.junit.runners.*
import com.ydnsa.koinmvi.data.local.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*
import kotlinx.coroutines.*
import org.junit.*
import org.junit.runner.*

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class NoteCreationTest
{
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun view_new_note()
    {
        val noteId = "empty"
        val fileDao = FakeFileDao()
        val saveStateHandle = SavedStateHandle(mapOf("empty" to noteId))
        val viewModel = NoteDetailViewModel(saveStateHandle , fileDao)
        val coordinator = NoteDetailCoordinator(viewModel)

        composeTestRule.setContent {
            NoteDetailRoute(
                navHostController = rememberNavController() ,
                noteId , coordinator
                           )
        }

        composeTestRule.onNodeWithTag("Title").performClick()
        composeTestRule.onNodeWithTag("title_text").performTextInput("A new Title")
        composeTestRule.onNodeWithTag("save_title").performClick()
        composeTestRule.onNodeWithTag("editor")
            .performTextInput("Hello World, The test is tested using Integration testing")
        composeTestRule.onNodeWithTag("save_new_note").performClick()

    }
}
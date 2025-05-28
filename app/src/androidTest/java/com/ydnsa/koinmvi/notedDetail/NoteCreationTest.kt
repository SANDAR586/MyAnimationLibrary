package com.ydnsa.koinmvi.notedDetail

import androidx.compose.ui.test.junit4.*
import androidx.navigation.compose.*
import androidx.test.ext.junit.runners.*
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
        composeTestRule.setContent {
            NoteDetailRoute(
                navHostController = rememberNavController() ,
                "empty"
                           )

        }

    }
}
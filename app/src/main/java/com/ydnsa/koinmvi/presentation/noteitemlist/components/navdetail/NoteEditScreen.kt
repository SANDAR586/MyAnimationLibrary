package com.ydnsa.koinmvi.presentation.noteitemlist.components.navdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import com.ydnsa.koinmvi.presentation.cutom.CustomTopBar
import androidx.compose.foundation.layout.navigationBarsPadding

@Composable
fun NoteEditScreen(
   navHostController: NavHostController
) {

    val richTextState= rememberRichTextState()

    Scaffold(
        topBar = {
            CustomTopBar(Modifier,"Edit", null)
        },
                bottomBar = {

                        ToolBar(modifier = Modifier.navigationBarsPadding(),richTextState)

        },
    ){pad->
        Column (modifier = Modifier.padding(pad)) {
            RichTextEditor(richTextState,
                modifier = Modifier.fillMaxWidth().weight(999f)
            )
            Spacer(modifier = Modifier.weight(1f))


        }
    }

}

@Preview(name = "NoteEditScreen")
@Composable
private fun PreviewNoteEditScreen() {
    val navHostController= rememberNavController()
    NoteEditScreen(navHostController)
}
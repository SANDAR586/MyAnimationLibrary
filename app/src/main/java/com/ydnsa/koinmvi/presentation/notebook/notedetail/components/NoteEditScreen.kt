package com.ydnsa.koinmvi.presentation.notebook.notedetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.mohamedrejeb.richeditor.model.*
import com.mohamedrejeb.richeditor.ui.material3.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*

@Composable
fun NoteEditScreen(
    state : NoteDetailState ,
    onAction : (NoteDetailAction) -> Unit ,
    navHostController : NavHostController ,
    noteId : String ,
    richTextState : RichTextState
                  )
{

    Scaffold(
        topBar = {
            Spacer(Modifier.size(50.dp))
            TitleBar(
                onAction = onAction ,
                richTextState = richTextState
                    )
        } ,
        bottomBar = {
            ToolBar(modifier = Modifier.navigationBarsPadding() , richTextState)
        } ,
            ) { pad ->
        Column(modifier = Modifier.padding(pad)) {
            RichTextEditor(
                richTextState ,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(999f)
                          )
            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

@Preview(name = "NoteEditScreen")
@Composable
private fun PreviewNoteEditScreen()
{
    rememberNavController()
    //NoteEditScreen(navHostController,{})
}
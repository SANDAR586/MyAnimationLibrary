package com.ydnsa.koinmvi.presentation.notebook.notedetail.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.*
import androidx.compose.ui.tooling.preview.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.mohamedrejeb.richeditor.model.*
import com.mohamedrejeb.richeditor.ui.material3.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*
import com.ydnsa.koinmvi.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun NoteEditScreen(
    state : NoteDetailState ,
    onAction : (NoteDetailAction) -> Unit ,
    navHostController : NavHostController ,
    noteId : String ,

    )
{
    val richTextState = rememberRichTextState()
    val viewModel=koinViewModel<NoteDetailViewModel>()
    val item= viewModel.contents.collectAsState()

    LaunchedEffect(Unit) {
        if(item.value.isNotBlank()){
            richTextState.setHtml(item.value)
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TitleBar(
                        onAction = onAction ,
                        richTextState = richTextState,
                        navHostController = navHostController
                            )
                },
modifier = Modifier.fillMaxWidth().padding(WindowInsets.statusBars.asPaddingValues())
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
                    .testTag("editor")
                          )
            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

@Preview(name = "NoteEditScreen_day" ,
         uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
        )
@Preview(name = "NoteEditScreen" ,
         uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
        )

@Composable
private fun PreviewNoteEditScreen()
{
    val navHostController =rememberNavController()
    AppTheme { NoteEditScreen(
        state = NoteDetailState() ,
        onAction = {} ,
        navHostController = navHostController ,
        noteId = ""
                             ) }
}
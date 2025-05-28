package com.ydnsa.koinmvi.presentation.notebook.notedetail.components

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mohamedrejeb.richeditor.model.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*
import com.ydnsa.koinmvi.ui.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun TitleBar(
    modifier: Modifier = Modifier,
    onAction: (NoteDetailAction) -> Unit,
    richTextState: RichTextState,
    navHostController : NavHostController
            ) {
    var showDialog by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("Untitled") }
    val viewModel=koinViewModel<NoteDetailViewModel>()

    LaunchedEffect(Unit) {
   if( viewModel.noteId != "empty"){
    title=viewModel.title.value
   }
    }

    Box(
        modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
       ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
           ) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onSecondaryContainer ,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .testTag("Title")
                    .clickable { showDialog = true }
                )

                Text("Save" ,
                     color = MaterialTheme.colorScheme.onSecondaryContainer ,
                     modifier = Modifier.testTag("save_new_note").clickable{
                         onAction(NoteDetailAction.OnSaveNewNote(richTextState.toHtml(), title))
                         navHostController.popBackStack()
                     })


        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Edit Title") },
            text = {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    modifier = Modifier.testTag("title_text"),
                    singleLine = true
                         )
            },
            confirmButton = {
                TextButton(
                    onClick = { showDialog = false },
                    modifier = Modifier.testTag("save_title")
                          ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
                   )
    }
}

@Preview(name = "TitleBar - Light" ,
         uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES or android.content.res.Configuration.UI_MODE_TYPE_NORMAL ,
         showSystemUi = false
        )
@Preview(name = "TitleBar - Dark" ,
         uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO or android.content.res.Configuration.UI_MODE_TYPE_NORMAL , showBackground = true)
@Composable
private fun PreviewTitleBar()
{
    AppTheme {
        TitleBar(onAction = {} , richTextState = rememberRichTextState(), navHostController = rememberNavController())
    }
}


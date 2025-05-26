package com.ydnsa.koinmvi.presentation.notebook.notedetail.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.mohamedrejeb.richeditor.model.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.*
import com.ydnsa.koinmvi.ui.theme.*

@Composable
fun TitleBar(
        modifier : Modifier = Modifier ,
        onAction : (NoteDetailAction) -> Unit ,
        richTextState : RichTextState ,
            )
{
    var showDialog by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("Untitle") }

    Box(
            Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(
                            horizontal = 16.dp
                            )
       ) {
        Text(
                title ,
                style = MaterialTheme.typography.titleSmall ,
                modifier = Modifier
                        .clickable(
                                onClick = {
                                    showDialog = true
                                } ,
                                enabled = true
                                  )
                        .align(Alignment.CenterStart) ,
            )

        ElevatedButton(
                modifier = Modifier
                        .padding(
                                horizontal = 16.dp
                                )
                        .align(Alignment.CenterEnd) , onClick = {
            onAction(NoteDetailAction.OnSaveNewNote(richTextState.toHtml() , title))
        }) { Text("Save") }
    }

    if (showDialog)
    {
        AlertDialog(
                onDismissRequest = { showDialog = false } ,
                title = { Text("Edit Title") } ,
                text = {
                    TextField(
                            title ,
                            onValueChange = { it ->
                                title = it
                            })
                } ,
                confirmButton = {
                    Text("Ok")
                } ,
                dismissButton = {}
                   )
    }

}

@Preview(name = "TitleBar")
@Composable
private fun PreviewTitleBar()
{
    AppTheme {
        TitleBar(onAction = {} , richTextState = rememberRichTextState())
    }
}


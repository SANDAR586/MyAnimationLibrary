package com.ydnsa.koinmvi.presentation.noteitemlist.components.navdetail


import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.*
import com.ydnsa.koinmvi.presentation.noteitemlist.NoteItemListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NoteEditScreen(
   navHostController: NavHostController
) {

    val richTextState= rememberRichTextState()
    val viewModel = koinViewModel<NoteItemListViewModel>()

    Scaffold(
        topBar = {
            CustomTopBar(Modifier,"Edit", null,
                navigationIcon = {
                    Text("Save",
                        modifier = Modifier.clickable(
                            onClick = {
                                viewModel.createFolder()// my file created
                                val file = richTextState.toHtml()
                                Log.d("text",file)
                                viewModel.saveFiles(file)
                            }
                        )
                        )
                }
                )
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
package com.ydnsa.koinmvi.presentation.notebook.notedetail

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.components.*

@Composable
fun NoteDetailScreen(
    state : NoteDetailState ,
    onAction : (NoteDetailAction) -> Unit ,
    navHostController : NavHostController ,
    noteId : String
                    )
{
    NoteEditScreen(state , onAction , navHostController , noteId)
}

@Composable
@Preview(name = "NoteDetail")
private fun NoteDetailScreenPreview(
    @PreviewParameter(NoteDetailStatePreviewParameterProvider::class)
    state : NoteDetailState ,
                                   )
{
    NoteDetailScreen(
        state = state ,
        onAction = {} ,
        navHostController = rememberNavController() ,
        ""
                    )
}

/**
 * PreviewParameter Provider for NoteDetailScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class NoteDetailStatePreviewParameterProvider : PreviewParameterProvider<NoteDetailState>
{
    override val values : Sequence<NoteDetailState>
        get() = sequenceOf(
            NoteDetailState() ,
                          )
}

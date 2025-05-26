package com.ydnsa.koinmvi.presentation.notebook.NoteList.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.ydnsa.koinmvi.navigations.*
import com.ydnsa.koinmvi.presentation.cutom.*
import com.ydnsa.koinmvi.presentation.notebook.NoteList.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.components.*
import com.ydnsa.koinmvi.util.*

@Composable
fun NoteItemListScreen(
    state : NoteItemListState ,
    onAction : (NoteItemListAction) -> Unit ,
    navHostController : NavHostController ,
                      )
{

    LaunchedEffect(Unit) {
        onAction(NoteItemListAction.OnCreate)
    }

    Scaffold(
        topBar = {
            CustomTopBar(Modifier , "Note Book" , null)
        } ,

        floatingActionButton = {
            ElevatedButton(onClick = {
                navHostController.navigate(Screen.NoteEdit("empty").route)
            }) {
                Icon(
                    imageVector = Icons.Filled.Add ,
                    contentDescription = "Add"
                    )
            }
        }
            ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(state.noteItems.size) { file ->
                NoteCardItem(
                    title = state.noteItems[file].title ,
                    contentPreview = state.noteItems[file].content ,
                    date = state.noteItems[file].timestamp.getDate() ,
                    onClick = {}
                            )
            }
        }
    }

}

@Composable
@Preview(name = "NoteItemList")
private fun NoteItemListScreenPreview(
    @PreviewParameter(NoteItemListStatePreviewParameterProvider::class)
    state : NoteItemListState ,
                                     )
{
    val navHostController = rememberNavController()
    NoteItemListScreen(
        state = state ,
        onAction = {} ,
        navHostController
                      )
}

/**
 * PreviewParameter Provider for NoteItemListScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class NoteItemListStatePreviewParameterProvider : PreviewParameterProvider<NoteItemListState>
{
    override val values : Sequence<NoteItemListState>
        get() = sequenceOf(
            NoteItemListState() ,
                          )
}

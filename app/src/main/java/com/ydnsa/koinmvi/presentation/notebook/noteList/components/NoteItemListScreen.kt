package com.ydnsa.koinmvi.presentation.notebook.noteList.components

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
import com.ydnsa.koinmvi.presentation.notebook.noteList.*
import com.ydnsa.koinmvi.presentation.notebook.notedetail.components.*

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
                    fileEntity = state.noteItems[file] ,
                    onClick = {
                        navHostController.navigate(Screen.NoteEdit(state.noteItems[file].uid).route)
                    }
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

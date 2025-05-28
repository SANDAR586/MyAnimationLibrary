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
import org.koin.androidx.compose.*

@Composable
fun NoteItemListScreen(
    navHostController : NavHostController ,
                      )
{
    val viewModel = koinViewModel<NoteItemListViewModel>()
    val files by viewModel.allFiles.collectAsState(initial = emptyList())



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
            items(files) { file ->
                NoteCardItem(
                    fileEntity = file ,
                    onClick = {
                        //navigating to Edit Notes Screen
                        navHostController.navigate(Screen.NoteEdit(file.uid).route)
                    }
                            )
            }
        }
    }

}

@Composable
@Preview(name = "NoteItemList")
private fun NoteItemListScreenPreview(

                                     )
{
    val navHostController = rememberNavController()
    NoteItemListScreen(
        navHostController
                      )
}


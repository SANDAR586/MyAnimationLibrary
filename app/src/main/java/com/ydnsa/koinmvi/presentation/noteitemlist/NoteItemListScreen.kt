package com.ydnsa.koinmvi.presentation.noteitemlist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.ydnsa.koinmvi.navigations.Screen
import com.ydnsa.koinmvi.presentation.cutom.CustomTopBar


@Composable
fun NoteItemListScreen(
    state: NoteItemListState,
    onAction: (NoteItemListAction) -> Unit,
    navHostController: NavHostController
) {

    LaunchedEffect(Unit) {
       onAction( NoteItemListAction.OnCreate)
    }

   Scaffold(
       topBar = {
           CustomTopBar(Modifier,"Note Book" , null)
       },

       floatingActionButton = {
             ElevatedButton(onClick = {
                 navHostController.navigate(Screen.NoteEdit.route)
             }) {
                 Icon(imageVector = Icons.Filled.Add,
                     contentDescription = "Add"
                 )
             }
       }
   ) { padding ->
       LazyColumn(modifier = Modifier.padding(padding)) {
           items(state.files.size) { file ->
               Text(text = state.files[file])
           }
       }
   }

}

@Composable
@Preview(name = "NoteItemList")
private fun NoteItemListScreenPreview(
    @PreviewParameter(NoteItemListStatePreviewParameterProvider::class)
    state: NoteItemListState,
) {
    val navHostController= rememberNavController()
    NoteItemListScreen(
        state = state,
        onAction = {},
        navHostController
    )
}

/**
 * PreviewParameter Provider for NoteItemListScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class NoteItemListStatePreviewParameterProvider : PreviewParameterProvider<NoteItemListState> {
    override val values: Sequence<NoteItemListState>
        get() = sequenceOf(
            NoteItemListState(),
        )
}

package com.ydnsa.koinmvi.presentation.noteitemlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun NoteItemListScreen(
    state: NoteItemListState,
    onAction: (NoteItemListAction) -> Unit,
    navHostController: NavHostController
) {

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

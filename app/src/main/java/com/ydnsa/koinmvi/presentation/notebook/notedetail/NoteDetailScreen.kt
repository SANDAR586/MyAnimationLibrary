package com.ydnsa.koinmvi.presentation.notebook.notedetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter

@Composable
fun NoteDetailScreen(
		state : NoteDetailState ,
		onAction : (NoteDetailAction) -> Unit
                    )
{
	// TODO UI Rendering
}

@Composable
@Preview(name = "NoteDetail")
private fun NoteDetailScreenPreview(
		@PreviewParameter(NoteDetailStatePreviewParameterProvider::class)
		state : NoteDetailState
                                   )
{
	NoteDetailScreen(
			state = state ,
			onAction = {}
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

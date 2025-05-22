package com.ydnsa.koinmvi.presentation.notebook.notedetail.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import com.mohamedrejeb.richeditor.model.*

@Composable
fun ToolBar(
		modifier : Modifier = Modifier , editor : RichTextState ,
           )
{
	
	Row(
			modifier = modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .imePadding() ,
			horizontalArrangement = Arrangement.SpaceEvenly
	   ) {
		IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(fontWeight = FontWeight.Bold))) }) {
			Icon(Icons.Default.FormatBold , contentDescription = "Bold")
		}
		IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(fontStyle = FontStyle.Italic))) }) {
			Icon(Icons.Default.FormatItalic , contentDescription = "Italic")
		}
		IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(textDecoration = TextDecoration.Underline))) }) {
			Icon(Icons.Default.FormatUnderlined , contentDescription = "Underline")
		}
		IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(textDecoration = TextDecoration.LineThrough))) }) {
			Icon(Icons.Default.FormatStrikethrough , contentDescription = "Strikethrough")
		}
		
		
		
		IconButton(onClick = { editor.toggleUnorderedList() }) {
			Icon(Icons.Default.FormatListBulleted , contentDescription = "Bullet List")
		}
		IconButton(onClick = { editor.toggleOrderedList() }) {
			
			Icon(Icons.Default.FormatListNumbered , contentDescription = "Numbered List")
		}
		
	}
	
}

@Preview(name = "ToolBar")
@Composable
private fun PreviewToolBar()
{
	val richTextState : RichTextState = rememberRichTextState()
	ToolBar(Modifier , richTextState)
}
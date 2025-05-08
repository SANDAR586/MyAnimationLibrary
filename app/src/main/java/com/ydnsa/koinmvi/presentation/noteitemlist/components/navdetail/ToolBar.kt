package com.ydnsa.koinmvi.presentation.noteitemlist.components.navdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatBold
import androidx.compose.material.icons.filled.FormatItalic
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.FormatStrikethrough
import androidx.compose.material.icons.filled.FormatUnderlined
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.model.rememberRichTextState

@Composable
fun ToolBar(
    modifier: Modifier = Modifier, editor: RichTextState,
) {

    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .imePadding(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(fontWeight = FontWeight.Bold))) }) {
            Icon( Icons.Default.FormatBold, contentDescription = "Bold")
        }
        IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(fontStyle = FontStyle.Italic))) }) {
            Icon(Icons.Default.FormatItalic, contentDescription = "Italic")
        }
        IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(textDecoration = TextDecoration.Underline))) }) {
            Icon(Icons.Default.FormatUnderlined, contentDescription = "Underline")
        }
        IconButton(onClick = { editor.toggleSpanStyle((SpanStyle(textDecoration = TextDecoration.LineThrough))) }) {
            Icon(Icons.Default.FormatStrikethrough, contentDescription = "Strikethrough")
        }



        IconButton(onClick = { editor.toggleUnorderedList() }) {
            Icon(Icons.Default.FormatListBulleted, contentDescription = "Bullet List")
        }
        IconButton(onClick = { editor.toggleOrderedList() }) {


            Icon(Icons.Default.FormatListNumbered, contentDescription = "Numbered List")
        }

    }




}

@Preview(name = "ToolBar")
@Composable
private fun PreviewToolBar() {
    val richTextState: RichTextState = rememberRichTextState()
    ToolBar(Modifier, richTextState)
}
package com.ydnsa.koinmvi.presentation.notebook.notedetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoteCardItem(
		title : String ,
		contentPreview : String ,
		date : String ,
		onClick : () -> Unit
                )
{
	ElevatedCard(
			onClick = onClick ,
			modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp , vertical = 8.dp) ,
			shape = RoundedCornerShape(16.dp) ,
			elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
	            ) {
		Column(
				modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
		      ) {
			Text(
					text = title ,
					style = MaterialTheme.typography.titleMedium ,
					maxLines = 1 ,
					overflow = TextOverflow.Ellipsis
			    )
			Spacer(modifier = Modifier.height(4.dp))
			Text(
					text = contentPreview ,
					style = MaterialTheme.typography.bodyMedium ,
					//color = Color.Gray,
					maxLines = 2 ,
					overflow = TextOverflow.Ellipsis
			    )
			Spacer(modifier = Modifier.height(8.dp))
			Text(
					text = date ,
					style = MaterialTheme.typography.labelSmall ,
					color = Color.DarkGray ,
					modifier = Modifier.align(Alignment.End)
			    )
		}
	}
}

@Preview(name = "NoteCardItem")
@Composable
private fun PreviewNoteCardItem()
{
	NoteCardItem(
			title = "title" ,
			contentPreview = "This is a text file" ,
			date = "12 June 2023" ,
			onClick = {} ,
	            )
}
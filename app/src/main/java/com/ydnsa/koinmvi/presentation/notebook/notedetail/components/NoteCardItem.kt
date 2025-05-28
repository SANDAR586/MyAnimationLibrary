package com.ydnsa.koinmvi.presentation.notebook.notedetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.ydnsa.koinmvi.data.local.*
import com.ydnsa.koinmvi.util.*

@Composable
fun NoteCardItem(
    fileEntity : FileEntity ,
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
                text = fileEntity.title ,
                style = MaterialTheme.typography.titleMedium ,
                maxLines = 1 ,
                overflow = TextOverflow.Ellipsis
                )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = fileEntity.content ,
                style = MaterialTheme.typography.bodyMedium ,
                //color = Color.Gray,
                maxLines = 2 ,
                overflow = TextOverflow.Ellipsis
                )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = fileEntity.timestamp.getDate() ,
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
    val fileEntity = FileEntity(
        uid = "" ,
        folderName = "" ,
        fileLocation = "" ,
        title = "Title" ,
        content = "content description" ,
        timestamp = 213456789000000000
                               )
    NoteCardItem(fileEntity , {})
}
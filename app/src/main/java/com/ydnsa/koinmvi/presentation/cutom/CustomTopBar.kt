package com.ydnsa.koinmvi.presentation.cutom


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ydnsa.koinmvi.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
     title:String ="Default",
    containerColor: Color?
) {

        Surface(
            tonalElevation = 4.dp,
            shape = RoundedCornerShape(
                bottomEnd = 16.dp,
                bottomStart = 16.dp
            )
        ) {
            TopAppBar(
                title = {
                    Text(
                        title,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontWeight = FontWeight.Bold

                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =  containerColor ?: MaterialTheme.colorScheme.background
                ),

                )
        }


}

@Preview(name = "AppScaffold")
@Composable
private fun PreviewAppScaffold() {
    AppTheme{
        CustomTopBar(Modifier ,"title" ,null )
    }
}
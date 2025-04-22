package com.ydnsa.koinmvi.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeListView(
    modifier: Modifier = Modifier,
) {

    LazyColumn {
        items(6){item->
            Box(modifier=modifier.padding(5.dp)){
                UserCardComponent(modifier=modifier)
            }

        }
    }
}

@Preview(name = "Listview")
@Composable
private fun PreviewListview() {
    HomeListView()
}
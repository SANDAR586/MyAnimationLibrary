package com.ydnsa.koinmvi.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestGreeting(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "TestGreeting")
    }
}

@Preview(name = "TestGreeting")
@Composable
private fun PreviewTestGreeting() {
    TestGreeting()
}
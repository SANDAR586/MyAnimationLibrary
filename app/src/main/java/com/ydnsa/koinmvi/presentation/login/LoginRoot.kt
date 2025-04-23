package com.ydnsa.koinmvi.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginRoot(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "LoginRoot")
    }
}

@Preview(name = "LoginRoot")
@Composable
private fun PreviewLoginRoot() {
    LoginRoot()
}
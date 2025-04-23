package com.ydnsa.koinmvi.presentation.login.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "LoginScreen")
    }
}

@Preview(name = "LoginScreen")
@Composable
private fun PreviewLoginScreen() {
    LoginScreen()
}
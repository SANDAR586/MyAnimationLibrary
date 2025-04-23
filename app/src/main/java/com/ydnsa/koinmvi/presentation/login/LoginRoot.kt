package com.ydnsa.koinmvi.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ydnsa.koinmvi.presentation.login.composables.LoginScreen

@Composable
fun LoginRoot(
    modifier: Modifier = Modifier,
) {
    Scaffold {paddingValues ->
        LoginScreen(modifier=modifier.padding(paddingValues))

    }
}

@Preview(name = "LoginRoot")
@Composable
private fun PreviewLoginRoot() {
    LoginRoot()
}
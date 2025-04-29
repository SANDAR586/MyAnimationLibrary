package com.ydnsa.koinmvi.presentation.home

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.core.content.ContextCompat
import com.ydnsa.koinmvi.presentation.home.components.CameraComponent
import com.ydnsa.koinmvi.presentation.home.components.CameraPermissionRequest

@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {
    if (ContextCompat.checkSelfPermission(LocalContext.current, Manifest.permission.CAMERA)
        == PackageManager.PERMISSION_GRANTED) {
        Box(modifier = Modifier.fillMaxSize()) {
            CameraComponent(modifier = Modifier.fillMaxSize())
        }
    }else{

        Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
            CameraPermissionRequest()
        }
    }



}

@Composable
@Preview(name = "Home")
private fun HomeScreenPreview(
    @PreviewParameter(HomeStatePreviewParameterProvider::class)
    state: HomeState,
) {
    HomeScreen(
        state = state,
        onAction = {}
    )
}

/**
 * PreviewParameter Provider for HomeScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class HomeStatePreviewParameterProvider : PreviewParameterProvider<HomeState> {
    override val values: Sequence<HomeState>
        get() = sequenceOf(
            HomeState(),
        )
}

package com.ydnsa.koinmvi.sample.aifeatures

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
import androidx.core.content.ContextCompat

@Composable
fun CameraRootAnalysis(
    modifier: Modifier = Modifier,
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

@Preview(name = "CameraRootAnalysis")
@Composable
private fun PreviewCameraRootAnalysis() {
    CameraRootAnalysis()
}
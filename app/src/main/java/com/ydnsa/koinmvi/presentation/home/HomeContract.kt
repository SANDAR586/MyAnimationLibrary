package com.ydnsa.koinmvi.presentation.home

import androidx.compose.ui.tooling.preview.PreviewParameterProvider


/**
 * UI State that represents HomeScreen
 **/
class HomeState

/**
 * Home Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface HomeAction {
    data object OnClick : HomeAction
}


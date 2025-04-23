package com.ydnsa.koinmvi.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue



import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun HomeRoute(
    coordinator: HomeCoordinator = rememberHomeCoordinator(),
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(HomeState())

    // UI Actions
    val actionsHandler: (HomeAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    HomeScreen(
        state = uiState,
        onAction = actionsHandler
    )
}



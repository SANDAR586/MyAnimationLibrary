package com.ydnsa.koinmvi.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue



import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.ydnsa.koinmvi.presentation.home.components.HomeScreen
import com.ydnsa.koinmvi.presentation.login.rememberLoginCoordinator


@Composable
fun HomeRoute(

    navHostController: NavHostController
) {
    val coordinator = rememberHomeCoordinator()
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(HomeState())

    // UI Actions
    val actionsHandler: (HomeAction) -> Unit = { action ->
        coordinator.handle(action)
    }

    // UI Rendering
    HomeScreen(
        state = uiState,
        onAction = actionsHandler,
        navHostController
    )
}



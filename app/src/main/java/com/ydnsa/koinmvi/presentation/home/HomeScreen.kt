package com.ydnsa.koinmvi.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {

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

package com.ydnsa.koinmvi.presentation.home.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ydnsa.koinmvi.presentation.cutom.CustomTopBar
import com.ydnsa.koinmvi.presentation.home.HomeAction
import com.ydnsa.koinmvi.presentation.home.HomeState
import com.ydnsa.koinmvi.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
    navHostController: NavHostController
) {

    Scaffold(
    topBar ={
        CustomTopBar( modifier = Modifier, "Home", null)
    }

    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(padding).padding(
                horizontal = 16.dp
            ),
            columns = GridCells.Fixed(2)
        ) {
            val items=getHomeItems()
            items(items.size) { homeItem ->
                HomeElevatedCard(
                    modifier = Modifier,
                    homeItmes = items[homeItem],
                    navHostController

                )
            }
        }
    }

}




@Composable
@Preview(name = "Home", device = "id:Nexus 5")
private fun HomeScreenPreview(
    @PreviewParameter(HomeStatePreviewParameterProvider::class)
    state: HomeState,
) {
    val navHostController= rememberNavController()
    AppTheme{
        HomeScreen(
            state = state,
            onAction = {},
            navHostController
        )
    }
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

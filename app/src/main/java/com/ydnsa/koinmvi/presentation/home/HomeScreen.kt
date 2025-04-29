package com.ydnsa.koinmvi.presentation.home


import androidx.compose.foundation.Image
import com.ydnsa.koinmvi.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ydnsa.koinmvi.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {
  /*
  val systemUiController = rememberSystemUiController()
    val statusBarColor = MaterialTheme.colorScheme.secondary

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false // Set to true if your status bar color is light
        )
    }*/

    Scaffold (
        topBar = {
            Surface(
                tonalElevation = 4.dp,
                shape = RoundedCornerShape(
                    bottomEnd = 16.dp,
                    bottomStart = 16.dp
                )
            ) {
                TopAppBar(
                    title = { Text("Home",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontWeight = FontWeight.Bold

                        )
                    ) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    ),



                    )
            }
        }


    ){padding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(padding).padding(
                horizontal = 16.dp
            ),
            columns = GridCells.Fixed(2)
        ) {
            items(50){item ->

                ElevatedCard (
                    modifier = Modifier.fillMaxWidth()
                        .aspectRatio(1f).padding(5.dp)
                    ,
                    elevation = CardDefaults.cardElevation(4.dp),
                    onClick = {

                    }

                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center // Center content inside the Box
                    ) {
                        Image(
                            painter = painterResource(R.drawable.notebook),
                            contentDescription = "",
                            modifier = Modifier.size(80.dp)
                        )

                        Text(
                            text = "Note",
                            modifier = Modifier
                                .padding(top = 100.dp), // Adjust the position of the text if necessary
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontWeight = FontWeight.W500
                            )
                        )
                    }

                }

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
    AppTheme{
        HomeScreen(
            state = state,
            onAction = {}
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

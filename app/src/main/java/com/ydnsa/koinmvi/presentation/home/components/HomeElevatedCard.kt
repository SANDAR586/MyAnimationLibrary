package com.ydnsa.koinmvi.presentation.home.components

import android.R.attr.onClick
import android.service.autofill.OnClickAction
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ydnsa.koinmvi.R
import com.ydnsa.koinmvi.presentation.home.HomeAction
import com.ydnsa.koinmvi.presentation.home.HomeItems

@Composable
fun HomeElevatedCard(
    modifier: Modifier = Modifier,
    homeItmes: HomeItems,
    navHostController: NavHostController


) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth()
            .aspectRatio(1f).padding(5.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { handlNavigation(navHostController,homeItmes.action) }

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center // Center content inside the Box
        ) {
            Image(
                painter = painterResource(homeItmes.icon),
                contentDescription = "",
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = homeItmes.itemName,
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

@Preview(name = "HomeElevatedCard")
@Composable
private fun PreviewHomeElevatedCard() {
    val homeItmes= HomeItems(
        "",R.drawable.notebook, HomeAction.OnClick
    )
    val navHostController= rememberNavController()
    HomeElevatedCard(
        Modifier,homeItmes,navHostController
    )
}
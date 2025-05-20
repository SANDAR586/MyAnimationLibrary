package com.ydnsa.koinmvi.presentation.login.composables


import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.rememberAsyncImagePainter
import com.ydnsa.koinmvi.navigations.Screen
import com.ydnsa.koinmvi.presentation.login.LoginIntent
import com.ydnsa.koinmvi.presentation.login.LoginState
import com.ydnsa.koinmvi.R
import java.nio.file.WatchEvent


@Composable
fun LoginScreen(
    uiState: LoginState,
    onAction: (LoginIntent) -> Unit,
    navHostController: NavHostController

) {
    BackGroundMedia()
    Box(
       modifier =  Modifier
           .fillMaxSize()
           .background(MaterialTheme.colorScheme.background)
    ){
        Box(
            modifier = Modifier.align(Alignment.Center)
        ){
           Card( colors = CardDefaults.cardColors()) {
               LoginBox(modifier = Modifier,uiState,onAction,navHostController)
           }
            Box( modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-50).dp)
                .size(100.dp)
                .background(MaterialTheme.colorScheme.tertiary,
                    shape = CircleShape) // <-- move background here
                .clip(CircleShape)
            )
                {
                Image(painter = rememberAsyncImagePainter(R.drawable.giphy),
                    contentDescription = "Walking Duck",
                    Modifier.size(50.dp).align(Alignment.Center)
                        .background(MaterialTheme.colorScheme.tertiary)
                        .clip(CircleShape)
                )
            }

        }
    }

}

@Preview(name = "LoginScreen")
@Composable
private fun PreviewLoginScreen() {
    val navHostController= rememberNavController()
LoginScreen(uiState = LoginState(), onAction = {},navHostController)
}
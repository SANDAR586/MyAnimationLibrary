package com.ydnsa.koinmvi.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ydnsa.koinmvi.presentation.login.composables.LoginScreen
import com.ydnsa.koinmvi.sample.WalkingDucks
import com.ydnsa.koinmvi.sample.screens.CollopesImage
import org.koin.compose.koinInject


@Composable
fun LoginRoot(
    navHostController: NavHostController
) {
    val context = LocalContext.current
    val loginModelView : LoginModelView= koinInject()
    val loginCoordinator = rememberLoginCoordinator(loginModelView)

    val uiState by loginCoordinator.loginState.collectAsStateWithLifecycle()

    val loginAction:(LoginIntent) -> Unit = { loginIntent ->

        loginCoordinator.handle(loginIntent,context)
    }



    //WalkingDucks() ( test the samples here)
    LoginScreen(uiState,loginAction,navHostController)


}

@Preview(name = "LoginRoot")
@Composable
private fun PreviewLoginRoot() {
    val  navHostController: NavHostController = rememberNavController()
    LoginRoot(navHostController)
}
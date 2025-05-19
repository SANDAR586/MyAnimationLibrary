package com.ydnsa.koinmvi.presentation.login

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class LoginCoordinator(
    val loginModelView: LoginModelView
) {
    val loginState = loginModelView.loginState

    fun handle(action : LoginIntent,context: Context){
        when(action){
            is LoginIntent.Submit ->{
                loginModelView.login(context)
            }
            LoginIntent.TooglePasswordVisibility -> loginModelView.tooglePasswordIcon()
            is LoginIntent.IsPasswordChange -> { loginModelView.passwordChange(action.name)}
            is LoginIntent.IsUsernameChanged ->{ loginModelView.usenameUpdated(action.name)}
        }
    }
}

@Composable
fun rememberLoginCoordinator(
     loginModelView: LoginModelView
): LoginCoordinator{
    return remember(loginModelView) {
        LoginCoordinator(loginModelView)
    }

}
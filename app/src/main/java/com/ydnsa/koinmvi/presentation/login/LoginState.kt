package com.ydnsa.koinmvi.presentation.login

data class LoginState (
    val isLoading : Boolean = false,
    val isSuccess : Boolean =false,
    val isError : Boolean = false,
    val password :String ="password",
    val username:String="admin",
    val isPasswordVisible: Boolean = false,
    val errorMessage:String =""

)

sealed class LoginIntent{
    data object Submit : LoginIntent()
    data object TooglePasswordVisibility : LoginIntent()
    data class IsUsernameChanged(val name:String) : LoginIntent()
    data class IsPasswordChange(val name:String) : LoginIntent()

}


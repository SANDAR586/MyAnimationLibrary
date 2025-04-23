package com.ydnsa.koinmvi.presentation.login

data class LoginState (
    val isLoading : Boolean = false,
    val isSuccess : Boolean =false,
    val isError : Boolean = false,
)

sealed class LoginIntent{
    data class submit(val username: String ,val password : String) : LoginIntent()
}


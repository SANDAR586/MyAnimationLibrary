package com.ydnsa.koinmvi.presentation.login

import LoginResponse
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.ydnsa.koinmvi.domain.usecase.LoginUseCase
import com.ydnsa.koinmvi.navigations.Screen
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.log

class LoginModelView (
    private val loginUseCase: LoginUseCase,


) : ViewModel() {
    private  val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState


     fun tooglePasswordIcon(){
        _loginState.update {currentState ->
          currentState.copy(
              isPasswordVisible = !currentState.isPasswordVisible
          )
        }
    }

     fun login(context: Context){
        viewModelScope.launch{
            _loginState.update { currentState ->
                currentState.copy(

                    isLoading = true
                )

            }
            delay(3000L)
         val result : LoginResponse=  loginUseCase(_loginState.value.username,_loginState.value.password,context)
            if(result.success){
                _loginState.update { currentState ->
                    currentState.copy(
                        isSuccess = true,
                        isLoading = false,
                        isError = false,
                        errorMessage = "Login Success , Welcome ${currentState.username} "
                    )


                }
            }else{
                _loginState.update { currentState ->
                    currentState.copy(
                        isError = true,
                        isSuccess = false,
                        isLoading = false,
                        errorMessage = "Invalid User Information"
                    )

                }
            }
        }

    }

     fun usenameUpdated(name: String){
        _loginState.update { currentState->
            currentState.copy(username = name)

        }
    }
     fun passwordChange(password: String){
        _loginState.update { currentState->
            currentState.copy(password = password)

        }
    }
}
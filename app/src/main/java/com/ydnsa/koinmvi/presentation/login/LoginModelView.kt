package com.ydnsa.koinmvi.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ydnsa.koinmvi.domain.usecase.LoginUseCase
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.log

class LoginModelView (
    private val loginUseCase: LoginUseCase
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

     fun login(){
        viewModelScope.launch{
            _loginState.update { currentState ->
                currentState.copy(

                    isLoading = true
                )

            }
            delay(3000L)
         val a : Boolean=  loginUseCase(_loginState.value.username,_loginState.value.password)
            if(a){
                _loginState.update { currentState ->
                    currentState.copy(
                        isSuccess = true,
                        isLoading = false,
                        isError = false,
                        errorMessage = "Login Success"
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
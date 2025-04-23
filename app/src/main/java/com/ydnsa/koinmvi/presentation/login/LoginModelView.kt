package com.ydnsa.koinmvi.presentation.login

import androidx.lifecycle.ViewModel
import com.ydnsa.koinmvi.domain.usecase.LoginUseCase

class LoginModelView (
    private val loginUseCase: LoginUseCase
) : ViewModel() {
}
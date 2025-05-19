package com.ydnsa.koinmvi.domain.usecase

import LoginResponse
import android.content.Context
import com.ydnsa.koinmvi.data.network.repository.LoginRepository

class LoginUseCase(private val repo: LoginRepository) {
      operator fun invoke(username: String , password : String,context: Context): LoginResponse{
        return repo.login(username,password,context)
    }
}
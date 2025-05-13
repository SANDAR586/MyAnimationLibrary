package com.ydnsa.koinmvi.domain.usecase

import LoginResponse
import com.ydnsa.koinmvi.data.network.repository.LoginRepository

class LoginUseCase(private val repo: LoginRepository) {
      operator fun invoke(username: String , password : String): LoginResponse{
        return repo.login(username,password)
    }
}
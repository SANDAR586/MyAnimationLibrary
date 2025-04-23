package com.ydnsa.koinmvi.domain.usecase

import com.ydnsa.koinmvi.data.repository.LoginRepository

class LoginUseCase(private val repo: LoginRepository) {
    private  operator fun invoke(username: String , password : String): Boolean{
        return repo.login(username,password)
    }
}
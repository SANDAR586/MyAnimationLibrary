package com.ydnsa.koinmvi.data.repository

import LoginResponse
import com.ydnsa.koinmvi.data.fake.LoginApi

interface LoginRepository {

     fun login(username:String , password : String) : LoginResponse
}

class LoginRepositoryImpl(private val  api: LoginApi) : LoginRepository{

    override  fun login(username: String, password: String) : LoginResponse {
       return api.login(username,password)
        // To DO ( if test is true use fake else use real api)
    }

}
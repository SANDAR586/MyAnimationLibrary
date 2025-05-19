package com.ydnsa.koinmvi.data.network.repository

import LoginResponse
import android.content.Context
import com.ydnsa.koinmvi.data.fake.LoginApi

interface LoginRepository {

     fun login(username:String , password : String , context: Context) : LoginResponse
}

class LoginRepositoryImpl(private val  api: LoginApi) : LoginRepository{

    override  fun login(username: String, password: String , context: Context) : LoginResponse {
       return api.login(username,password,context )
        // To DO ( if test is true use fake else use real api)
    }

}
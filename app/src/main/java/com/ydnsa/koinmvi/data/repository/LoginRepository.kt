package com.ydnsa.koinmvi.data.repository

import com.ydnsa.koinmvi.data.fake.LoginApi

interface LoginRepository {
     fun login(username:String , password : String) : Boolean
}

class LoginRepositoryImpl(private val  api: LoginApi) : LoginRepository{
    override  fun login(username: String, password: String) : Boolean {
       return api.login(username,password)
    }

}
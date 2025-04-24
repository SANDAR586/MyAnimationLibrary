package com.ydnsa.koinmvi.data.fake

import LoginResponse
import android.content.Context

class LoginApi(private val context: Context) {
     fun login( username:String ,  password:String) : LoginResponse{
         if(username == "admin" && password == "password") {
             return FakeJsonReader(context).readLoginResponse()
         }else{
             var data = FakeJsonReader(context).readLoginResponse()
             data=  data.copy(success = false)
             return data;
         }
    }
}
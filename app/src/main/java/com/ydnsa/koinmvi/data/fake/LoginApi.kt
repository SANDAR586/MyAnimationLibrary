package com.ydnsa.koinmvi.data.fake

import LoginResponse
import android.content.Context

class LoginApi() {
     fun login( username:String ,  password:String ,context : Context) : LoginResponse{
         if(username == "admin" && password == "password") {
             return FakeJsonReader().readLoginResponse(context)
         }else{
             var data = FakeJsonReader().readLoginResponse(context)
             data=  data.copy(success = false)
             return data;
         }
    }
}
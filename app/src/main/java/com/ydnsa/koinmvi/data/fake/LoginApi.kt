package com.ydnsa.koinmvi.data.fake

class LoginApi {
     fun login( username:String ,  password:String) : Boolean{
         return username == "admin" && password == "password"
    }
}
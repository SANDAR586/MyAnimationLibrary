package com.ydnsa.koinmvi.data.fake

import LoginResponse
import android.content.Context
import kotlinx.serialization.json.Json

class FakeJsonReader() {
    private val josn= Json{
        ignoreUnknownKeys=true
    }

    fun readLoginResponse(context: Context):LoginResponse{
      val jsonString=   context.assets.open("LoginResponse.json").bufferedReader().use { it.readText() }
        return  josn.decodeFromString(jsonString)
    }
}
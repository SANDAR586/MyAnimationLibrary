package com.ydnsa.koinmvi.di


import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val gsonModule= module{
    single{
        GsonBuilder().create()
    }
    single{
        Retrofit.Builder()
            .baseUrl("https://67e660886530dbd3110fba9b.mockapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
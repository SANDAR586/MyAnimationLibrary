package com.ydnsa.koinmvi.di

import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val moshiModule= module{
    single{
        Moshi.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://67e660886530dbd3110fba9b.mockapi.io/api/v1/")
            .addConverterFactory(
                MoshiConverterFactory.create(get())
            ).build()
    }
}
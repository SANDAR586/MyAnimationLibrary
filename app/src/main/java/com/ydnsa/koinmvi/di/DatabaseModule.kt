package com.ydnsa.koinmvi.di

import androidx.room.*
import com.ydnsa.koinmvi.data.local.*
import org.koin.dsl.*

val databaseModule = module {

    single {
        Room.databaseBuilder(
                get() ,
                AppDatabase::class.java , "my db"
                            ).build()
    }

    single {
        get<AppDatabase>().userDao()
    }
    single { get<AppDatabase>().fileDao() }
}
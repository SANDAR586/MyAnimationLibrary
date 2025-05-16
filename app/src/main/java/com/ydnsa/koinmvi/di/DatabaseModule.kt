package com.ydnsa.koinmvi.di
import android.app.Application
import androidx.room.Room
import com.ydnsa.koinmvi.data.local.AppDatabase
import org.koin.dsl.module


val databaseModule= module{

    single {
     val db=   Room.databaseBuilder(
            get<Application>(),
            AppDatabase::class.java , "mydb"
        ).build()
    }

    single{
        get<AppDatabase>().userDao()
    }
}
package com.ydnsa.koinmvi

import android.app.Application
import com.ydnsa.koinmvi.MainActivity
import com.ydnsa.koinmvi.di.appModule
import com.ydnsa.koinmvi.di.databaseModule
import com.ydnsa.koinmvi.di.gsonModule
import com.ydnsa.koinmvi.di.moshiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val applicationModules=listOf(
            appModule, moshiModule, gsonModule, databaseModule
        )
        startKoin {
            androidContext(this@MyApp)
            modules(applicationModules)
        }
    }
}
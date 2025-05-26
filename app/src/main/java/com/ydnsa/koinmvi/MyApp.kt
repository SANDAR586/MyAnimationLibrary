package com.ydnsa.koinmvi

import android.app.*
import com.ydnsa.koinmvi.di.*
import org.koin.android.ext.koin.*
import org.koin.core.context.*
import org.koin.core.logger.*

class MyApp : Application()
{

    override fun onCreate()
    {
        super.onCreate()
        val applicationModules = listOf(
                moshiModule , gsonModule , databaseModule , appModule ,
                                       )
        startKoin {
            androidLogger(Level.ERROR) // Or Level.DEBUG
            androidContext(this@MyApp)
            modules(applicationModules)
        }
    }
}
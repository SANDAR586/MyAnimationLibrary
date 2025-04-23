package com.ydnsa.koinmvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ydnsa.koinmvi.di.appModule
import com.ydnsa.koinmvi.presentation.login.LoginRoot
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            startKoin {
                modules(appModule)
            }
        }


    }

}
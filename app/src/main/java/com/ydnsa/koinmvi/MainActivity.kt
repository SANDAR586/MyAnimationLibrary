package com.ydnsa.koinmvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ydnsa.koinmvi.di.appModule
import com.ydnsa.koinmvi.di.databaseModule
import com.ydnsa.koinmvi.di.gsonModule
import com.ydnsa.koinmvi.di.moshiModule
import com.ydnsa.koinmvi.navigations.AppNavGraph
import com.ydnsa.koinmvi.presentation.login.LoginRoot
import com.ydnsa.koinmvi.ui.theme.AppTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppTheme{
                val navHostController: NavHostController= rememberNavController()
                AppNavGraph(navHostController)
            }
        }
    }

}



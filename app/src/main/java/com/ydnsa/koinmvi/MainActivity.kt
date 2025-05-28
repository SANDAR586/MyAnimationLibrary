package com.ydnsa.koinmvi

import android.content.*
import android.os.*
import android.provider.*
import androidx.activity.*
import androidx.activity.compose.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.*
import androidx.compose.ui.*
import androidx.navigation.*
import androidx.navigation.compose.*
import androidx.navigation3.runtime.*
import androidx.navigation3.ui.*
import com.ydnsa.koinmvi.navigations.*
import com.ydnsa.koinmvi.ui.theme.*

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R)
        {
            if (! Environment.isExternalStorageManager())
            {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }

        setContent {

            AppTheme {
                //NavExample()
                val navHostController : NavHostController = rememberNavController()
                AppNavGraph(navHostController)

            }
        }
    }

}

data object Home
data class Product(val id : String)

@Composable
fun NavExample()
{

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack ,
        onBack = { backStack.removeLastOrNull() } ,
        entryProvider = { key ->
            when (key)
            {
                is Home -> NavEntry(key) {
                    ContentGreen(modifier = Modifier , "Welcome to Nav3" , backStack)
                }

                is Product -> NavEntry(key) {
                    ContentBlue(modifier = Modifier , "Product ${key.id} ") {
                        Text("Click to navigate")
                    }
                }

                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
              )
}

@Composable
fun ContentGreen(modifier : Modifier , x0 : String , backStack : SnapshotStateList<Any>)
{
    Box(
        Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.onPrimary
                       )
       ) {
        Button(
            modifier = Modifier.align(
                Alignment.Center
                                     ) , onClick = {
                backStack.add(Product("123"))
            }) {
            Text(
                "Click to navigate" ,

                )
        }
    }
}

@Composable
fun ContentBlue(modifier : Modifier , x0 : String , content : @Composable () -> Unit)
{
    Box(
        Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary
                       )
       ) {
        content
    }
}



package com.ydnsa.koinmvi.presentation.home.components


import androidx.navigation.NavHostController
import com.ydnsa.koinmvi.R
import com.ydnsa.koinmvi.navigations.Screen
import com.ydnsa.koinmvi.presentation.home.HomeItems


fun getHomeItems(navHostController: NavHostController): List<HomeItems> {
    return listOf(
        HomeItems(
            itemName = "Note Book",
            icon = R.drawable.notebook,
            onClick = {
                navHostController.navigate(Screen.Login.route)
            }
        ),
        HomeItems(
            itemName = "Tasks",
            icon = R.drawable.notebook,
            onClick = {
                navHostController.navigate(Screen.Login.route)
            }
        ),
        HomeItems(
            itemName = "Profile",
            icon = R.drawable.notebook,
            onClick = {
                navHostController.navigate(Screen.Login.route)
            }
        )
    )
}


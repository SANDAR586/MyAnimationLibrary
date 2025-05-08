package com.ydnsa.koinmvi.presentation.home.components


import androidx.navigation.NavHostController
import com.ydnsa.koinmvi.R
import com.ydnsa.koinmvi.navigations.Screen
import com.ydnsa.koinmvi.presentation.home.HomeAction
import com.ydnsa.koinmvi.presentation.home.HomeItems


fun getHomeItems(): List<HomeItems> {
    return listOf(
        HomeItems(
            itemName = "Note Book",
            icon = R.drawable.notebook,
            action = HomeAction.NavigateToNote
        ),
        HomeItems(
            itemName = "Tasks",
            icon = R.drawable.notebook,
            action = HomeAction.NavigateToNote

        ),
        HomeItems(
            itemName = "Profile",
            icon = R.drawable.notebook,
            action = HomeAction.NavigateToNote
        )
    )
}

fun handlNavigation(navHostController: NavHostController,action: HomeAction){
    when(action) {
        HomeAction.NavigateToNote -> {navHostController.navigate(Screen.NotesItemList.route)}
        HomeAction.OnClick -> {}
    }

}


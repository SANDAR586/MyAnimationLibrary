package com.ydnsa.koinmvi.presentation.home

import androidx.annotation.DrawableRes
import androidx.navigation.NavHostController
import com.ydnsa.koinmvi.R
import com.ydnsa.koinmvi.navigations.Screen

/**
 * UI State that represents HomeScreen
 **/
class HomeState

/**
 * Home Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/

sealed interface HomeAction {
    data object OnClick : HomeAction
    data object NavigateToNote: HomeAction
}

data class HomeItems(
    val itemName: String,
    @DrawableRes val icon: Int,
    val action: HomeAction
)





package com.ydnsa.koinmvi

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ydnsa.koinmvi.sample.TestGreeting
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.jetbrains.annotations.TestOnly
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class TestGreetingTest {

    @get:Rule
    val composeTestRule= createComposeRule()

    @Test
    fun greeting_is_Displayed(){
        composeTestRule.setContent {
            TestGreeting()
        }
    }
}
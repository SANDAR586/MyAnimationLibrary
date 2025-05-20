package com.ydnsa.koinmvi.presentation.login.composables

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.ydnsa.koinmvi.R

@Composable
fun BackGroundMedia(
    modifier: Modifier = Modifier,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
) {
    val context=LocalContext.current
    val loginMedia = remember {
        MediaPlayer.create(context, R.raw.bg2).apply { isLooping=true }
    }
    // If `lifecycleOwner` changes, dispose and reset the effect
    DisposableEffect(Unit) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> loginMedia.start()
                Lifecycle.Event.ON_STOP -> loginMedia.pause()
                Lifecycle.Event.ON_DESTROY -> loginMedia.release()
                else -> Unit
            }
        }
        val lifecycle = lifecycleOwner.lifecycle
        lifecycle.addObserver(observer)

        // THIS lambda is returned and used as DisposableEffectResult:
        onDispose {
            lifecycle.removeObserver(observer)
            loginMedia.release()
        }
    }



}


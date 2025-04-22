package com.ydnsa.koinmvi.screens

import android.R.attr.label
import android.R.attr.shape
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollopesImage(
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    var targetHeight by remember { mutableStateOf(200.dp) }
    var profileAlig by remember { mutableStateOf(Alignment.Center) }
    var offsett by remember { mutableStateOf(0) }
    var targetSize by remember { mutableStateOf(100.dp) }





    // Animate the header height change
    val animatedHeight by animateDpAsState(
        targetValue = targetHeight,
        animationSpec = tween(durationMillis = 300),
        label = "HeaderHeightAnimation"
    )

   val animatesixe by animateDpAsState(
        targetValue = targetSize,
        animationSpec = tween(durationMillis = 500),
        label = "sixe"
    )

    val animatedAlignment = animateAlignmentAsState(
        if (offsett>0) BiasAlignment(-1f, -1f) else BiasAlignment(0f, 0f)

    )

    // Observe scroll offset
    LaunchedEffect(Unit) {
        snapshotFlow { listState.firstVisibleItemScrollOffset }
            .collect { offset ->
                offsett=offset
                targetHeight = if (offset > 0) 100.dp else 200.dp
                targetSize  =   if(offset>0) 80.dp else 110.dp

            }
    }


   LazyColumn(state = listState,
       modifier = modifier.fillMaxSize()) {

       stickyHeader {
           Box(modifier=modifier.height(animatedHeight)
               .fillMaxWidth()
               .background(Color.Yellow)
           ) {

               Box(modifier=modifier.size(targetSize).padding(10.dp).clip(shape = RoundedCornerShape(100.dp))
                   .align(alignment = animatedAlignment)
                   .background(Color.White)
               ) {  }

           }
       }

       items(40){item ->
           Box(modifier=modifier.fillMaxWidth().defaultMinSize(100.dp).padding(20.dp)
               .background(Color.LightGray)
           ) {
                Text(item.toString())
           }


       }
   }
}

@Composable
fun animateAlignmentAsState(
    targetAlignment: Alignment,
):Alignment {
    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(biased.horizontalBias,
        animationSpec = tween(durationMillis = 1000),
        )
    val vertical by animateFloatAsState(biased.verticalBias,
        animationSpec = tween(durationMillis = 1000),
        )
    return  BiasAlignment(horizontal, vertical)
}

@Preview(name = "CollopesImage")
@Composable
private fun PreviewCollopesImage() {
    CollopesImage()
}



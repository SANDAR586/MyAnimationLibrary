package com.ydnsa.koinmvi.sample

import android.R.attr.x
import android.R.attr.y
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.ydnsa.koinmvi.R

@Composable
fun WalkingDucks(
    modifier: Modifier = Modifier,
) {
    var imagePos by remember { mutableStateOf( Offset(x=15f, y = 15f)) }
    var offset by remember { mutableStateOf(Offset(100f, 100f)) }
    var isDragging by remember { mutableStateOf(false) }

   val animateDuck by animateOffsetAsState(
       targetValue = imagePos,
               animationSpec = tween(durationMillis = 10000),
   )





    Box(modifier= Modifier.fillMaxSize()
        .pointerInput(Unit){
            detectTapGestures{

            }
        }

        ) {
        animateDuck.let {pos ->
            Image(
                painter= rememberAsyncImagePainter(
                    R.drawable.giphy
                ), contentDescription = "",
                modifier= Modifier
                    .offset{
                        IntOffset(x = pos.x.toInt(), y = pos.y.toInt())
                    }.size(50.dp)

            )
            Image(
                painter= rememberAsyncImagePainter(
                    R.drawable.tree
                ), contentDescription = "",
                modifier= Modifier.
                size(100.dp).offset(y = (  100).dp,
                    x = (100).dp
                )

            )


                Image(
                    painter= rememberAsyncImagePainter(
                        R.drawable.tree
                    ), contentDescription = "",
                    modifier= Modifier
                        .offset{ IntOffset(x=offset.x.toInt(),y=offset.y.toInt())}
                        .size(100.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onLongPress = { offset ->
                                    isDragging = true // Start dragging on long press
                                }
                            )

                            detectDragGestures { _, dragAmount ->
                                if (isDragging) {
                                    // Update the position of the item as it is dragged
                                    offset = Offset(offset.x + dragAmount.x, offset.y + dragAmount.y)
                                }
                            }
                        }

                )



        }




    }
}

@Preview(name = "WalkingDucks")
@Composable
private fun PreviewWalkingDucks() {
    WalkingDucks()
}
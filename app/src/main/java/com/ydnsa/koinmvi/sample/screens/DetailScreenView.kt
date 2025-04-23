package com.ydnsa.koinmvi.sample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@Composable
fun DetailedScreenView(
modifier: Modifier = Modifier
) {
    val screenheight= LocalConfiguration.current.screenHeightDp.dp
    val xflow= flow {
        var x=0.dp
        while (true){
            emit(x)
            delay(10L)
            x +=3.dp
            if(x>screenheight){
                x=0.dp
            }
        }
    }
    val widthflow=flow{
        var increasing = true;
        var wee=10.dp
        while (true){
            emit(wee)
            delay(10L)
            if(wee==300.dp){
                increasing=false


            }
            if(wee==10.dp){
                increasing=true
            }

            if(increasing){
                wee +=5.dp

            }else{
                wee -=5.dp
            }
        }

    }


    var xpos = remember { mutableStateOf(100.dp) }
    var ypos = remember { mutableStateOf(0.dp) }
    var widthofitem= remember { mutableStateOf(10.dp) }
    LaunchedEffect(Unit) {
        launch {
            xflow.collect{value ->
                ypos.value=value
            }
        }

      launch {
          widthflow.collect{valti->
              widthofitem.value=valti
          }
      }

    }



   Box(modifier=modifier.fillMaxSize()){
       Box(
           Modifier
               .width(widthofitem.value)
               .height(50.dp)
               .offset(x = xpos.value, y = ypos.value)
               .clip(shape = RoundedCornerShape(100.dp) )
               .background(Color.Magenta)
               .clickable {
//                   xpos.value+=3.dp
//                   ypos.value+=10.dp
               }// Moves the box 20dp right and 30dp down
       )
   }
}

@Preview(name = "Detailed Screen View")
@Composable
private fun PreviewDetailedScreenView() {
    DetailedScreenView()
}
package com.ydnsa.koinmvi.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ydnsa.koinmvi.R

@Composable
fun UserCardComponent(
    modifier: Modifier = Modifier,
) {
   ElevatedCard() {
     Column(modifier=modifier.padding(16.dp)) {
         Row (
             modifier = modifier.padding(16.dp)
         ){
             Text(" Dr. Ayesha Khan")
             Spacer(modifier=modifier.weight(1f))
             Icon( Icons.Default.FavoriteBorder,
                 contentDescription = "Favourate",
                 modifier=modifier.clickable {
                     Log.i("koin","clicked")
                 }
             )
         }
         Row {
             Image(
                 painter = painterResource(
                     R.drawable.psychology
                 ), contentDescription = "dicuss",
                 modifier=modifier.clip(
                     shape = RoundedCornerShape(4.dp)
                 ).size(100.dp)
             )

             Spacer(modifier=modifier.size(20.dp))

             Column(modifier=modifier.defaultMinSize(120.dp)) {
                 Text("Doctor Information",
                     modifier = modifier.fillMaxWidth(),
                     textAlign = TextAlign.Center,
                     style  = TextStyle(
                         fontWeight = FontWeight.SemiBold
                     )
                 )
                 Spacer(modifier=modifier.size(4.dp))
                 Text(
                     """
                           🏫 from University of Oxford
                           📞 92 300 1234567
                            👥 12+ years 
                       """.trimIndent(),
                     modifier = modifier,
                     maxLines = 5,
                     style = TextStyle(
                         lineHeight = 25.sp
                     )
                 )



             }


         }
     }
   }
}


@Preview(name = "UserCardComponent", device = "id:Nexus 5")
@Composable
private fun PreviewUserCardComponent() {
    UserCardComponent()
}
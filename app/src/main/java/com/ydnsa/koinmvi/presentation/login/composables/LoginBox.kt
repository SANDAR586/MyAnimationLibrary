package com.ydnsa.koinmvi.presentation.login.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ydnsa.koinmvi.navigations.Screen
import com.ydnsa.koinmvi.presentation.login.LoginIntent
import com.ydnsa.koinmvi.presentation.login.LoginState


@Composable
fun LoginBox(
    modifier: Modifier = Modifier,
    uiState: LoginState,
    onAction: (LoginIntent) -> Unit,
    navHostController: NavHostController
) {
    val messageStyle = TextStyle(fontWeight = FontWeight.Bold)
    Column(
        modifier= modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {



        Spacer(Modifier.size(100.dp))


        TextField(
            value =uiState.username,
            onValueChange = {
                onAction(LoginIntent.IsUsernameChanged(it))

            }
        )
        Spacer(modifier= Modifier.size(20.dp))



        TextField(
            value = uiState.password,
            onValueChange = {
                onAction(LoginIntent.IsPasswordChange(it))
            },
            label = { Text("Password") },
            visualTransformation = if(uiState.isPasswordVisible) VisualTransformation.None else  PasswordVisualTransformation(),

            trailingIcon = {
                Icon(
                    imageVector = if (uiState.isPasswordVisible) Icons.Default.Close else  Icons.Default.Close ,
                    contentDescription = "Done Icon",
                    modifier= Modifier.clickable{
                        onAction(LoginIntent.TooglePasswordVisibility)
                    }
                )
            }

        )
        Spacer(modifier= Modifier.size(20.dp))

        ElevatedButton(
            onClick = {
                onAction(LoginIntent.Submit)
                navHostController.navigate(Screen.Home.route){
                    popUpTo(Screen.Login.route) {
                        inclusive = false
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor =  MaterialTheme.colorScheme.onTertiary
            )

        ) {
            Text("Login",
                modifier= Modifier.fillMaxWidth(fraction = 0.2f),
                textAlign = TextAlign.Center

            )
        }
        Spacer(modifier= Modifier.size(20.dp))

        when {
            uiState.isLoading -> {
                CircularProgressIndicator()
            }
            uiState.isError -> {
                Text(
                    text = uiState.errorMessage,
                    style = messageStyle.copy(color = Color.Red)
                )
            }
            uiState.isSuccess -> {
                Text(
                    text = uiState.errorMessage,
                    style = messageStyle.copy(color = Color.Green)
                )
            }
        }


    }
}

@Preview(name = "LoginBox")
@Composable
private fun PreviewLoginBox() {
   // LoginBox()
}
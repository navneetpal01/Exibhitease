package com.app.exibhitease.presentation.onboarding_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.exibhitease.presentation.settings_screen.SettingsEvent
import com.app.exibhitease.ui.theme.poppins_semiBold
import com.app.exibhitease.ui.theme.shapphire_blue

@Composable
fun OnBoardingScreen(
    onCompleted : (SettingsEvent) -> Unit
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
           OnBoardingBottom()
        },
        containerColor = Color.White,
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            Text(
                text = "OnBoardingScreen",
                fontSize = 30.sp,
                color = Color.Black
            )
        }

    }

}

@Composable
fun OnBoardingBottom(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(vertical = 10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = shapphire_blue),
                elevation = null,
                border = null,

            ) {
                Text(
                    text = "Sound exciting \uD83D\uDC4D",
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = poppins_semiBold,
                )
            }
        }
    }
}
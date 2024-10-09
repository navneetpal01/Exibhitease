package com.app.exibhitease.presentation.onboarding_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.app.exibhitease.presentation.settings_screen.SettingsEvent

@Composable
fun OnBoardingScreen(
    onCompleted : (SettingsEvent) -> Unit
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            Button(
                onClick = {
                    onCompleted(SettingsEvent.SetFirstLaunch)
                }
            ) {
                Text(text = "Start")
            }
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
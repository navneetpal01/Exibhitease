package com.app.exibhitease.presentation.onboarding_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.exibhitease.R
import com.app.exibhitease.presentation.settings_screen.SettingsEvent
import com.app.exibhitease.ui.theme.poppins_Bold
import com.app.exibhitease.ui.theme.poppins_semiBold
import com.app.exibhitease.ui.theme.shapphire_blue
import com.app.exibhitease.ui.theme.system_black

@Composable
fun OnBoardingScreen(
    onCompleted : (SettingsEvent) -> Unit
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            OnBoardingHeader()
        },
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
        }

    }

}

@Composable
fun OnBoardingHeader(){
    val blurRadius = 20.dp // Adjust the blur radius as needed

    Box(
        modifier = Modifier
            .fillMaxSize()
            .drawWithContent {
                // Draw the image content first
                drawContent()

                // Apply blur effect with a gradient at the top and bottom
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.8f), // Start with semi-transparent white
                            Color.Transparent, // No blur in the middle
                            Color.Transparent, // No blur in the middle
                            Color.White.copy(alpha = 0.8f) // End with semi-transparent white
                        ),
                        startY = 0f,
                        endY = size.height
                    ),
                    size = this.size
                )
            }
            .blur(blurRadius) // Apply blur to the entire layout
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Image with blurred edges",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
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
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = system_black,
                            fontSize = 28.sp,
                            fontFamily = poppins_Bold
                        )
                    ){
                        append("Start selling your")
                    }
                    append("\n")
                    withStyle(
                        style = SpanStyle(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFFFA00FF),
                                    Color(0xFF5505FF),
                                    Color(0xFF05C3FF),
                                    Color(0xFFFF05C8)
                                )
                            ),
                            fontSize = 28.sp,
                            fontFamily = poppins_Bold
                        )
                    ){
                        append("artwork")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = system_black,
                            fontSize = 28.sp,
                            fontFamily = poppins_Bold
                        )
                    ){
                        append("today")
                    }
                },
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 30.dp, start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Topa is an open marketplace for artist to sell their art product, for free \uD83D\uDE1A",
                fontSize = 15.sp,
                color = androidx.compose.ui.graphics.Color(0xFF4E4B66),
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth(0.85f),
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
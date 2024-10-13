package com.app.exibhitease.presentation.onboarding_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.exibhitease.R
import com.app.exibhitease.common.compose.UiButton
import com.app.exibhitease.presentation.onboarding_screen.components.AppBottomSheet
import com.app.exibhitease.presentation.settings_screen.SettingsEvent
import com.app.exibhitease.ui.theme.poppins_Bold
import com.app.exibhitease.ui.theme.system_black
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(
    onCompleted: (SettingsEvent) -> Unit
) {

    val scope = rememberCoroutineScope()
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(skipPartiallyExpanded = true, density = Density(density = 1f))
    )
    val isDimVisible by remember {
        derivedStateOf {
            sheetState.bottomSheetState.targetValue == SheetValue.Expanded
        }
    }

    AppBottomSheet(
        state = sheetState,
        onClick = {
            onCompleted(SettingsEvent.SetFirstLaunch)
        }
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            bottomBar = {
                OnBoardingBottom(
                    onClick = {
                        scope.launch {
                            sheetState.bottomSheetState.show()
                        }
                    }
                )
            },
            containerColor = Color.White,
            contentWindowInsets = WindowInsets(top = 0.dp)
        ) { paddingValues ->
            OnBoardingHeader(
                modifier = Modifier
                    .padding(paddingValues)
            )
            if (isDimVisible) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = BottomSheetDefaults.ScrimColor)
                )
            }
        }

    }
}

@Composable
fun OnBoardingHeader(
    modifier: Modifier = Modifier,
) {
    val blurRadius = 20.dp // Adjust the blur radius as needed


    Box(
        modifier = modifier
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
                            Color.White.copy(alpha = 1f) // End with semi-transparent white
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
            painter = painterResource(id = R.drawable.ar),
            contentDescription = "Image with blurred edges",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun OnBoardingBottom(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = system_black,
                            fontSize = 28.sp,
                            fontFamily = poppins_Bold,
                        )
                    ) {
                        append("Start viewing your")
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
                    ) {
                        append("images")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = system_black,
                            fontSize = 28.sp,
                            fontFamily = poppins_Bold
                        )
                    ) {
                        append("in AR!")
                    }
                },
                textAlign = TextAlign.Center,
                lineHeight = 32.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 30.dp, start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Exibhitease is an immersive AR app where you can create ar, totally free! \uD83C\uDFA8✨",
                fontSize = 15.sp,
                color = androidx.compose.ui.graphics.Color(0xFF4E4B66),
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            UiButton(
                onClick = onClick,
                text = "Sound exciting \uD83D\uDC4D"
            )
        }
    }
}
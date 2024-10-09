package com.app.exibhitease

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.app.exibhitease.ui.theme.ExibhiteaseTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        setContent {
            ExibhiteaseTheme {

            }
        }
    }


}

/**
 * Blur image Example
 * @Composable
 * fun
 *  BlurredImage() {
 *     val imagePainter = rememberImagePainter("https://example.com/your_image.jpg")
 *     val imageModifier = Modifier
 *         .fillMaxSize()
 *         .graphicsLayer {
 *             shader = Brush.verticalGradient(
 *                 colors = listOf(
 *                     Color.Transparent,
 *                     Color.Transparent,
 *                     Color.Black,
 *                     Color.Black,
 *                     Color.Transparent,
 *                     Color.Transparent
 *                 ),
 *                 stops = listOf(0f, 0.2f, 0.3f, 0.7f, 0.8f, 1f)
 *             )
 *             blurEffect = BlurEffect(radius = 10.dp)
 *         }
 *
 *     Column {
 *         Image(
 *             painter = imagePainter,
 *             contentDescription = "Blurred image",
 *             modifier = imageModifier,
 *             contentScale = ContentScale.Crop
 *         )
 *     }
 * }
 */


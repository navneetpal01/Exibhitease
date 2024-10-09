package com.app.exibhitease

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.exibhitease.core.SettingsConstants.FIRST_LAUNCH
import com.app.exibhitease.data.settings.SettingsDataStore
import com.app.exibhitease.presentation.ExibhiteaseApp
import com.app.exibhitease.presentation.settings_screen.SettingsViewModel
import com.app.exibhitease.ui.theme.ExibhiteaseTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels()

    @Inject
    lateinit var settingsDataStore: SettingsDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { settingsViewModel.setKeepOnScreenCondition }

        setContent {
            val firstLaunch = runBlocking { settingsDataStore.getBoolean(FIRST_LAUNCH) ?: true }
            val settingsState = settingsViewModel.state.collectAsStateWithLifecycle()
            ExibhiteaseTheme {
                ExibhiteaseApp(
                    firstLaunch = firstLaunch,
                    settingsViewModel = settingsViewModel,
                    finishActivity = {
                        finish()
                    }
                )
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


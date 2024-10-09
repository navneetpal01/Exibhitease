package com.app.exibhitease.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.exibhitease.presentation.settings_screen.SettingsViewModel

@Composable
fun NavGraph(
    modifier : Modifier = Modifier,
    navController : NavHostController = rememberNavController(),
    startDestination : Any,
    finishActivity: () -> Unit,
    settingsViewModel: SettingsViewModel
){



}

private fun NavBackStackEntry.lifecycleIsResumed() = this.lifecycle.currentState == Lifecycle.State.RESUMED
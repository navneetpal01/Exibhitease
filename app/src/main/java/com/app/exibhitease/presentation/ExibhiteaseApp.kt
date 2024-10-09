package com.app.exibhitease.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.app.exibhitease.presentation.navigation.NavGraph
import com.app.exibhitease.presentation.settings_screen.SettingsViewModel

@Composable
fun ExibhiteaseApp(
    firstLaunch : Boolean,
    settingsViewModel : SettingsViewModel
){

    val navController = rememberNavController()



}
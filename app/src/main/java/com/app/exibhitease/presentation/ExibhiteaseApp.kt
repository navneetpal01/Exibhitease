package com.app.exibhitease.presentation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.exibhitease.presentation.home_Screen.components.AppBottomBar
import com.app.exibhitease.presentation.navigation.ExibhiteaseTabs
import com.app.exibhitease.presentation.navigation.NavGraph
import com.app.exibhitease.presentation.navigation.Route
import com.app.exibhitease.presentation.settings_screen.SettingsViewModel
import com.app.exibhitease.ui.theme.system_white

@Composable
fun ExibhiteaseApp(
    firstLaunch: Boolean,
    settingsViewModel: SettingsViewModel,
    finishActivity: () -> Unit
) {
    val navController = rememberNavController()
    val tabs = remember {
        ExibhiteaseTabs.values()
    }
    val backStackState = navController.currentBackStackEntryAsState().value

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == ExibhiteaseTabs.Home.route ||
                backStackState?.destination?.route == ExibhiteaseTabs.Favourites.route
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color(0xFFf6f6f6),
        bottomBar = {
            if (isBottomBarVisible){
                AppBottomBar(navController = navController, tabs = tabs)
            }
        },
        contentWindowInsets = WindowInsets(top = 0.dp)
    ) { paddingValues ->
        NavGraph(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .navigationBarsPadding(),
            navController = navController,
            startDestination = if (firstLaunch) Route.OnBoardingScreen.route else Route.HomeScreen.route,
            finishActivity = finishActivity,
            settingsViewModel = settingsViewModel
        )

    }


}
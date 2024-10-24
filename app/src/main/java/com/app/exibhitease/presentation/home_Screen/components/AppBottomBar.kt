package com.app.exibhitease.presentation.home_Screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.exibhitease.presentation.navigation.ExibhiteaseTabs
import com.app.exibhitease.ui.theme.shapphire_blue
import com.app.exibhitease.ui.theme.system_black

@Composable
fun AppBottomBar(navController: NavHostController, tabs: Array<ExibhiteaseTabs>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ExibhiteaseTabs.Home.route
    val routes = remember { ExibhiteaseTabs.values().map { it.route } }

    if (currentRoute in routes) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFEFEFE)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tabs.forEach { tab ->

                IconButton(
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(id = if (currentRoute == tab.route) tab.icon_filled else tab.icon_outlined),
                        contentDescription = "null",
                        tint = if (currentRoute == tab.route) shapphire_blue else system_black,
                        modifier = Modifier
                            .size(30.dp)
                    )

                }

            }
        }

    }
}



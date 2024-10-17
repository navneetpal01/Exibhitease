package com.app.exibhitease.presentation.home_Screen.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.exibhitease.presentation.navigation.ExibhiteaseRoute
import com.app.exibhitease.presentation.navigation.ExibhiteaseTabs
import com.app.exibhitease.ui.theme.poppins_regular
import com.app.exibhitease.ui.theme.system_black

@Composable
fun AppBottomBar(navController: NavHostController, tabs: Array<ExibhiteaseTabs>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =  navBackStackEntry?.destination?.route ?: ExibhiteaseRoute.Home
    val route = remember { ExibhiteaseTabs.values().map { it.route } }


    if (currentRoute in route) {
        Row(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tabs.forEach { tab ->
                Column(
                    modifier = Modifier
                        .clickable {
                            if (tab.route != currentRoute) {
                                navController.navigate(tab.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        painter = painterResource(id = if (currentRoute == tab.route) tab.icon_filled else tab.icon_outlined),
                        contentDescription = null,
                        tint = system_black,
                        modifier = Modifier
                            .size(30.dp)
                    )

                    Text(
                        text = stringResource(id = tab.title),
                        fontFamily = poppins_regular,
                        fontSize = 12.sp,
                        color = system_black
                    )

                }
            }


        }
    }


}
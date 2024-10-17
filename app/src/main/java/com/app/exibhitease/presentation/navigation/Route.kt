package com.app.exibhitease.presentation.navigation


sealed class Route(
    val route : String
){
    object OnBoardingScreen : Route(route = "OnBoardingScreen")
    object HomeScreen : Route(route = "HomeScreen")

}


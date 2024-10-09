package com.app.exibhitease.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object OnBoarding


@Serializable
object Home

@Serializable
object Settings


sealed class ExibhiteaseRoute{
    @Serializable
    object Home : ExibhiteaseRoute()

    @Serializable
    object Search : ExibhiteaseRoute()

    @Serializable
    object Settings : ExibhiteaseRoute()
}



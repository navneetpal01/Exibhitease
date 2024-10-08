package com.app.exibhitease.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object OnBoarding


@Serializable
object Home

@Serializable
object Settings


@Serializable
sealed class ExibhiteaseRoute{
    @Serializable
    object Home : ExibhiteaseRoute()

    @Serializable
    object Search : ExibhiteaseRoute()

    @Serializable
    object Settings : ExibhiteaseRoute()
}


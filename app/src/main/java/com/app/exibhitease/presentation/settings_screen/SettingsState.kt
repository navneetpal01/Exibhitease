package com.app.exibhitease.presentation.settings_screen




data class SettingsState(
    val firstLaunch : Boolean = false,
    val darkMode : Boolean? = null,
    val amoledTheme : Boolean = false,
    val dynamicTheming : Boolean = false
)
package com.app.exibhitease.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.exibhitease.R


enum class ExibhiteaseTabs(
    @StringRes val title: Int,
    @DrawableRes val icon_outlined: Int,
    @DrawableRes val icon_filled: Int,
    val route: String
) {
    Home(R.string.screen_home, R.drawable.home_outlined, R.drawable.home_filled, ExibhiteaseDestinations.HOME_ROUTE),
    Search(R.string.screen_search, R.drawable.search_outlined, R.drawable.search_filled, ExibhiteaseDestinations.SEARCH_ROUTE),
    Settings(R.string.screen_settings, R.drawable.setting_outlined, R.drawable.setting_filled, ExibhiteaseDestinations.SETTINGS_ROUTE)
}


private object ExibhiteaseDestinations {
    const val HOME_ROUTE = "exibhitease/home"
    const val SEARCH_ROUTE = "exibhitease/search"
    const val SETTINGS_ROUTE = "exibhitease/settings"
}
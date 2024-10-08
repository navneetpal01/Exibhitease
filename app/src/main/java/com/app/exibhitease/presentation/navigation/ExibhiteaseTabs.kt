package com.app.exibhitease.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.exibhitease.R

enum class ExibhiteaseTabs(
    @StringRes val title: Int,
    @DrawableRes val icon_outlined: Int,
    @DrawableRes val icon_filled: Int,
    val route: ExibhiteaseRoute
) {
    Home(R.string.screen_home,R.drawable.home_outlined,R.drawable.home_filled,ExibhiteaseRoute.Home),
    Search(R.string.screen_search,R.drawable.search_outlined,R.drawable.search_filled,ExibhiteaseRoute.Search),
    Settings(R.string.screen_settings,R.drawable.setting_outlined,R.drawable.setting_filled,ExibhiteaseRoute.Settings)
}
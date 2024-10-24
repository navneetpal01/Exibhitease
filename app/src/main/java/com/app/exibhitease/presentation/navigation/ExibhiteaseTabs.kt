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
    Favourites(R.string.screen_search, R.drawable.heart_outlined, R.drawable.heart_filled, ExibhiteaseDestinations.SEARCH_ROUTE),
}


private object ExibhiteaseDestinations {
    const val HOME_ROUTE = "exibhitease/home"
    const val SEARCH_ROUTE = "exibhitease/favourites"
}
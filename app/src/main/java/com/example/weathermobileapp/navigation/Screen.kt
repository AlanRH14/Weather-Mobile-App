package com.example.weathermobileapp.navigation

import com.example.weathermobileapp.domain.utils.ScreenKeys.NEXT_DAYS_FORECAST
import com.example.weathermobileapp.domain.utils.ScreenKeys.WEATHER_SCREEN

sealed class Screen(val route: String) {
    data object Weather: Screen(route = WEATHER_SCREEN)
    data object NextDaysForecast: Screen(route = NEXT_DAYS_FORECAST)
}
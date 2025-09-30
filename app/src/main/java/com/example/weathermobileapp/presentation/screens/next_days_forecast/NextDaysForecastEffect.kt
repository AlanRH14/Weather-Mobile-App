package com.example.weathermobileapp.presentation.screens.next_days_forecast

sealed interface NextDaysForecastEffect {
    data object NavigateToBack: NextDaysForecastEffect
}
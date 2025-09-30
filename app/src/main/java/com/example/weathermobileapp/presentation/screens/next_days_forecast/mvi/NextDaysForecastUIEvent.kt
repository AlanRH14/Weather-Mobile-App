package com.example.weathermobileapp.presentation.screens.next_days_forecast.mvi

sealed interface NextDaysForecastUIEvent {
    data object OnGetWeatherForecastData : NextDaysForecastUIEvent
    data class OnDayOfWeekUpdate(val dayOfWeek: String) : NextDaysForecastUIEvent
    data object OnNavigateToBack: NextDaysForecastUIEvent
}
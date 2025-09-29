package com.example.weathermobileapp.presentation.screens.next_days_forecast

sealed interface NextDaysForecastUIEvent {
    data object OnGetWeatherForecastData : NextDaysForecastUIEvent
}
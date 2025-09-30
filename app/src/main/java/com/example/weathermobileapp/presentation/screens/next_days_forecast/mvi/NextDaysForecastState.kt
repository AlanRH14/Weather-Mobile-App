package com.example.weathermobileapp.presentation.screens.next_days_forecast.mvi

import com.example.weathermobileapp.domain.models.WeatherForecast

data class NextDaysForecastState(
    val isLoading: Boolean = true,
    val forecast: WeatherForecast? = null,
    val dayOfWeek: String = "",
    val error: String? = null,
)
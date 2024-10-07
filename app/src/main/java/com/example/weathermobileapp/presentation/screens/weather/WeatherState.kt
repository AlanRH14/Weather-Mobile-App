package com.example.weathermobileapp.presentation.screens.weather

import com.example.weathermobileapp.domain.models.WeatherForecast
import com.example.weathermobileapp.domain.models.WeatherModel

data class WeatherState(
    val isLoading: Boolean = true,
    val weatherData: WeatherModel? = null,
    val forecast: WeatherForecast? = null,
    val error: String? = null
)

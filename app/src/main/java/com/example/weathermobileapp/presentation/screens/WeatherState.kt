package com.example.weathermobileapp.presentation.screens

import com.example.weathermobileapp.domain.models.WeatherModel

data class WeatherState(
    val isLoading: Boolean = true,
    val weatherData: WeatherModel? = null,
    val error: String? = null
)

package com.example.weathermobileapp.domain.models

data class DailyWeatherModel(
    val day: String,
    val image: Int,
    val lowTemp: String,
    val highTemp: String,
)

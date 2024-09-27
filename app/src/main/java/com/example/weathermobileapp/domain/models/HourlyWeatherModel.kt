package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes

data class HourlyWeatherModel(
    @DrawableRes val image: Int,
    val hour: String,
    val degrees: String,
)

package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes

data class HourlyWeatherModel(
    @DrawableRes val image: Int? = null,
    val hour: String? = null,
    val degrees: String? = null,
)

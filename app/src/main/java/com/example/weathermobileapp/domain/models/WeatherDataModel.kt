package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes

data class WeatherDataModel(
    @DrawableRes val iconRes: Int,
    val title: String,
    val subtitle: String,
)

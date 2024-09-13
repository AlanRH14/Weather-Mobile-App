package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes

data class WeatherMoreInfoModel(
    @DrawableRes val iconRes: Int,
    val title: String,
    val subtitle: String,
)

package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes

data class WeatherModel(
    @DrawableRes val image: Int,
    val locationData: WeatherLocationModel,
    val weatherData: List<WeatherDataModel>,
    val dailyWeathers: List<DailyWeatherModel>,
)

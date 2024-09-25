package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes

data class WeatherModel(
    @DrawableRes val image: Int? = null,
    val info: WeatherInfoModel? = null,
    val moreInfo: List<WeatherMoreInfoModel>? = null,
    val hourlyWeather: List<HourlyWeatherModel>? = null
)

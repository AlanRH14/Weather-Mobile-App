package com.example.weathermobileapp.domain.models

data class WeatherForecast(
    val todayWeather: List<HourlyWeatherModel>,
    val tomorrowWeather: List<DailyWeatherModel> = emptyList(),
    val nextDayWeather: List<DailyWeatherModel> = emptyList(),
)

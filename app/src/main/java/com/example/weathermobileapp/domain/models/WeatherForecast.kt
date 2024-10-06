package com.example.weathermobileapp.domain.models

data class WeatherForecast(
    val hourlyWeather: List<HourlyWeatherModel>,
    val dailyWeather: List<DailyWeatherModel>
)

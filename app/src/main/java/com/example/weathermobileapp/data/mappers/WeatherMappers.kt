package com.example.weathermobileapp.data.mappers

import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.data.remote.dto.WeatherDto
import com.example.weathermobileapp.domain.models.WeatherLocationModel
import com.example.weathermobileapp.domain.models.WeatherModel
import com.example.weathermobileapp.domain.models.WeatherType

fun WeatherDto.toWeatherModel(): WeatherModel {
    return WeatherModel(
        image = WeatherType.fromId(this.weather?.first()?.id).icon,
        locationData = WeatherLocationModel(
            date = WeatherData.locationData.date,
            degree = "${Math.round((this.main?.temp ?: 0.0) - 273.15)}°",
            location = "${this.name}",
            description = "${this.weather?.first()?.description}"
        ),
        weatherData = WeatherData.weatherData,
        hourlyWeathers = WeatherData.hourlyWeathers,
        dailyWeathers = WeatherData.dailyWeathers,
    )
}

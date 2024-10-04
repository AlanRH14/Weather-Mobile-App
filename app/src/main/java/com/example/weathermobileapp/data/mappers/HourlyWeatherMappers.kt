package com.example.weathermobileapp.data.mappers

import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import com.example.weathermobileapp.domain.models.WeatherType
import com.example.weathermobileapp.domain.utils.toHourFormat

fun List<Forecast?>?.toHourlyWeathers(): List<HourlyWeatherModel> {
    return this?.filterNotNull()
        ?.mapNotNull { forecast ->
            forecast.weather?.firstOrNull()?.let { weather ->
                HourlyWeatherModel(
                    image = WeatherType.fromId(weather.id).icon,
                    hour = forecast.dt.toHourFormat(),
                    degrees = "${Math.round(forecast.main?.temp ?: 0.0)}°"
                )
            }
        } ?: emptyList()
}
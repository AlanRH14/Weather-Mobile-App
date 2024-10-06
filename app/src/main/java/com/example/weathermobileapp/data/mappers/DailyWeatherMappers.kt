package com.example.weathermobileapp.data.mappers

import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.DailyWeatherModel
import com.example.weathermobileapp.domain.models.WeatherType
import com.example.weathermobileapp.domain.utils.DatePatternKeys.WEEKDAY
import com.example.weathermobileapp.domain.utils.DateUtils.toCustomDateFormat

fun List<Forecast?>?.toDailyWeathers(): List<DailyWeatherModel> {
    return this?.filterNotNull()
        ?.mapNotNull { forecast ->
            forecast.weather?.firstOrNull()?.let { weather ->
                DailyWeatherModel(
                    day = forecast.dt.toCustomDateFormat(WEEKDAY),
                    image = WeatherType.fromId(weather.id).icon,
                    lowTemp = "${Math.round(forecast.main?.tempMin ?: 0.0)}°",
                    highTemp = "${Math.round(forecast.main?.tempMax ?: 0.0)}°"
                )
            }
        } ?: emptyList()
}
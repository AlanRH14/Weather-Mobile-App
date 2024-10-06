package com.example.weathermobileapp.data.mappers

import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.WeatherForecast
import com.example.weathermobileapp.domain.utils.DateUtils.isToday
import com.example.weathermobileapp.domain.utils.DateUtils.isTomorrow

fun List<Forecast?>?.toForecastWeathers(): WeatherForecast {
    return WeatherForecast(
        hourlyWeather = this?.filter { forecast -> forecast?.dt?.isToday() ?: false }
            .toHourlyWeathers(),
        dailyWeather = this?.filter { forecast -> forecast?.dt?.isTomorrow() ?: false }
            .toDailyWeathers()
    )
}



package com.example.weathermobileapp.data.mappers_impl

import com.example.weathermobileapp.common.ApiMapper
import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.WeatherForecast
import com.example.weathermobileapp.domain.utils.DateUtils.isNextDays
import com.example.weathermobileapp.domain.utils.DateUtils.isToday
import com.example.weathermobileapp.domain.utils.DateUtils.isTomorrow

class ForecastMapperImpl(): ApiMapper<List<Forecast?>?, WeatherForecast> {

    override fun mapToDomain(dto: List<Forecast?>?): WeatherForecast {
        return WeatherForecast(
                todayWeather = dto?.filter { forecast -> forecast?.dt.isToday() }.toHourlyWeathers(),
                tomorrowWeather = forecast.dt.isTomorrow(),
                nextDayWeather = forecast.dt.isNextDays()
            )
        }
    }
}
fun List<Forecast?>?.toForecastWeathers(): WeatherForecast {
    return WeatherForecast(
        todayWeather = this?.filter { forecast -> forecast?.dt.isToday() }
            .toHourlyWeathers(),
        tomorrowWeather = this?.filter { forecast -> forecast?.dt.isTomorrow() }
            .toDailyWeathers(),
        nextDayWeather = this?.filter { forecast -> forecast?.dt.isNextDays() }
            .toDailyWeathers()
    )
}



package com.example.weathermobileapp.data.mappers_impl

import com.example.weathermobileapp.common.ApiMapper
import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import com.example.weathermobileapp.domain.models.WeatherType
import com.example.weathermobileapp.domain.utils.DatePatternKeys.HOUR
import com.example.weathermobileapp.domain.utils.DateUtils.toCustomDateFormat
import kotlin.math.roundToInt

class HourlyWeatherMapperImpl : ApiMapper<List<Forecast?>?, List<HourlyWeatherModel>> {

    override fun mapToDomain(dto: List<Forecast?>?): List<HourlyWeatherModel> {
        return dto?.filterNotNull()
            ?.mapNotNull { forecast ->
                forecast.weather?.firstOrNull()?.let { weather ->
                    HourlyWeatherModel(
                        image = WeatherType.fromId(weather.id).icon,
                        hour = forecast.dt.toCustomDateFormat(pattern = HOUR),
                        degrees = "${(forecast.main?.temp ?: 0.0).roundToInt()}"
                    )
                }
            } ?: emptyList()
    }
}
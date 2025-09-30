package com.example.weathermobileapp.data.mappers_impl

import com.example.weathermobileapp.common.ApiMapper
import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.DailyWeatherModel
import com.example.weathermobileapp.domain.models.WeatherType
import com.example.weathermobileapp.domain.utils.DatePatternKeys.WEEKDAY
import com.example.weathermobileapp.domain.utils.DateUtils.toCustomDateFormat
import kotlin.math.roundToInt

class DailyWeatherMapperImpl : ApiMapper<List<Forecast?>?, List<DailyWeatherModel>> {

    override fun mapToDomain(dto: List<Forecast?>?): List<DailyWeatherModel> {
        return dto?.filterNotNull()
            ?.mapNotNull { forecast ->
                forecast.weather?.firstOrNull()?.let { weather ->
                    DailyWeatherModel(
                        day = forecast.dt.toCustomDateFormat(pattern = WEEKDAY),
                        image = WeatherType.fromId(code = weather.id).icon,
                        lowTemp = "${(forecast.main?.tempMin ?: 0.0).roundToInt()}°",
                        highTemp = "${(forecast.main?.tempMax ?: 0.0).roundToInt()}°"
                    )
                }
            } ?: emptyList()
    }
}

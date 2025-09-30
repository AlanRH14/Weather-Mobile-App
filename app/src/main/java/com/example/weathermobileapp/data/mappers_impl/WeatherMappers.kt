package com.example.weathermobileapp.data.mappers_impl

import com.example.weathermobileapp.R
import com.example.weathermobileapp.common.ApiMapper
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.data.remote.dto.current.WeatherDto
import com.example.weathermobileapp.domain.models.WeatherDataModel
import com.example.weathermobileapp.domain.models.WeatherLocationModel
import com.example.weathermobileapp.domain.models.WeatherModel
import com.example.weathermobileapp.domain.models.WeatherType
import com.example.weathermobileapp.domain.utils.DatePatternKeys.DATE_HOUR
import com.example.weathermobileapp.domain.utils.DateUtils.toCustomDateFormat
import kotlin.math.roundToInt

class WeatherMapperImpl: ApiMapper<WeatherDto,  WeatherModel> {
    override fun mapToDomain(dto: WeatherDto): WeatherModel {
        return WeatherModel(
            image = WeatherType.fromId(dto.weather?.first()?.id).icon,
            locationData = WeatherLocationModel(
                city = "${dto.name}",
                date = dto.dt.toCustomDateFormat(DATE_HOUR),
                degree = "${(dto.main?.temp ?: 0.0).roundToInt()}°",
                description = "${dto.weather?.first()?.description}"
            ),
            weatherData = listOf(
                WeatherDataModel(
                    iconRes = R.drawable.ic_pressure,
                    title = "Pressure",
                    subtitle = "${dto.main?.pressure ?: 0}hpa"
                ),
                WeatherDataModel(
                    iconRes = R.drawable.ic_wind,
                    title = "Wind",
                    subtitle = "${(dto.wind?.speed ?: 0.0).roundToInt()}Km/s"
                ),
                WeatherDataModel(
                    iconRes = R.drawable.ic_drop,
                    title = "Humidity",
                    subtitle = "${dto.main?.humidity ?: 0}%"
                )
            ),
            dailyWeathers = WeatherData.dailyWeathers,
        )
    }
}

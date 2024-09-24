package com.example.weathermobileapp.data.mappers

import com.example.weathermobileapp.R
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData
import com.example.weathermobileapp.data.remote.dto.WeatherDto
import com.example.weathermobileapp.domain.models.WeatherInfoModel
import com.example.weathermobileapp.domain.models.WeatherModel
import com.example.weathermobileapp.domain.models.WeatherMoreInfoModel
import com.example.weathermobileapp.domain.models.WeatherType

fun WeatherDto.toWeatherModel(): WeatherModel {
    return WeatherModel(
        image = WeatherType.fromId(this.weather?.first()?.id).icon,
        info = WeatherInfoModel(
            degree = "${Math.round((this.main?.temp ?: 0.0 )- 273.15)}°",
            location = "${this.name}",
            description = "${this.weather?.first()?.description}"
        ),
        moreInfo = listOf(
            WeatherMoreInfoModel(
                iconRes = R.drawable.ic_humidity,
                title = "Humidity",
                subtitle = "${this.main?.humidity}%"
            ),
            WeatherMockData.WeatherInfoItem2,
            WeatherMockData.WeatherInfoItem3,
            WeatherMockData.WeatherInfoItem4
        )
    )
}

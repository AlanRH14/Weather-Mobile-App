package com.example.weathermobileapp.data.mappers

import com.example.weathermobileapp.R
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.data.remote.dto.current.WeatherDto
import com.example.weathermobileapp.domain.models.WeatherDataModel
import com.example.weathermobileapp.domain.models.WeatherLocationModel
import com.example.weathermobileapp.domain.models.WeatherModel
import com.example.weathermobileapp.domain.models.WeatherType
import com.example.weathermobileapp.domain.utils.toDateFormat

fun WeatherDto.toWeatherModel(): WeatherModel {
    return WeatherModel(
        image = WeatherType.fromId(this.weather?.first()?.id).icon,
        locationData = WeatherLocationModel(
            city = "${this.name}",
            date = this.dt.toDateFormat(),
            degree = "${Math.round(this.main?.temp ?: 0.0)}°",
            description = "${this.weather?.first()?.description}"
        ),
        weatherData = listOf(
            WeatherDataModel(
                iconRes = R.drawable.ic_pressure,
                title = "Pressure",
                subtitle = "${this.main?.pressure ?: 0}hpa"
            ),
            WeatherDataModel(
                iconRes = R.drawable.ic_wind,
                title = "Wind",
                subtitle = "${Math.round(this.wind?.speed ?: 0.0)}Km/s"
            ),
            WeatherDataModel(
                iconRes = R.drawable.ic_drop,
                title = "Humidity",
                subtitle = "${this.main?.humidity ?: 0}%"
            )
        ),
        hourlyWeathers = WeatherData.hourlyWeathers,
        dailyWeathers = WeatherData.dailyWeathers,
    )
}

/*private fun ForecastDto.toHourlyWeathers(): WeatherModel {
    return WeatherModel(
        image = WeatherType.fromId(this.)
    )
}*/

package com.example.weathermobileapp.data.local.mockdata

import com.example.weathermobileapp.R
import com.example.weathermobileapp.domain.models.WeatherInfoModel
import com.example.weathermobileapp.domain.models.WeatherMoreInfoModel
import com.example.weathermobileapp.domain.models.WeatherModel

object WeatherMockData {
    private val WeatherInfoItem1 = WeatherMoreInfoModel(
        iconRes = R.drawable.ic_humidity,
        title = "Humidity",
        subtitle = "85%"
    )

    val WeatherInfoItem2 = WeatherMoreInfoModel(
        iconRes = R.drawable.ic_sun_full,
        title = "Uv Index",
        subtitle = "2 of 10"
    )

    val WeatherInfoItem3 = WeatherMoreInfoModel(
        iconRes = R.drawable.ic_sun_half,
        title = "Sunrise",
        subtitle = "7:30 AM"
    )

    val WeatherInfoItem4 = WeatherMoreInfoModel(
        iconRes = R.drawable.ic_sun_half,
        title = "Sunset",
        subtitle = "4:28 PM"
    )

    private val WeatherInfoMock = WeatherInfoModel(
        degree = "11°",
        location = "New York City, NY",
        description = "Rainy to partly cloudy.\nWinds WSW at 10 to 15 km/h",
    )

    val WeatherData = WeatherModel(
        image = R.drawable.ic_very_cloudy,
        info = WeatherInfoMock,
        moreInfo = listOf(
            WeatherInfoItem1,
            WeatherInfoItem2,
            WeatherInfoItem3,
            WeatherInfoItem4,
        )
    )

}
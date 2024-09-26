package com.example.weathermobileapp.data.local.mockdata

import com.example.weathermobileapp.R
import com.example.weathermobileapp.domain.models.DailyWeatherModel
import com.example.weathermobileapp.domain.models.ErrorModel
import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import com.example.weathermobileapp.domain.models.WeatherLocationModel
import com.example.weathermobileapp.domain.models.WeatherDataModel
import com.example.weathermobileapp.domain.models.WeatherModel

object WeatherMockData {
    private val WeatherInfoItem1 = WeatherDataModel(
        iconRes = R.drawable.ic_humidity,
        title = "Humidity",
        subtitle = "85%"
    )

    val WeatherInfoItem2 = WeatherDataModel(
        iconRes = R.drawable.ic_sun_full,
        title = "Uv Index",
        subtitle = "2 of 10"
    )

    val WeatherInfoItem3 = WeatherDataModel(
        iconRes = R.drawable.ic_sun_half,
        title = "Sunrise",
        subtitle = "7:30 AM"
    )

    val WeatherInfoItem4 = WeatherDataModel(
        iconRes = R.drawable.ic_sun_half,
        title = "Sunset",
        subtitle = "4:28 PM"
    )

    private val WeatherInfoMock = WeatherLocationModel(
        date = "Mon June 17 | 10:00 AM",
        degree = "11°",
        location = "New York City, NY",
        description = "Rainy to partly cloudy.\nWinds WSW at 10 to 15 km/h",
    )

    private val HourlyWeatherItemMock = HourlyWeatherModel(
        image = R.drawable.ic_rainythunder,
        hour = "10 AM",
        degrees = "20°"
    )

    private val DailyWeatherItemMock = DailyWeatherModel(
        day = "sat",
        image = R.drawable.ic_very_cloudy,
        lowTemp = "19°",
        highTemp = "24°",
    )

    val ErrorMock = ErrorModel(
        id = 1,
        image = R.drawable.ic_couple,
        title = "Oooops! Location error",
        message = "Please activate location to be able to use the application"
    )

    val WeatherData = WeatherModel(
        image = R.drawable.ic_very_cloudy,
        locationData = WeatherInfoMock,
        weatherData = listOf(
            WeatherInfoItem1,
            WeatherInfoItem2,
            WeatherInfoItem3,
            WeatherInfoItem4,
        ),
        hourlyWeathers = listOf(
            HourlyWeatherItemMock,
            HourlyWeatherItemMock,
            HourlyWeatherItemMock,
            HourlyWeatherItemMock,
            HourlyWeatherItemMock,
            HourlyWeatherItemMock,
        ),
        dailyWeathers = listOf(
            DailyWeatherItemMock,
            DailyWeatherItemMock,
            DailyWeatherItemMock,
            DailyWeatherItemMock,
            DailyWeatherItemMock,
            DailyWeatherItemMock,
        )
    )
}
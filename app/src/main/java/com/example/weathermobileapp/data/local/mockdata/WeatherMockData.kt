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
        iconRes = R.drawable.ic_pressure,
        title = "Pressure",
        subtitle = "1021hpa"
    )

    private val WeatherInfoItem2 = WeatherDataModel(
        iconRes = R.drawable.ic_wind,
        title = "Wind",
        subtitle = "4Km/s"
    )

    private val WeatherInfoItem3 = WeatherDataModel(
        iconRes = R.drawable.ic_drop,
        title = "Humidity",
        subtitle = "60%"
    )

    private val WeatherInfoMock = WeatherLocationModel(
        city = "New York City, NY",
        date = "Mon June 17 | 10:00 AM",
        degree = "11°",
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
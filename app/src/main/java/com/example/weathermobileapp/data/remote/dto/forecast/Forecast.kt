package com.example.weathermobileapp.data.remote.dto.forecast

import com.example.weathermobileapp.data.remote.dto.Clouds
import com.example.weathermobileapp.data.remote.dto.Weather
import com.example.weathermobileapp.data.remote.dto.Wind
import com.squareup.moshi.Json

data class Forecast(
    @Json(name = "dt")
    val dt: Int?,
    @Json(name = "main")
    val main: Main?,
    @Json(name = "weather")
    val weather: List<Weather?>?,
    @Json(name = "clouds")
    val clouds: Clouds?,
    @Json(name = "wind")
    val wind: Wind?,
    @Json(name = "visibility")
    val visibility: Int?,
    @Json(name = "pop")
    val pop: Double?,
    @Json(name = "rain")
    val rain: Rain?,
    @Json(name = "snow")
    val snow: Snow? = null,
    @Json(name = "sys")
    val sys: Sys?,
    @Json(name = "dt_txt")
    val dtTxt: String?,
)
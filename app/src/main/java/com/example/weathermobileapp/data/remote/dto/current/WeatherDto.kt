package com.example.weathermobileapp.data.remote.dto.current

import com.example.weathermobileapp.data.remote.dto.Clouds
import com.example.weathermobileapp.data.remote.dto.Coordinates
import com.example.weathermobileapp.data.remote.dto.Weather
import com.example.weathermobileapp.data.remote.dto.Wind
import com.squareup.moshi.Json

data class WeatherDto(
    @Json(name = "coord")
    val coordinates: Coordinates? = null,
    @Json(name = "weather")
    val weather: List<Weather>? = null,
    @Json(name = "base")
    val base: String? = null,
    @Json(name = "main")
    val main: Main? = null,
    @Json(name = "visibility")
    val visibility: Int? = null,
    @Json(name = "wind")
    val wind: Wind? = null,
    @Json(name = "rain")
    val rain: Rain? = null,
    @Json(name = "snow")
    val snow: Snow? = null,
    @Json(name = "clouds")
    val clouds: Clouds? = null,
    @Json(name = "dt")
    val dt: Int? = null,
    @Json(name = "sys")
    val sys: Sys? = null,
    @Json(name = "timezone")
    val timezone: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "cod")
    val cod: Int? = null,
)
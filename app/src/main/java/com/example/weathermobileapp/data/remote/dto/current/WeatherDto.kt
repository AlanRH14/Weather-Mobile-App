package com.example.weathermobileapp.data.remote.dto.current

import com.example.weathermobileapp.data.remote.dto.Clouds
import com.example.weathermobileapp.data.remote.dto.Coordinates
import com.example.weathermobileapp.data.remote.dto.Weather
import com.example.weathermobileapp.data.remote.dto.Wind
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerialName(value = "coord")
    val coordinates: Coordinates? = null,
    @SerialName(value = "weather")
    val weather: List<Weather>? = null,
    @SerialName(value = "base")
    val base: String? = null,
    @SerialName(value = "main")
    val main: Main? = null,
    @SerialName(value = "visibility")
    val visibility: Int? = null,
    @SerialName(value = "wind")
    val wind: Wind? = null,
    @SerialName(value = "rain")
    val rain: Rain? = null,
    @SerialName(value = "snow")
    val snow: Snow? = null,
    @SerialName(value = "clouds")
    val clouds: Clouds? = null,
    @SerialName(value = "dt")
    val dt: Int? = null,
    @SerialName(value = "sys")
    val sys: Sys? = null,
    @SerialName(value = "timezone")
    val timezone: Int? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "cod")
    val cod: Int? = null,
)
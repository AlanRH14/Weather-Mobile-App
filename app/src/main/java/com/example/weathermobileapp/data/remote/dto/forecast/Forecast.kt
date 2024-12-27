package com.example.weathermobileapp.data.remote.dto.forecast

import com.example.weathermobileapp.data.remote.dto.Clouds
import com.example.weathermobileapp.data.remote.dto.Weather
import com.example.weathermobileapp.data.remote.dto.Wind
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    @SerialName(value = "dt")
    val dt: Int?,
    @SerialName(value = "main")
    val main: Main?,
    @SerialName(value = "weather")
    val weather: List<Weather?>?,
    @SerialName(value = "clouds")
    val clouds: Clouds?,
    @SerialName(value = "wind")
    val wind: Wind?,
    @SerialName(value = "visibility")
    val visibility: Int?,
    @SerialName(value = "pop")
    val pop: Double?,
    @SerialName(value = "rain")
    val rain:  Rain? = null,
    @SerialName(value = "snow")
    val snow: Snow? = null,
    @SerialName(value = "sys")
    val sys: Sys?,
    @SerialName(value = "dt_txt")
    val dtTxt: String?,
)
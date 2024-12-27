package com.example.weathermobileapp.data.remote.dto.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerialName(value = "temp")
    val temp: Double?,
    @SerialName(value = "feels_like")
    val feelsLike: Double?,
    @SerialName(value = "temp_min")
    val tempMin: Double?,
    @SerialName(value = "temp_max")
    val tempMax: Double?,
    @SerialName(value = "pressure")
    val pressure: Int?,
    @SerialName(value = "sea_level")
    val seaLevel: Int?,
    @SerialName(value = "grnd_level")
    val grandLevel: Int?,
    @SerialName(value = "humidity")
    val humidity: Int?,
    @SerialName(value = "temp_kf")
    val tempKf: Double?,
)
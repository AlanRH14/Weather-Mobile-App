package com.example.weathermobileapp.data.remote.dto.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerialName(value = "temp")
    val temp: Double? = null,
    @SerialName(value = "feels_like")
    val feelsLike: Double? = null,
    @SerialName(value = "temp_min")
    val tempMin: Double? = null,
    @SerialName(value = "temp_max")
    val tempMax: Double? = null,
    @SerialName(value = "pressure")
    val pressure: Int? = null,
    @SerialName(value = "humidity")
    val humidity: Int? = null,
    @SerialName(value = "sea_level")
    val seaLevel: Int? = null,
    @SerialName(value = "grnd_level")
    val grandLevel: Int? = null,
)
package com.example.weathermobileapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    @SerialName(value = "speed")
    val speed: Double? = null,
    @SerialName(value = "deg")
    val deg: Int? = null,
    @SerialName(value = "gust")
    val gust: Double? = null,
)
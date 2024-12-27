package com.example.weathermobileapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    @SerialName(value = "lat")
    val lat: Double?,
    @SerialName(value = "lon")
    val lon: Double?
)
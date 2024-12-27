package com.example.weathermobileapp.data.remote.dto.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snow(
    @SerialName(value = "3h")
    val h: Double? = null
)
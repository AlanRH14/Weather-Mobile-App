package com.example.weathermobileapp.data.remote.dto.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snow(
    @SerialName(value = "1h")
    val h: Double? = null
)
package com.example.weathermobileapp.data.remote.dto.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName(value = "pod")
    val pod: String?
)
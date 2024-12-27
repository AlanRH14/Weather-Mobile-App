package com.example.weathermobileapp.data.remote.dto.current

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName(value = "type")
    val type: Int? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "country")
    val country: String? = null,
    @SerialName(value = "sunrise")
    val sunrise: Int? = null,
    @SerialName(value = "sunset")
    val sunset: Int? = null,
)
package com.example.weathermobileapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "main")
    val main: String? = null,
    @SerialName(value = "description")
    val description: String? = null,
    @SerialName(value = "icon")
    val icon: String? = null,
)
package com.example.weathermobileapp.data.remote.dto.forecast

import com.example.weathermobileapp.data.remote.dto.Coordinates
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class City(
   @SerialName(value = "id")
    val id: Int?,
   @SerialName(value = "name")
    val name: String?,
   @SerialName(value = "coord")
    val location: Coordinates?,
   @SerialName(value = "country")
    val country: String?,
   @SerialName(value = "population")
    val population: Int?,
   @SerialName(value = "timezone")
    val timezone: Int?,
   @SerialName(value = "sunrise")
    val sunrise: Int?,
   @SerialName(value = "sunset")
    val sunset: Int?,
)
package com.example.weathermobileapp.data.remote.dto.forecast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDto(
    @SerialName(value = "cod")
    val cod: String?,
    @SerialName(value = "message")
    val message: Int?,
    @SerialName(value = "cnt")
    val cnt: Int?,
    @SerialName(value = "list")
    val forecasts: List<Forecast?>?,
    @SerialName(value = "city")
    val city: City?,
)
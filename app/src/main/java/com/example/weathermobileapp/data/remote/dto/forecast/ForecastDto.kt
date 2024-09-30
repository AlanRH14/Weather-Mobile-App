package com.example.weathermobileapp.data.remote.dto.forecast

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("cod")
    val cod: String?,
    @SerializedName("message")
    val message: Int?,
    @SerializedName("cnt")
    val cnt: Int?,
    @SerializedName("list")
    val forecasts: List<Forecast?>?,
    @SerializedName("city")
    val city: City?,
)
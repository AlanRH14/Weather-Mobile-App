package com.example.weathermobileapp.data.remote.dto.forecast

import com.squareup.moshi.Json

data class ForecastDto(
    @Json(name = "cod")
    val cod: String?,
    @Json(name = "message")
    val message: Int?,
    @Json(name = "cnt")
    val cnt: Int?,
    @Json(name = "list")
    val forecasts: List<Forecast?>?,
    @Json(name = "city")
    val city: City?,
)
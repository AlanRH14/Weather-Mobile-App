package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Wind(
    @Json(name = "speed")
    val speed: Double? = null,
    @Json(name = "deg")
    val deg: Int? = null,
    @Json(name = "gust")
    val gust: Double? = null,
)
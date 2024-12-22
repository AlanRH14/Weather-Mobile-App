package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Coordinates(
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "lon")
    val lon: Double?
)
package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Snow(
    @Json(name = "1h")
    val precipitation: Double
)

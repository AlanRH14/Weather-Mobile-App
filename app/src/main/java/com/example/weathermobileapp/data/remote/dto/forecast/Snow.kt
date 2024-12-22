package com.example.weathermobileapp.data.remote.dto.forecast

import com.squareup.moshi.Json

data class Snow(
    @Json(name = "3h")
    val h: Double? = null
)
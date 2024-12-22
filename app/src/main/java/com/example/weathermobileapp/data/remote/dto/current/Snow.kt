package com.example.weathermobileapp.data.remote.dto.current

import com.squareup.moshi.Json

data class Snow(
    @Json(name = "1h")
    val h: Double? = null
)
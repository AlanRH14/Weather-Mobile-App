package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Rain(
    @Json(name = "1h")
    val precipitation: Double
)
package com.example.weathermobileapp.data.remote.dto.forecast

import com.squareup.moshi.Json

data class Rain(
    @Json(name = "3h")
    val h: Double?
)
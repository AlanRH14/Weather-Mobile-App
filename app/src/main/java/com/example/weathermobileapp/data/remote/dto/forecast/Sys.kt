package com.example.weathermobileapp.data.remote.dto.forecast

import com.squareup.moshi.Json

data class Sys(
    @Json(name = "pod")
    val pod: String?
)
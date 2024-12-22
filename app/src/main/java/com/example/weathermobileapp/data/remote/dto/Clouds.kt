package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Clouds(
    @Json(name = "all") val all: Int?
)
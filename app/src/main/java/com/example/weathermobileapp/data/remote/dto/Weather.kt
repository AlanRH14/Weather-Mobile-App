package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Weather(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "main")
    val main: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "icon")
    val icon: String? = null,
)
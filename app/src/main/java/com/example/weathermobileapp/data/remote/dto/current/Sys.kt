package com.example.weathermobileapp.data.remote.dto.current

import com.squareup.moshi.Json

data class Sys(
    @Json(name = "type")
    val type: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "sunrise")
    val sunrise: Int? = null,
    @Json(name = "sunset")
    val sunset: Int? = null,
)
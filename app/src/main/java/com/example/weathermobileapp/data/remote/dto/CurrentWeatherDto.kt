package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class CurrentWeatherDto(
    @Json(name = "coord")
    val location: Location,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val rain: Rain? = null,
    val snow: Snow? = null,
    val dt: Int,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int,
)
package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class CurrentWeatherDto(
    @field:Json(name = "coord")
    val location: Location,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val rain: Rain,
    val clouds: Clouds,
    val dt: Int,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int,
)
package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Main(
    @field:Json(name = "feels_like")
    val feelsLike: Double,
    @field:Json(name = "grnd_level")
    val groundLevel: Int,
    val humidity: Int,
    val pressure: Int,
    @field:Json(name = "sea_level")
    val seaLevel: Int,
    val temp: Double,
    @field:Json(name = "temp_max")
    val tempMax: Double,
    @field:Json(name = "temp_min")
    val tempMin: Double
)
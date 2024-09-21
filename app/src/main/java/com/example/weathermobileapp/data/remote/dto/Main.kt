package com.example.weathermobileapp.data.remote.dto

import com.squareup.moshi.Json

data class Main(
    val temp: Double,
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "temp_min")
    val tempMin: Double,
    @Json(name = "temp_max")
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    @Json(name = "sea_level")
    val seaLevel: Int,
    @Json(name = "grnd_level")
    val groundLevel: Int,
)
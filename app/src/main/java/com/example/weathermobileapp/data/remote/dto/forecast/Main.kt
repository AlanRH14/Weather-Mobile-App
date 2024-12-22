package com.example.weathermobileapp.data.remote.dto.forecast

import com.squareup.moshi.Json

data class Main(
    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "feels_like")
    val feelsLike: Double?,
    @Json(name = "temp_min")
    val tempMin: Double?,
    @Json(name = "temp_max")
    val tempMax: Double?,
    @Json(name = "pressure")
    val pressure: Int?,
    @Json(name = "sea_level")
    val seaLevel: Int?,
    @Json(name = "grnd_level")
    val grandLevel: Int?,
    @Json(name = "humidity")
    val humidity: Int?,
    @Json(name = "temp_kf")
    val tempKf: Double?,
)
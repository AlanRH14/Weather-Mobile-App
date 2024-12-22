package com.example.weathermobileapp.data.remote.dto.current

import com.squareup.moshi.Json

data class Main(
    @Json(name = "temp")
    val temp: Double? = null,
    @Json(name = "feels_like")
    val feelsLike: Double? = null,
    @Json(name = "temp_min")
    val tempMin: Double? = null,
    @Json(name = "temp_max")
    val tempMax: Double? = null,
    @Json(name = "pressure")
    val pressure: Int? = null,
    @Json(name = "humidity")
    val humidity: Int? = null,
    @Json(name = "sea_level")
    val seaLevel: Int? = null,
    @Json(name = "grnd_level")
    val grandLevel: Int? = null,
)
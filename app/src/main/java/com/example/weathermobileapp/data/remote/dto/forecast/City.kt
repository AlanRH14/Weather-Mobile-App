package com.example.weathermobileapp.data.remote.dto.forecast

import com.example.weathermobileapp.data.remote.dto.Coordinates
import com.squareup.moshi.Json

data class City(
   @Json(name = "id")
    val id: Int?,
   @Json(name = "name")
    val name: String?,
   @Json(name = "coord")
    val location: Coordinates?,
   @Json(name = "country")
    val country: String?,
   @Json(name = "population")
    val population: Int?,
   @Json(name = "timezone")
    val timezone: Int?,
   @Json(name = "sunrise")
    val sunrise: Int?,
   @Json(name = "sunset")
    val sunset: Int?,
)
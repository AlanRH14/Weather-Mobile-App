package com.example.weathermobileapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("coord")
    val coordinates: Coord? = null,
    @SerializedName("weather")
    val weather: List<Weather>? = null,
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("main")
    val main: Main? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("wind")
    val wind: Wind? = null,
    @SerializedName("rain")
    val rain: Rain? = null,
    @SerializedName("snow")
    val snow: Snow? = null,
    @SerializedName("clouds")
    val clouds: Clouds? = null,
    @SerializedName("dt")
    val dt: Int? = null,
    @SerializedName("sys")
    val sys: Sys? = null,
    @SerializedName("timezone")
    val timezone: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("cod")
    val cod: Int? = null,
)
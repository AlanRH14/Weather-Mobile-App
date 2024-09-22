package com.example.weathermobileapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lon")
    val lon: Double? = null,
    @SerializedName("lat")
    val lat: Double? = null,
)
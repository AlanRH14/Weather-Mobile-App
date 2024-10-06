package com.example.weathermobileapp.data.remote.dto.forecast

import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    val h: Double? = null
)
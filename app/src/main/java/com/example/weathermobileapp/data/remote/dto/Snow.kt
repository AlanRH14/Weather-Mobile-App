package com.example.weathermobileapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("1h")
    val h: Double? = null
)
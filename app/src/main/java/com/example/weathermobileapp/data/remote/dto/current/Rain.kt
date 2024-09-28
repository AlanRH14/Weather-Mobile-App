package com.example.weathermobileapp.data.remote.dto.current

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    val h: Double? = null
)
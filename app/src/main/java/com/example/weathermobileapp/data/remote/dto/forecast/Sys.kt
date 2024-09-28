package com.example.weathermobileapp.data.remote.dto.forecast

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("pod")
    val pod: String?
)
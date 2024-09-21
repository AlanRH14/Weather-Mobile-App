package com.example.weathermobileapp.data.remote.dto

data class Sys(
    val type: Int,
    val id: Int,
    val message: String? = null,
    val country: String,
    val sunrise: Int,
    val sunset: Int,
)
package com.example.weathermobileapp.data.remote.dto

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)
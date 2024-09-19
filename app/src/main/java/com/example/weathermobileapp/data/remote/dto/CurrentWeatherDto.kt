package com.example.weathermobileapp.data.remote.dto

data class CurrentWeatherDto(
    val current: Current?,
    val daily: List<Daily>?,
    val hourly: List<Hourly>?,
    val lat: Double?,
    val lon: Double?,
    val minutely: List<Minutely>?,
    val timezone: String?,
    val timezone_offset: Int?,
    val alerts: List<Alert>?,
)
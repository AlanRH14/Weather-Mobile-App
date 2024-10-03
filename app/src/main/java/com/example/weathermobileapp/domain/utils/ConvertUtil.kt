package com.example.weathermobileapp.domain.utils

import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Int?.toCustomDateFormat(): String {
    return try {
        if (this != null) {
            val dateFormat = SimpleDateFormat("EEE MMM d | h:mm a", Locale.US)
            val date = Date(this * 1000L)
            dateFormat.format(date)
        } else {
            "N/A"
        }
    } catch (e: Exception) {
        "N/A"
    }
}

fun Int?.toHourFormat(): String {
    return try {
        if (this != null) {
            val dateFormat = SimpleDateFormat("h:mm a", Locale.ROOT)
            val date = Date(this * 1000L)
            dateFormat.format(date)
        } else {
            "N/A"
        }
    } catch (e: Exception) {
        "N/A"
    }
}

private fun compareDate(test: List<HourlyWeatherModel>): List<HourlyWeatherModel> {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ROOT)
    val currentDay = dateFormat.format(System.currentTimeMillis())
    val tomorrow = dateFormat.format(System.currentTimeMillis() + 24 * 60 * 60 * 1000)
    val nextDay = dateFormat.format(System.currentTimeMillis() + 48 * 60 * 60 * 1000)
    val date = Date(1727751600 * 1000L)
    val weatherDate = dateFormat.format(date)

    return test.filter { forcast ->
        when {
            weatherDate == currentDay -> forcast.hour == currentDay

            weatherDate == tomorrow -> forcast.hour == tomorrow

            weatherDate >= nextDay -> forcast.hour >= nextDay

            else -> true
        }
    }
}
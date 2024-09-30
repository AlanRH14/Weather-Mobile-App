package com.example.weathermobileapp.domain.utils

import android.util.Log
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
            val dateFormat = SimpleDateFormat("dd h:mm a", Locale.US)
            val date = Date(this * 1000L)
            dateFormat.format(date)
        } else {
            "N/A"
        }
    } catch (e: Exception) {
        "N/A"
    }
}

fun compareDate() {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    val currentDay = dateFormat.format(System.currentTimeMillis())
    val date = Date(1727978400 * 1000L)
    val weatherDate = dateFormat.format(date)
    val tomorrow = currentDay.plus(1)
    when {
        weatherDate == currentDay -> {
            Log.d("LordMiau", "Res: Hoy $currentDay")
        }

        weatherDate == tomorrow -> {
            Log.d("LordMiau", "Res: Mañana $currentDay")
        }

        weatherDate > tomorrow -> {
            Log.d("LordMiau", "Res: De más días $currentDay")
        }

        else -> {
            Log.d("LordMiau", "Res: N/A")
        }
    }

}
package com.example.weathermobileapp.domain.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Int?.toDateFormat(): String {
    return try {
        if (this != null) {
            val dateFormat = SimpleDateFormat("EEE MMM d | h:mm a", Locale.US)
            val date = Date(this * 1000L)
            dateFormat.format(date)
        } else {
            "N/A"
        }
    }catch (e: Exception){
        "N/A"
    }
}
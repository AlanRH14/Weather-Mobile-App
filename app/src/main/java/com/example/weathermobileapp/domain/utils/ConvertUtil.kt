package com.example.weathermobileapp.domain.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateUtils {
    fun Int?.toCustomDateFormat(pattern: String): String {
        return try {
            if (this != null) {
                val dateFormat = SimpleDateFormat(pattern, Locale.US)
                val date = Date(this * 1000L)
                dateFormat.format(date)
            } else {
                "N/A"
            }
        } catch (e: Exception) {
            "N/A"
        }
    }

    fun Int?.isToday(): Boolean {
        return this?.let { Date(it * 1000L).isToday() } ?: false
    }

    fun Int?.isTomorrow(): Boolean {
        return this?.let { Date(it * 1000L).isTomorrow() } ?: false
    }

    private fun Date.isToday(): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = this
        val today = Calendar.getInstance()
        today.time = Date()
        return calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)
    }

    private fun Date.isTomorrow(): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = this
        val tomorrow = Calendar.getInstance()
        tomorrow.time = Date()
        tomorrow.add(Calendar.DAY_OF_YEAR, 1)
        return calendar.get(Calendar.YEAR) == tomorrow.get(Calendar.YEAR) &&
                calendar.get(Calendar.DAY_OF_YEAR) == tomorrow.get(Calendar.DAY_OF_YEAR)
    }
}

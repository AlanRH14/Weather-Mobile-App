package com.example.weathermobileapp.data.remote.dto

data class Alert(
    val description: String?,
    val end: Int?,
    val event: String?,
    val sender_name: String?,
    val start: Int?,
    val tags: List<Any?>?
)
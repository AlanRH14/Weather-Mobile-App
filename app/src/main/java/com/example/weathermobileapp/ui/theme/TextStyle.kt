package com.example.weathermobileapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val WeatherDegreesStyle = TextStyle(
    color = DarkBlue,
    fontSize = 48.sp,
    fontWeight = FontWeight.Bold
)

val WeatherLocationStyle = TextStyle(
    color = DarkBlue,
    fontSize = 20.sp,
    fontWeight = FontWeight.Medium
)

val WeatherDescription = TextStyle(
    color = Color.Gray,
    fontSize = 16.sp,
    textAlign = TextAlign.Center
)

val WeatherInfoTitle = TextStyle(
    color = DarkBlue,
)

val WeatherInfoSubtitle = TextStyle(
    color = DarkBlue,
    fontWeight = FontWeight.Bold
)

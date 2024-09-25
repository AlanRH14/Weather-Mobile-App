package com.example.weathermobileapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val VeryLightGray = Color(0xFFF8FAFB)
val LightGray = Color(0xFFF3F2F5)
val LightBluePurple = Color(0xFF59469D)
val DarkPurple = Color(0xFF643D67)
val Purple = Color(0xFF331688).copy(alpha = 0.2F)


val ShimmerColorGradient = listOf(
    Color.LightGray.copy(alpha = 0.6F),
    Color.LightGray.copy(alpha = 0.2F),
    Color.LightGray.copy(alpha = 0.6F)
)

val BackGroundColor = Brush.horizontalGradient(
    colors = listOf(
        LightBluePurple,
        DarkPurple
    )
)
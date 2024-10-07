package com.example.weathermobileapp.presentation.components.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.weathermobileapp.ui.theme.DailyWeatherTitle

@Composable
fun TitleDayOfWeekItem(
    dayOfWeek: String
) {
    Text(
        text = dayOfWeek,
        style = DailyWeatherTitle
    )
}

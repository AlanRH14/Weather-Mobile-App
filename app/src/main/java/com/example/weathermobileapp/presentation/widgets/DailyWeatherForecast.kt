package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.weathermobileapp.presentation.components.items.DailyWeatherItem
import com.example.weathermobileapp.ui.theme.DailyWeatherNextDays
import com.example.weathermobileapp.ui.theme.DailyWeatherTitle
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.VerySmallPadding

@Composable
fun DailyWeatherForecast() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SmallPadding),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(VerySmallPadding)
        ) {
            Text(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth(),
                text = "Future",
                style = DailyWeatherTitle
            )

            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "Next day´s",
                    style = DailyWeatherNextDays
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    tint = Color.White,
                    contentDescription = "Icon Next Day´s",
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(VerySmallPadding)
        ) {
            repeat(4) {
                DailyWeatherItem()
            }
        }
    }
}
package com.example.weathermobileapp.presentation.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R
import com.example.weathermobileapp.ui.theme.DailyWeatherItemText
import com.example.weathermobileapp.ui.theme.GenericPadding.DailyWeather

@Composable
fun DailyWeatherItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = "Sat",
            style = DailyWeatherItemText
        )

        Icon(
            modifier = Modifier
                .padding(DailyWeather)
                .size(45.dp),
            painter = painterResource(R.drawable.ic_very_cloudy),
            tint = Color.White,
            contentDescription = "Icon Daily Weather",
        )

        Text(
            modifier = Modifier
                .weight(1F),
            text = "24°",
            style = DailyWeatherItemText
        )

        Text(
            text = "24°",
            style = DailyWeatherItemText
        )
    }
}
package com.example.weathermobileapp.presentation.components.items

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.domain.models.DailyWeatherModel
import com.example.weathermobileapp.ui.theme.DailyWeatherItemText
import com.example.weathermobileapp.ui.theme.GenericPadding.DailyWeather

@Composable
fun DailyWeatherItem(
    dailyWeather: DailyWeatherModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = dailyWeather.day,
            style = DailyWeatherItemText
        )

        Icon(
            modifier = Modifier
                .padding(DailyWeather)
                .size(45.dp),
            painter = painterResource(dailyWeather.image),
            tint = Color.White,
            contentDescription = "Icon Daily Weather",
        )

        Text(
            modifier = Modifier
                .weight(1F),
            text = dailyWeather.lowTemp,
            style = DailyWeatherItemText
        )

        Text(
            text = dailyWeather.highTemp,
            style = DailyWeatherItemText
        )
    }
}

@Preview
@Composable
fun DailyWeatherItemPreview() {
    WeatherData.dailyWeathers.forEach {
        DailyWeatherItem(it)
    }
}
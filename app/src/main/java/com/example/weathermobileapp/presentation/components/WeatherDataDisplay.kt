package com.example.weathermobileapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.domain.models.WeatherDataModel
import com.example.weathermobileapp.presentation.components.items.WeatherInfoItem

@Composable
fun WeatherDataDisplay(
    moreInfoList: List<WeatherDataModel>,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        items(moreInfoList) { weatherInfo ->
            WeatherInfoItem(
                weatherInfo = weatherInfo,
            )
        }
    }
}

@Preview
@Composable
internal fun WeatherInfoPreview() {
    WeatherDataDisplay(WeatherData.weatherData)
}
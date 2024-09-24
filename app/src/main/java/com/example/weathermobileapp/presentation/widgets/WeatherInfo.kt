package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.domain.models.WeatherMoreInfoModel
import com.example.weathermobileapp.presentation.components.WeatherInfoItem
import com.example.weathermobileapp.ui.theme.Purple
import com.example.weathermobileapp.ui.theme.Shapes
import com.example.weathermobileapp.ui.theme.SmallPadding

@Composable
fun WeatherInfo(
    moreInfoList: List<WeatherMoreInfoModel>,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SmallPadding),
        shape = Shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = Purple
        )
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SmallPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            items(moreInfoList) { weatherInfo ->
                WeatherInfoItem(
                    modifier = Modifier
                        .weight(1F),
                    weatherInfo = weatherInfo,
                )
            }
        }
    }
}

@Preview
@Composable
internal fun WeatherInfoPreview() {
    WeatherInfo(WeatherData.moreInfo ?: emptyList())
}
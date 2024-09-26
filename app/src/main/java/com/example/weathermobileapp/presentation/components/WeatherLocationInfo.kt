package com.example.weathermobileapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.domain.models.WeatherLocationModel
import com.example.weathermobileapp.ui.theme.WeatherDateHeader
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.WeatherDegreesStyle
import com.example.weathermobileapp.ui.theme.WeatherLocationStyle

@Composable
fun WeatherLocationInfo(
    info: WeatherLocationModel,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(SmallPadding)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SmallPadding),
            text = info.date,
            style = WeatherDateHeader,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = info.degree,
            style = WeatherDegreesStyle
        )

        Text(
            modifier = Modifier
                .padding(bottom = SmallPadding)
                .fillMaxWidth(),
            text = info.location,
            style = WeatherLocationStyle
        )
    }
}

@Preview
@Composable
internal fun WeatherMoreInfoPreview() {
    WeatherLocationInfo(WeatherData.locationData)
}
package com.example.weathermobileapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weathermobileapp.R
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.domain.models.WeatherInfoModel
import com.example.weathermobileapp.presentation.widgets.WeatherHeaderImage
import com.example.weathermobileapp.presentation.widgets.WeatherInfo
import com.example.weathermobileapp.presentation.widgets.WeatherMoreInfo
import com.example.weathermobileapp.ui.theme.GenericPadding

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(GenericPadding.ScreenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WeatherHeaderImage(
            modifier = Modifier.weight(1F),
            image = WeatherData.image ?: R.drawable.ic_couple
        )

        WeatherMoreInfo(info = WeatherData.info ?: WeatherInfoModel())

        WeatherInfo(moreInfoList = WeatherData.moreInfo ?: emptyList())
    }
}


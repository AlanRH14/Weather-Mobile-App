package com.example.weathermobileapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weathermobileapp.R
import com.example.weathermobileapp.domain.models.WeatherInfoModel
import com.example.weathermobileapp.presentation.widgets.WeatherHeaderImage
import com.example.weathermobileapp.presentation.widgets.WeatherInfo
import com.example.weathermobileapp.presentation.widgets.WeatherMoreInfo
import com.example.weathermobileapp.presentation.widgets.WeatherScreenShimmer
import com.example.weathermobileapp.ui.theme.GenericPadding

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    weatherVM: WeatherViewModel = hiltViewModel()
) {
    val weatherData by weatherVM.state.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(GenericPadding.ScreenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if (weatherData.isLoading) {
            WeatherScreenShimmer(
                modifier = Modifier
                    .weight(1F)
            )
        }

        if (weatherData.weatherData != null) {
            WeatherHeaderImage(
                modifier = Modifier
                    .weight(1F),
                image = weatherData.weatherData?.image ?: R.drawable.ic_couple
            )

            WeatherMoreInfo(info = weatherData.weatherData?.info ?: WeatherInfoModel())

            WeatherInfo(moreInfoList = weatherData.weatherData?.moreInfo ?: emptyList())
        }

        // if (weatherData.error.isNullOrEmpty()){}
    }
}


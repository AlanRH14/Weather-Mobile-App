package com.example.weathermobileapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.ErrorMock
import com.example.weathermobileapp.presentation.widgets.DailyWeatherForecast
import com.example.weathermobileapp.presentation.widgets.WeatherHeader
import com.example.weathermobileapp.presentation.widgets.HourlyWeatherForecast
import com.example.weathermobileapp.presentation.widgets.ErrorMessageScreen
import com.example.weathermobileapp.presentation.widgets.WeatherScreenShimmer
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    weatherVM: WeatherViewModel = hiltViewModel()
) {
    val weatherData by weatherVM.state.collectAsStateWithLifecycle()

    if (weatherData.isLoading) {
        WeatherScreenShimmer(modifier = modifier)
    }

    weatherData.weatherData?.let { data ->
        Column(
            modifier = modifier
                .background(BackGroundColor)
                .fillMaxSize()
                .padding(ScreenPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            WeatherHeader(
                image = data.image,
                info = data.locationData,
                moreInfo = data.weatherData,
            )

            HourlyWeatherForecast(data.hourlyWeathers)

            DailyWeatherForecast(data.dailyWeathers)
        }
    }

    if (!weatherData.error.isNullOrEmpty()) {
        ErrorMessageScreen(
            modifier = modifier,
            errorData = ErrorMock,
        )
    }
}

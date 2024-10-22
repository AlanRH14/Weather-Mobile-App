package com.example.weathermobileapp.presentation.screens.weather

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
import androidx.navigation.NavController
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.ErrorMock
import com.example.weathermobileapp.navigation.Screen
import com.example.weathermobileapp.presentation.widgets.TomorrowWeatherForecast
import com.example.weathermobileapp.presentation.widgets.WeatherHeader
import com.example.weathermobileapp.presentation.widgets.HourlyWeatherForecast
import com.example.weathermobileapp.presentation.screens.error.ErrorMessageScreen
import com.example.weathermobileapp.presentation.widgets.shimmers.WeatherScreenShimmer
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    weatherVM: WeatherViewModel = hiltViewModel(),
    navController: NavController,
) {
    val weatherData by weatherVM.state.collectAsStateWithLifecycle()

    if (weatherData.isLoading) {
        WeatherScreenShimmer(modifier = modifier)
    }

    weatherData.weatherData?.let { weather ->
        Column(
            modifier = modifier
                .background(BackGroundColor)
                .fillMaxSize()
                .padding(ScreenPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            WeatherHeader(
                image = weather.image,
                info = weather.locationData,
                moreInfo = weather.weatherData,
            )

            weatherData.forecast?.let { forecast ->
                HourlyWeatherForecast(forecast.todayWeather)

                TomorrowWeatherForecast(forecast.tomorrowWeather) {
                    navController.navigate(Screen.NextDaysForecast.route)
                }
            }
        }
    }

    if (!weatherData.error.isNullOrEmpty()) {
        ErrorMessageScreen(
            modifier = modifier,
            errorData = ErrorMock,
        )
    }
}

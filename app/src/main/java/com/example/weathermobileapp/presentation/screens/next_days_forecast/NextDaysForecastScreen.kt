package com.example.weathermobileapp.presentation.screens.next_days_forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.ErrorMock
import com.example.weathermobileapp.data.mappers.DayOfWeekMapper.getDayOfWeek
import com.example.weathermobileapp.presentation.components.items.DailyWeatherItem
import com.example.weathermobileapp.presentation.components.items.TitleDayOfWeekItem
import com.example.weathermobileapp.presentation.widgets.ErrorMessageScreen
import com.example.weathermobileapp.presentation.widgets.NextDaysForecastShimmer
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding

@Composable
fun NextDaysForecastScreen(
    modifier: Modifier = Modifier,
    forecastVM: ForecastViewModel = hiltViewModel(),
) {
    var dayOfWeek by remember { mutableStateOf("") }
    val state by forecastVM.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        forecastVM.getWeatherForecastData()
    }

    if (state.isLoading) {
        NextDaysForecastShimmer(
            modifier = modifier
        )
    }

    state.forecast?.nextDayWeather?.let { nextDayWeather ->
        Column(
            modifier = modifier
                .background(BackGroundColor)
                .fillMaxSize()
                .padding(ScreenPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            nextDayWeather.forEach { forecast ->
                if (forecast.day != dayOfWeek) {
                    getDayOfWeek[forecast.day]?.let { day ->
                        TitleDayOfWeekItem(day)
                    }
                    dayOfWeek = forecast.day
                }
                DailyWeatherItem(forecast)
            }
        }
    }

    if (!state.error.isNullOrEmpty()) {
        ErrorMessageScreen(
            modifier = modifier,
            errorData = ErrorMock
        )
    }
}
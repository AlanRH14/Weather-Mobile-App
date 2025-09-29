package com.example.weathermobileapp.presentation.screens.next_days_forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.ErrorMock
import com.example.weathermobileapp.data.mappers.DayOfWeekMapper.getDayOfWeek
import com.example.weathermobileapp.presentation.components.items.DailyWeatherItem
import com.example.weathermobileapp.presentation.components.items.TitleDayOfWeekItem
import com.example.weathermobileapp.presentation.screens.error.ErrorMessageScreen
import com.example.weathermobileapp.presentation.widgets.shimmers.NextDaysForecastShimmer
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun NextDaysForecastScreen(
    modifier: Modifier = Modifier,
    forecastVM: ForecastViewModel = koinViewModel(),
) {
    val state by forecastVM.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        forecastVM.onEvent(NextDaysForecastUIEvent.OnGetWeatherForecastData)
    }

    if (state.isLoading) {
        NextDaysForecastShimmer(
            modifier = modifier
        )
    }

    state.forecast?.nextDayWeather?.let { nextDayWeather ->
        LazyColumn(
            modifier = modifier
                .background(BackGroundColor)
                .fillMaxSize()
                .padding(ScreenPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(items = nextDayWeather) { forecast ->
                println("LordMiau Day: ${forecast.day}")
                if (forecast.day != "") {
                    println("LordMiau Day2: ${forecast.day}")
                    getDayOfWeek[forecast.day]?.let { day ->
                        TitleDayOfWeekItem(day)
                    }
                    //dayOfWeek = forecast.day
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
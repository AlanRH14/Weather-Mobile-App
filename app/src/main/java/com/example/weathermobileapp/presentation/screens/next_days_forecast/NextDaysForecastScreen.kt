package com.example.weathermobileapp.presentation.screens.next_days_forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.ErrorMock
import com.example.weathermobileapp.data.mappers.DayOfWeekMapper.getDayOfWeek
import com.example.weathermobileapp.presentation.components.items.DailyWeatherItem
import com.example.weathermobileapp.presentation.components.items.TitleDayOfWeekItem
import com.example.weathermobileapp.presentation.screens.error.ErrorMessageScreen
import com.example.weathermobileapp.presentation.screens.next_days_forecast.mvi.NextDaysForecastEffect
import com.example.weathermobileapp.presentation.screens.next_days_forecast.mvi.NextDaysForecastUIEvent
import com.example.weathermobileapp.presentation.widgets.shimmers.NextDaysForecastShimmer
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding
import com.example.weathermobileapp.ui.theme.MediumPadding
import com.example.weathermobileapp.ui.theme.SmallPadding
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextDaysForecastScreen(
    modifier: Modifier = Modifier,
    forecastVM: ForecastViewModel = koinViewModel(),
    navController: NavHostController
) {
    var dayOfWeek by remember { mutableStateOf("") }
    val state by forecastVM.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        forecastVM.onEvent(NextDaysForecastUIEvent.OnGetWeatherForecastData)
        forecastVM.effect.collectLatest { effect ->
            when (effect) {
                is NextDaysForecastEffect.NavigateToBack -> navController.popBackStack()
            }
        }
    }

    if (state.isLoading) {
        NextDaysForecastShimmer(
            modifier = modifier
        )
    }

    Scaffold(
        modifier = Modifier
            .background(BackGroundColor)
            .fillMaxSize(),
        contentColor = Color.Transparent,
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = { forecastVM.onEvent(event = NextDaysForecastUIEvent.OnNavigateToBack) }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
    ) { innerPadding ->
        state.forecast?.nextDayWeather?.let { nextDayWeather ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = MediumPadding)
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
    }

    if (!state.error.isNullOrEmpty()) {
        ErrorMessageScreen(
            modifier = modifier,
            errorData = ErrorMock
        )
    }
}
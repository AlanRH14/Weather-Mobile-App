package com.example.weathermobileapp.presentation.screens.weather

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel
import java.util.jar.Manifest

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    weatherVM: WeatherViewModel = koinViewModel(),
    navController: NavController,
) {
    val weatherData by weatherVM.state.collectAsStateWithLifecycle()
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineLocationGranted = permissions[ACCESS_FINE_LOCATION] ?: false
        val coarseLocationGranted = permissions[ACCESS_COARSE_LOCATION] ?: false

        if (fineLocationGranted && coarseLocationGranted) {
            weatherVM.onEvent(WeatherUIEvent.OnGetWeather)
            weatherVM.onEvent(WeatherUIEvent.OnGetWeatherForecast)
        }
    }

    LaunchedEffect(key1 = true) {
        permissionLauncher.launch(
            arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)
        )
        weatherVM.effect.collectLatest { effect ->
            when (effect) {
                is WeatherEffect.NavigateToNextDaysForecast -> {
                    navController.navigate(Screen.NextDaysForecast.route)
                }
            }
        }
    }

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

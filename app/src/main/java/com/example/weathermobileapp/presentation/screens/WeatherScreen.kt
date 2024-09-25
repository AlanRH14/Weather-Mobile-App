package com.example.weathermobileapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weathermobileapp.R
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.domain.models.WeatherInfoModel
import com.example.weathermobileapp.presentation.widgets.DailyWeatherForecast
import com.example.weathermobileapp.presentation.widgets.WeatherHeader
import com.example.weathermobileapp.presentation.widgets.HourlyWeatherForecast
import com.example.weathermobileapp.presentation.widgets.WeatherScreenShimmer
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding
import com.example.weathermobileapp.ui.theme.VeryLargePadding
import com.example.weathermobileapp.ui.theme.WeatherTodayTitle

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    weatherVM: WeatherViewModel = hiltViewModel()
) {
    val weatherData by weatherVM.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .background(BackGroundColor)
            .padding(ScreenPadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if (weatherData.isLoading) {
            WeatherScreenShimmer(
                modifier = Modifier
                    .weight(1F)
            )
        }

        if (weatherData.weatherData != null) {
            WeatherHeader(
                image = weatherData.weatherData?.image ?: R.drawable.ic_couple,
                info = weatherData.weatherData?.info ?: WeatherInfoModel(),
                moreInfo = weatherData.weatherData?.moreInfo ?: emptyList()
            )

            HourlyWeatherForecast(WeatherData.hourlyWeather ?: emptyList())

            DailyWeatherForecast()
        }

        if (!weatherData.error.isNullOrEmpty()){
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(VeryLargePadding),
                text = "Not Data ${weatherData.error}",
                style = WeatherTodayTitle,
            )
        }
    }
}

@Preview
@Composable
internal fun PreviewP() {
    Column(
        modifier = Modifier
            .background(BackGroundColor)
            .padding(ScreenPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        WeatherHeader(
            image = WeatherData.image ?: R.drawable.ic_couple,
            info = WeatherData.info ?: WeatherInfoModel(),
            moreInfo = WeatherData.moreInfo ?: emptyList()
        )

        HourlyWeatherForecast(WeatherData.hourlyWeather ?: emptyList())

        DailyWeatherForecast()
    }
}

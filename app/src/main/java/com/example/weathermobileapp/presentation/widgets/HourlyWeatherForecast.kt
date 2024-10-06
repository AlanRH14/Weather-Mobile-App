package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.ForecastWeather
import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import com.example.weathermobileapp.presentation.components.items.HourlyWeatherItem
import com.example.weathermobileapp.ui.theme.GenericPadding.TodayPadding
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.VerySmallPadding
import com.example.weathermobileapp.ui.theme.WeatherTodayTitle

@Composable
fun HourlyWeatherForecast(
    hourlyWeathers: List<HourlyWeatherModel>,
) {
    Column(
        modifier = Modifier
            .padding(SmallPadding)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(TodayPadding),
            text = stringResource(R.string.weather_today_title),
            style = WeatherTodayTitle,
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(VerySmallPadding),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(hourlyWeathers) { hourlyWeather ->
                HourlyWeatherItem(hourlyWeather)
            }
        }
    }
}


@Preview
@Composable
internal fun WeatherInfoTodayPreview() {
    HourlyWeatherForecast(
        hourlyWeathers = ForecastWeather
    )
}
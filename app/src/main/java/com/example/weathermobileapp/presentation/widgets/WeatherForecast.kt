package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R
import com.example.weathermobileapp.ui.theme.GenericPadding.TodayPadding
import com.example.weathermobileapp.ui.theme.RowPadding
import com.example.weathermobileapp.ui.theme.WeatherTodayTitle

@Composable
fun WeatherForecast() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(TodayPadding),
        text = stringResource(R.string.weather_today_title),
        style = WeatherTodayTitle,
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = RowPadding),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {

    }
}


@Preview
@Composable
internal fun WeatherInfoTodayPreview() {
    WeatherForecast()
}
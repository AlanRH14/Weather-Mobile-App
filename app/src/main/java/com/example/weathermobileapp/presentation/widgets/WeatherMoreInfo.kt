package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weathermobileapp.domain.models.WeatherInfoModel
import com.example.weathermobileapp.ui.theme.LargePadding
import com.example.weathermobileapp.ui.theme.MediumPadding
import com.example.weathermobileapp.ui.theme.WeatherDegreesStyle
import com.example.weathermobileapp.ui.theme.WeatherDescription
import com.example.weathermobileapp.ui.theme.WeatherLocationStyle

@Composable
fun WeatherMoreInfo(
    info: WeatherInfoModel,
) {
    Column(
        modifier = Modifier
            .padding(top = LargePadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = info.degree ?: "N/A",
            style = WeatherDegreesStyle
        )

        Text(
            modifier = Modifier
                .padding(top = MediumPadding),
            text = info.location ?: "N/A",
            style = WeatherLocationStyle
        )

        Text(
            modifier = Modifier
                .padding(vertical = LargePadding),
            text = info.description ?: "",
            style = WeatherDescription,
        )
    }
}
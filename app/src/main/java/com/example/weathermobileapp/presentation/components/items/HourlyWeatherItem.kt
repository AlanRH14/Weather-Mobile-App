package com.example.weathermobileapp.presentation.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R
import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import com.example.weathermobileapp.ui.theme.HourlyWeatherHour
import com.example.weathermobileapp.ui.theme.HourlyWeatherTemp
import com.example.weathermobileapp.ui.theme.MediumPadding
import com.example.weathermobileapp.ui.theme.Purple
import com.example.weathermobileapp.ui.theme.Shapes

@Composable
fun HourlyWeatherItem(
    hourlyWeather: HourlyWeatherModel
) {
    Card(
        modifier = Modifier
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Purple
        ),
        shape = Shapes.small
    ) {
        Column(
            modifier = Modifier
                .padding(MediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = hourlyWeather.hour ?: "",
                style = HourlyWeatherHour
            )

            Image(
                modifier = Modifier
                    .size(45.dp),
                painter = painterResource(id = hourlyWeather.image ?: R.drawable.ic_rainythunder),
                contentDescription = "Image Hourly Weather",
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = hourlyWeather.degrees ?: "",
                style = HourlyWeatherTemp
            )
        }
    }
}
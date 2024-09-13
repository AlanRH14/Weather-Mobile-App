package com.example.weathermobileapp.presentation.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R

@Composable
fun WeatherHeaderImage(
    @DrawableRes image: Int,
) {
    Image(
        modifier = Modifier
            .width(200.dp),
        painter = painterResource(id = image),
        contentDescription = stringResource(
            id = R.string.weather_header_image_description
        )
    )
}
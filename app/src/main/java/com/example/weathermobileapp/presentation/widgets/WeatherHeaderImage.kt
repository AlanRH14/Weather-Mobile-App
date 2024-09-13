package com.example.weathermobileapp.presentation.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.weathermobileapp.R

@Composable
fun WeatherHeaderImage(
    modifier: Modifier,
    @DrawableRes image: Int,
) {
    Image(
        modifier = modifier
            .fillMaxSize(),
        painter = painterResource(id = image),
        contentDescription = stringResource(
            id = R.string.weather_header_image_description
        )
    )
}
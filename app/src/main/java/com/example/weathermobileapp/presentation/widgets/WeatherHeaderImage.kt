package com.example.weathermobileapp.presentation.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.WeatherData
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.WeatherTitleHeader

@Composable
fun WeatherHeaderImage(
    @DrawableRes image: Int,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .padding(top = SmallPadding)
                .fillMaxWidth(),
            text = "Mostly Cloundy",
            style = WeatherTitleHeader,
        )

        Image(
            modifier = Modifier
                .width(150.dp)
                .padding(vertical = SmallPadding),
            painter = painterResource(id = image),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(
                id = R.string.weather_header_image_description
            ),
        )
    }
}

@Preview
@Composable
internal fun WeatherHeaderImagePreview() {
    WeatherHeaderImage(WeatherData.image ?: R.drawable.ic_heavysnow)
}
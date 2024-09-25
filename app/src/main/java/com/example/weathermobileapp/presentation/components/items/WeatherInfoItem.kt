package com.example.weathermobileapp.presentation.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R
import com.example.weathermobileapp.domain.models.WeatherMoreInfoModel
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.WeatherInfoSubtitle
import com.example.weathermobileapp.ui.theme.WeatherInfoTitle

@Composable
fun WeatherInfoItem(
    weatherInfo: WeatherMoreInfoModel,
) {
    Column(
        modifier = Modifier
            .padding(SmallPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .padding(end = SmallPadding)
                .width(34.dp),
            painter = painterResource(id = weatherInfo.iconRes),
            contentDescription = stringResource(
                id = R.string.weather_info_image_description
            )
        )

        Text(
            text = weatherInfo.title,
            style = WeatherInfoTitle,
        )

        Text(
            text = weatherInfo.subtitle,
            style = WeatherInfoSubtitle,
        )
    }
}
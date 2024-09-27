package com.example.weathermobileapp.presentation.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.R
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData
import com.example.weathermobileapp.domain.models.WeatherDataModel
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.VerySmallPadding
import com.example.weathermobileapp.ui.theme.WeatherInfoSubtitle
import com.example.weathermobileapp.ui.theme.WeatherInfoTitle

@Composable
fun WeatherInfoItem(
    weatherInfo: WeatherDataModel,
) {
    Column(
        modifier = Modifier
            .padding(SmallPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .padding(VerySmallPadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .width(14.dp),
                imageVector = ImageVector.vectorResource(id = weatherInfo.iconRes),
                tint = Color.White,
                contentDescription = stringResource(
                    id = R.string.weather_info_image_description
                )
            )

            Text(
                modifier = Modifier
                    .padding(VerySmallPadding),
                text = weatherInfo.title,
                style = WeatherInfoTitle,
            )
        }


        Text(
            modifier = Modifier
                .padding(VerySmallPadding),
            text = weatherInfo.subtitle,
            style = WeatherInfoSubtitle,
        )
    }
}

@Preview
@Composable
fun WeatherInfoItemPreview() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeatherMockData.WeatherData.weatherData.forEach {
            WeatherInfoItem(it)
        }
    }

}
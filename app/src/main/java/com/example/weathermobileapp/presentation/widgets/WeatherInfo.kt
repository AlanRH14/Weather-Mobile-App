package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.weathermobileapp.domain.models.WeatherMoreInfoModel
import com.example.weathermobileapp.presentation.components.WeatherInfoItem
import com.example.weathermobileapp.ui.theme.LightGray
import com.example.weathermobileapp.ui.theme.MediumPadding
import com.example.weathermobileapp.ui.theme.Shapes
import com.example.weathermobileapp.ui.theme.VeryLightGray

@Composable
fun WeatherInfo(
    moreInfoList: List<WeatherMoreInfoModel>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shapes.extraSmall)
            .background(VeryLightGray)
    ) {
        moreInfoList.chunked(2).forEachIndexed { index, rowData ->
            Row(
                modifier = Modifier
                    .padding(MediumPadding)
            ) {
                rowData.forEach { weatherInfo ->
                    WeatherInfoItem(
                        modifier = Modifier
                            .weight(1F),
                        weatherInfo = weatherInfo,
                    )
                }

            }

            if (index < moreInfoList.chunked(2).size - 1) {
                HorizontalDivider(
                    color = LightGray
                )
            }
        }
    }
}
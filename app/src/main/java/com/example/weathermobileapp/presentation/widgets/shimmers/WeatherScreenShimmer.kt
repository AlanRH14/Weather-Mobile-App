package com.example.weathermobileapp.presentation.widgets.shimmers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.presentation.components.shimmerEffect
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding
import com.example.weathermobileapp.ui.theme.Shapes
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.VeryLargePadding

@Composable
fun WeatherScreenShimmer(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(BackGroundColor)
            .fillMaxSize()
            .padding(ScreenPadding),
    ) {

        Box(
            modifier = Modifier
                .height(455.dp)
                .fillMaxWidth()
                .padding(SmallPadding)
                .clip(Shapes.medium)
                .shimmerEffect()
        )

        Box(
            modifier = Modifier
                .height(65.dp)
                .fillMaxWidth()
                .padding(SmallPadding)
                .shimmerEffect()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SmallPadding),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(4) {
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1F)
                        .clip(Shapes.small)
                        .shimmerEffect()
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(SmallPadding),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .weight(2F)
                    .shimmerEffect(),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
                    .height(50.dp)
                    .padding(end = VeryLargePadding)
                    .shimmerEffect(),
            )
        }

        repeat(6) {
            Box(
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth()
                    .padding(SmallPadding)
                    .shimmerEffect(),
            )
        }
    }
}

@Preview
@Composable
internal fun WeatherScreenShimmerPreview() {
    WeatherScreenShimmer()
}
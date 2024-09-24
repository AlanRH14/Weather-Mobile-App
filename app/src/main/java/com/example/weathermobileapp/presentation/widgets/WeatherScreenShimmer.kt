package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.presentation.components.shimmerEffect
import com.example.weathermobileapp.ui.theme.LargePadding
import com.example.weathermobileapp.ui.theme.LightGray
import com.example.weathermobileapp.ui.theme.MediumPadding
import com.example.weathermobileapp.ui.theme.Shapes
import com.example.weathermobileapp.ui.theme.VeryLightGray

@Composable
fun WeatherScreenShimmer(
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .shimmerEffect()
    )

    Column(
        modifier = Modifier
            .padding(top = LargePadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .padding(top = MediumPadding)
                .height(20.dp)
                .fillMaxWidth()
                .shimmerEffect()
        )

        Box(
            modifier = Modifier
                .padding(vertical = LargePadding)
                .height(16.dp)
                .fillMaxWidth()
                .shimmerEffect()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shapes.extraSmall)
            .background(VeryLightGray)
    ) {

        Row(
            modifier = Modifier
                .padding(MediumPadding),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {

            Box(
                modifier = Modifier
                    .weight(1F)
                    .height(40.dp)
                    .shimmerEffect(),
            )

            Box(
                modifier = Modifier
                    .weight(1F)
                    .height(40.dp)
                    .shimmerEffect(),
            )
        }

        HorizontalDivider(
            color = LightGray
        )

        Row(
            modifier = Modifier
                .padding(MediumPadding),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {

            Box(
                modifier = Modifier
                    .weight(1F)
                    .height(40.dp)
                    .shimmerEffect(),
            )

            Box(
                modifier = Modifier
                    .weight(1F)
                    .height(40.dp)
                    .shimmerEffect(),
            )
        }
    }
}
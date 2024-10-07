package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathermobileapp.presentation.components.shimmerEffect
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding
import com.example.weathermobileapp.ui.theme.VerySmallPadding

@Composable
fun NextDaysForecastShimmer(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(BackGroundColor)
            .fillMaxSize()
            .padding(ScreenPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(45.dp)
                .shimmerEffect()
        )

        repeat(8) {
            Box(
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth()
                    .padding(VerySmallPadding)
                    .shimmerEffect()
            )
        }

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(45.dp)
                .shimmerEffect()
        )

        repeat(8) {
            Box(
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth()
                    .padding(VerySmallPadding)
                    .shimmerEffect()
            )
        }
    }
}
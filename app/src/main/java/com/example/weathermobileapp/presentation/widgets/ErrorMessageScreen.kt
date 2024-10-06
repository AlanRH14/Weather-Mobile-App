package com.example.weathermobileapp.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermobileapp.data.local.mockdata.WeatherMockData.ErrorMock
import com.example.weathermobileapp.domain.models.ErrorModel
import com.example.weathermobileapp.ui.theme.BackGroundColor
import com.example.weathermobileapp.ui.theme.GenericPadding.ScreenPadding
import com.example.weathermobileapp.ui.theme.SmallPadding
import com.example.weathermobileapp.ui.theme.WeatherTodayTitle

@Composable
fun ErrorMessageScreen(
    modifier: Modifier = Modifier,
    errorData: ErrorModel,
) {
    Column(
        modifier = modifier
            .background(BackGroundColor)
            .fillMaxSize()
            .padding(ScreenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier
                .weight(1F),
            painter = painterResource(errorData.image),
            contentDescription = "Error Image",
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SmallPadding),
            text = errorData.title,
            style = WeatherTodayTitle,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SmallPadding),
            text = errorData.message,
            style = WeatherTodayTitle,
        )
    }
}

@Preview
@Composable
fun MessageErrorPreview() {
    ErrorMessageScreen(
        errorData = ErrorMock
    )
}
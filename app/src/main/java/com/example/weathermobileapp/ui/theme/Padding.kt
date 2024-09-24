package com.example.weathermobileapp.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

val SmallPadding = 8.dp
val MediumPadding = 16.dp
val RowPadding = 20.dp
val LargePadding = 24.dp

object GenericPadding {
    val ScreenPadding = PaddingValues(
        vertical = LargePadding,
        horizontal = MediumPadding,
    )

    val TodayPadding = PaddingValues(
        vertical = SmallPadding,
        horizontal = LargePadding,
    )
}

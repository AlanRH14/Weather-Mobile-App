package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes
import com.example.weathermobileapp.R

sealed class WeatherType(
    @DrawableRes icon: Int,
) {
    // Check the codes to see which icon applies.
    data object Thunderstorm : WeatherType(
        icon = R.drawable.ic_thunder
    )

    data object HeavyThunderstorm : WeatherType(
        icon = R.drawable.ic_rainythunder
    )

    data object Drizzle : WeatherType(
        icon = R.drawable.ic_rainshower
    )

    data object LightRain : WeatherType(
        icon = R.drawable.ic_sunnyrainy
    )

    data object Rain : WeatherType(
        icon = R.drawable.ic_rainy
    )

    data object FreezingRain : WeatherType(
        icon = R.drawable.ic_snowyrainy
    )

    data object Snow : WeatherType(
        icon = R.drawable.ic_snowy
    )

    // Heavy shower snow exception for include icon
    data object HeavySnow : WeatherType(
        icon = R.drawable.ic_heavysnow
    )

    data object Atmosphere : WeatherType(
        icon = R.drawable.ic_pressure
    )

    data object SunnyClear : WeatherType(
        icon = R.drawable.ic_sunny
    )

    // Find Night Icon
    data object ClearNight : WeatherType(
        icon = R.drawable.ic_sunny
    )

    data object FewClouds : WeatherType(
        icon = R.drawable.ic_sunnycloudy
    )

    data object ScatteredClouds : WeatherType(
        icon = R.drawable.ic_cloudy
    )

    // Overcast & Broken Clouds
    data object OvercastClouds : WeatherType(
        icon = R.drawable.ic_very_cloudy
    )
}

val iconForId = hashMapOf(
    "" to R.drawable.ic_rainy
)
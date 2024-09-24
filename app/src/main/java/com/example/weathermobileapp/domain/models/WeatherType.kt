package com.example.weathermobileapp.domain.models

import androidx.annotation.DrawableRes
import com.example.weathermobileapp.R

sealed class WeatherType(
    @DrawableRes val icon: Int,
) {
    // Check the codes to see which icon applies.
    data object Thunderstorm : WeatherType(
        icon = R.drawable.ic_thunder
    )

    data object RainThunderstorm : WeatherType(
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

    data object OvercastClouds : WeatherType(
        icon = R.drawable.ic_very_cloudy
    )

    companion object {
        fun fromId(code: Int?): WeatherType {
            return when(code) {
                in 200 .. 202 -> RainThunderstorm

                in 210 .. 232 -> Thunderstorm

                in 300 .. 321 -> Drizzle

                in 500 .. 531 -> Rain

                in 600 .. 622 -> Snow

                in 701 .. 781 -> Atmosphere

                800 -> SunnyClear

                801 -> FewClouds

                802 -> ScatteredClouds

                in 803 .. 804 -> OvercastClouds

                else -> SunnyClear
            }
        }
    }
}

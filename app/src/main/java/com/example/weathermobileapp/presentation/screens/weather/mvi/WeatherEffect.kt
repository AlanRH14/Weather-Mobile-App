package com.example.weathermobileapp.presentation.screens.weather.mvi

sealed interface WeatherEffect {
    data object NavigateToNextDaysForecast : WeatherEffect
}
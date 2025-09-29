package com.example.weathermobileapp.presentation.screens.weather

sealed interface WeatherEffect {
    data object NavigateToNextDaysForecast : WeatherEffect
}
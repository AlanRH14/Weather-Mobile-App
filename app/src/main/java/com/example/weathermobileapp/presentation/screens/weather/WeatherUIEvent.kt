package com.example.weathermobileapp.presentation.screens.weather

sealed interface WeatherUIEvent {
    data object OnGetWeather : WeatherUIEvent
    data object OnGetWeatherForecast : WeatherUIEvent
    data object OnClickedNavigateToNextDaysForecast : WeatherUIEvent
}
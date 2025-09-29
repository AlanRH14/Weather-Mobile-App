package com.example.weathermobileapp.presentation.screens.weather

sealed interface WeatherUIEvent {
    data object OnGetWeather : WeatherUIEvent
}
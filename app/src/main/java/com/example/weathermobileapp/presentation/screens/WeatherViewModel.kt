package com.example.weathermobileapp.presentation.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class WeatherViewModel: ViewModel() {

    init {
        getWeatherData()
    }

    private fun getWeatherData() {

    }
}
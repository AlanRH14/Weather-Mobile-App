package com.example.weathermobileapp.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {

    init {
        getWeatherData()
    }

    fun getWeatherData() {
        viewModelScope.launch {
            repository.getWeatherData(lat = 19.598996, lon = 99.228757).collect { weatherRes ->
                when (weatherRes) {
                    is ResultApi.Loading -> Unit

                    is ResultApi.Success -> {
                        Log.d("LordMiau", "Res: ${weatherRes.data}")
                    }

                    is ResultApi.Error -> {
                        Log.d("LordMiau", "Error: ${weatherRes.message}")
                    }
                }
            }
        }
    }
}
package com.example.weathermobileapp.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.location.LocationTracker
import com.example.weathermobileapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> get() = _state

    fun getWeatherData() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            locationTracker.getCurrentLocation()?.let { location ->
                repository.getWeatherData(lat = location.latitude, location.longitude)
                    .collect { weatherRes ->
                        when (weatherRes) {
                            is ResultApi.Loading -> {
                                _state.value = _state.value.copy(isLoading = true)
                            }

                            is ResultApi.Success -> {
                                _state.value = _state.value.copy(
                                    isLoading = false,
                                    weatherData = weatherRes.data
                                )
                            }

                            is ResultApi.Error -> {
                                _state.value = _state.value.copy(
                                    isLoading = false,
                                    error = weatherRes.message
                                )
                            }
                        }
                    }
            }
        }
    }
}
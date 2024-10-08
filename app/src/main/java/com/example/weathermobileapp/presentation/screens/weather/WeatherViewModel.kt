package com.example.weathermobileapp.presentation.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.location.LocationTracker
import com.example.weathermobileapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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
                                _state.update { it.copy(isLoading = true) }
                            }

                            is ResultApi.Success -> {
                                _state.update {
                                    it.copy(
                                        isLoading = false,
                                        weatherData = weatherRes.data
                                    )
                                }
                            }

                            is ResultApi.Error -> {
                                _state.update {
                                    it.copy(
                                        isLoading = false,
                                        error = weatherRes.message
                                    )
                                }
                            }
                        }
                    }
            } ?: let {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = "Not Location active"
                    )
                }
            }
        }
    }

    fun getWeatherForecastData() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                repository.getWeatherForecastData(lat = location.latitude, lon = location.longitude)
                    .collect { forecastData ->
                        when (forecastData) {
                            is ResultApi.Loading -> {
                                _state.update { it.copy(isLoading = true) }
                            }

                            is ResultApi.Success -> {
                                _state.update {
                                    it.copy(
                                        isLoading = false,
                                        forecast = forecastData.data
                                    )
                                }
                            }

                            is ResultApi.Error -> {
                                _state.update {
                                    it.copy(
                                        isLoading = false,
                                        error = forecastData.message
                                    )
                                }
                            }
                        }
                    }
            }
        }
    }
}
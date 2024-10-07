package com.example.weathermobileapp.presentation.screens.next_days_forecast

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
class ForecastViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {

    private val _state = MutableStateFlow(NextDaysForecastState())
    val state: StateFlow<NextDaysForecastState> get() = _state

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
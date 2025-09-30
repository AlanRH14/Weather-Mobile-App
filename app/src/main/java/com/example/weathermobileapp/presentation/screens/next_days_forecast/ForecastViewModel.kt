package com.example.weathermobileapp.presentation.screens.next_days_forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.location.LocationTracker
import com.example.weathermobileapp.domain.repository.WeatherRepository
import com.example.weathermobileapp.presentation.screens.next_days_forecast.mvi.NextDaysForecastEffect
import com.example.weathermobileapp.presentation.screens.next_days_forecast.mvi.NextDaysForecastState
import com.example.weathermobileapp.presentation.screens.next_days_forecast.mvi.NextDaysForecastUIEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ForecastViewModel(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {
    private val _state = MutableStateFlow(NextDaysForecastState())
    val state: StateFlow<NextDaysForecastState> get() = _state

    private val _effect = MutableSharedFlow<NextDaysForecastEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: NextDaysForecastUIEvent) {
        when (event) {
            is NextDaysForecastUIEvent.OnGetWeatherForecastData -> getWeatherForecastData()
            is NextDaysForecastUIEvent.OnDayOfWeekUpdate -> dayOfWeekUpdate(dayOfWeek = event.dayOfWeek)
            is NextDaysForecastUIEvent.OnNavigateToBack -> navigateToBack()
        }
    }

    private fun getWeatherForecastData() {
        viewModelScope.launch(Dispatchers.IO) {
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

    private fun dayOfWeekUpdate(dayOfWeek: String) {
        _state.update { it.copy(dayOfWeek = dayOfWeek) }
    }

    private fun navigateToBack() {
        viewModelScope.launch {
            _effect.emit(NextDaysForecastEffect.NavigateToBack)
        }
    }
}
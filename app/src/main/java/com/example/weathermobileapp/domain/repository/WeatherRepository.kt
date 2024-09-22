package com.example.weathermobileapp.domain.repository

import com.example.weathermobileapp.data.remote.dto.WeatherDto
import com.example.weathermobileapp.domain.ResultApi
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double, lon: Double): Flow<ResultApi<WeatherDto>>
}
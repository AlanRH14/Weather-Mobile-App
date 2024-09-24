package com.example.weathermobileapp.domain.repository

import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.models.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double, lon: Double): Flow<ResultApi<WeatherModel>>
}
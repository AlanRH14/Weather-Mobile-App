package com.example.weathermobileapp.data.repository

import com.example.weathermobileapp.data.mappers.toWeatherModel
import com.example.weathermobileapp.data.remote.api.ApiConfig
import com.example.weathermobileapp.data.remote.api.WeatherApi
import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.models.WeatherModel
import com.example.weathermobileapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, lon: Double): Flow<ResultApi<WeatherModel>> =
        flow {
            emit(ResultApi.Loading)
            val weatherData = api.getCurrentWeatherData(lat = lat, lon = lon, ApiConfig.API_KEY)
            emit(ResultApi.Success(data = weatherData.toWeatherModel()))
            /*try {
                val weatherData = api.getCurrentWeatherData(lat = lat, lon = lon, ApiConfig.API_KEY)
                emit(ResultApi.Success(data = weatherData.toWeatherModel()))
            } catch (e: Exception) {
                emit(
                    ResultApi.Error(
                        message = "Error: ${e.message}"
                    )
                )
            }*/
        }
}





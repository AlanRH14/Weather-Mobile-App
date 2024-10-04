package com.example.weathermobileapp.data.repository

import com.example.weathermobileapp.data.mappers.toForecastWeathers
import com.example.weathermobileapp.data.mappers.toWeatherModel
import com.example.weathermobileapp.data.remote.api.ApiConfig.API_KEY
import com.example.weathermobileapp.data.remote.api.WeatherApi
import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.models.WeatherForecast
import com.example.weathermobileapp.domain.models.WeatherModel
import com.example.weathermobileapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, lon: Double): Flow<ResultApi<WeatherModel>> =
        flow {
            emit(ResultApi.Loading)
            try {
                val weatherData =
                    api.getWeatherCurrentData(lat = lat, lon = lon, id = API_KEY)
                emit(ResultApi.Success(data = weatherData.toWeatherModel()))
            } catch (e: Exception) {
                emit(
                    ResultApi.Error(
                        message = "Error: ${e.message}"
                    )
                )
            }
        }

    override suspend fun getWeatherForecastData(
        lat: Double,
        lon: Double
    ): Flow<ResultApi<WeatherForecast>> =
        flow {
            emit(ResultApi.Loading)
            try {
                val weatherForecastData = api.getWeatherForecastData(lat = lat, lon = lon, id = API_KEY)
                emit(ResultApi.Success(weatherForecastData.forecasts.toForecastWeathers()))
            } catch (e: Exception) {
                emit(ResultApi.Error(
                    message = "Error: ${e.message}"
                ))
            }
        }
}

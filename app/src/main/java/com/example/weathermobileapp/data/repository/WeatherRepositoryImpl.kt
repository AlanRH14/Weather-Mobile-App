package com.example.weathermobileapp.data.repository

import android.util.Log
import com.example.weathermobileapp.common.ApiMapper
import com.example.weathermobileapp.data.remote.api.ApiConfig.API_KEY
import com.example.weathermobileapp.data.remote.api.WeatherApi
import com.example.weathermobileapp.data.remote.dto.current.WeatherDto
import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.ResultApi
import com.example.weathermobileapp.domain.models.WeatherForecast
import com.example.weathermobileapp.domain.models.WeatherModel
import com.example.weathermobileapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(
    private val api: WeatherApi,
    private val apiWeatherMapper: ApiMapper<WeatherDto, WeatherModel>,
    private val apiForecastMapper: ApiMapper<List<Forecast?>?, WeatherForecast>
) : WeatherRepository {

    override fun getWeatherData(lat: Double, lon: Double): Flow<ResultApi<WeatherModel>> =
        flow {
            emit(ResultApi.Loading)
            try {
                val weatherData =
                    api.getWeatherCurrentData(lat = lat, lon = lon, id = API_KEY)
                emit(ResultApi.Success(data = apiWeatherMapper.mapToDomain(dto = weatherData)))
            } catch (e: Exception) {
                emit(ResultApi.Error(message = "Error: ${e.message}"))
            }
        }

    override fun getWeatherForecastData(
        lat: Double,
        lon: Double
    ): Flow<ResultApi<WeatherForecast>> =
        flow {
            emit(ResultApi.Loading)
            try {
                val weatherForecastData =
                    api.getWeatherForecastData(lat = lat, lon = lon, id = API_KEY)
                emit(ResultApi.Success(apiForecastMapper.mapToDomain(dto = weatherForecastData.forecasts)))
            } catch (e: Exception) {
                emit(ResultApi.Error(message = "Error: ${e.message}"))
            }
        }
}

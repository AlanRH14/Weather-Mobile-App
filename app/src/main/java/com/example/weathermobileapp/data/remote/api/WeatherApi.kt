package com.example.weathermobileapp.data.remote.api

import com.example.weathermobileapp.data.remote.api.ApiConfig.UNITS_DEFAULT
import com.example.weathermobileapp.data.remote.api.ApiConfig.WEATHER_CURRENT_URL
import com.example.weathermobileapp.data.remote.api.ApiConfig.WEATHER_FORECAST_URL
import com.example.weathermobileapp.data.remote.dto.current.WeatherDto
import com.example.weathermobileapp.data.remote.dto.forecast.ForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(WEATHER_CURRENT_URL)
    suspend fun getWeatherCurrentData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = UNITS_DEFAULT,
        @Query("appid") id: String
    ): WeatherDto

    @GET(WEATHER_FORECAST_URL)
    suspend fun getWeatherForecastData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") id: String
    ): ForecastDto
}
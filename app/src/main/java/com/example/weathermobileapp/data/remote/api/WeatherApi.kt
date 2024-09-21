package com.example.weathermobileapp.data.remote.api

import com.example.weathermobileapp.data.remote.api.ApiConfig.WEATHER_URL
import com.example.weathermobileapp.data.remote.dto.CurrentWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(WEATHER_URL)
    suspend fun getCurrentWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") id: String
    ): CurrentWeatherDto
}
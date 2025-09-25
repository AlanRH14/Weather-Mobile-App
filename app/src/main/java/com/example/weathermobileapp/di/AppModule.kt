package com.example.weathermobileapp.di

import android.app.Application
import com.example.weathermobileapp.data.remote.api.ApiConfig.BASE_URL
import com.example.weathermobileapp.data.remote.api.WeatherApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

object AppModule {

    fun providesWeatherApi(): WeatherApi {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .addConverterFactory(
                Json.asConverterFactory(contentType)
            )
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}
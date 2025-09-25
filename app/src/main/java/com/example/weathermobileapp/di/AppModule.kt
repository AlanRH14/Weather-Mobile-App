package com.example.weathermobileapp.di

import android.app.Application
import com.example.weathermobileapp.data.remote.api.ApiConfig.BASE_URL
import com.example.weathermobileapp.data.remote.api.WeatherApi
import com.example.weathermobileapp.presentation.screens.next_days_forecast.ForecastViewModel
import com.example.weathermobileapp.presentation.screens.weather.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ForecastViewModel(repository = get(), locationTracker = get()) }
    viewModel { WeatherViewModel(repository = get(), locationTracker = get()) }

    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}
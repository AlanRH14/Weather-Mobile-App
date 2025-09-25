package com.example.weathermobileapp.di

import com.example.weathermobileapp.presentation.screens.next_days_forecast.ForecastViewModel
import com.example.weathermobileapp.presentation.screens.weather.WeatherViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { WeatherViewModel(repository = get(), locationTracker = get()) }
    viewModel { ForecastViewModel(repository = get(), locationTracker = get()) }
}
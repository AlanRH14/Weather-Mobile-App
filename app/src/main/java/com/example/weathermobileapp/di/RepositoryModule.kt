package com.example.weathermobileapp.di

import com.example.weathermobileapp.data.repository.WeatherRepositoryImpl
import com.example.weathermobileapp.domain.repository.WeatherRepository

abstract class RepositoryModule {
    abstract fun bindWeatherRepository(
        repositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}
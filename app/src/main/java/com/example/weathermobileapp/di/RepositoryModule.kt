package com.example.weathermobileapp.di

import com.example.weathermobileapp.data.repository.WeatherRepositoryImpl
import com.example.weathermobileapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

abstract class RepositoryModule {
    abstract fun bindWeatherRepository(
        repositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}
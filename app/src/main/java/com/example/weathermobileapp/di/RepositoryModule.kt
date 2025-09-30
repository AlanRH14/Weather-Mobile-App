package com.example.weathermobileapp.di

import com.example.weathermobileapp.data.repository.WeatherRepositoryImpl
import com.example.weathermobileapp.domain.repository.WeatherRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> {
        WeatherRepositoryImpl(
            api = get(),
            apiWeatherMapper = get(named("DailyWeatherMapper")),
            apiForecastMapper = get(named("HourlyWeatherMapper"))
        )
    }
}
package com.example.weathermobileapp

import android.app.Application
import com.example.weathermobileapp.di.appModule
import com.example.weathermobileapp.di.locationModule
import com.example.weathermobileapp.di.networkModule
import com.example.weathermobileapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApplication)

            modules(
                networkModule,
                repositoryModule,
                locationModule,
                appModule,
            )
        }
    }
}
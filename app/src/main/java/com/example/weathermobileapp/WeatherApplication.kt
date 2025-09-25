package com.example.weathermobileapp

import android.app.Application
import com.example.weathermobileapp.di.networkModule
import org.koin.core.context.startKoin

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                networkModule,
            )
        }
    }
}
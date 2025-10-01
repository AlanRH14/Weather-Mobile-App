package com.example.weathermobileapp

import android.app.Application
import com.example.weathermobileapp.di.apiMapperModule
import com.example.weathermobileapp.di.appModule
import com.example.weathermobileapp.di.locationModule
import com.example.weathermobileapp.di.networkModule
import com.example.weathermobileapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApplication)
            androidLogger(Level.DEBUG)
            modules(
                apiMapperModule,
                networkModule,
                repositoryModule,
                locationModule,
                appModule,
            )
        }
    }
}
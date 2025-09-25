package com.example.weathermobileapp.di

import com.example.weathermobileapp.data.location.LocationTrackerImpl
import com.example.weathermobileapp.domain.location.LocationTracker
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val locationModule = module {

    abstract fun bindLocationTracker(defaultLocationTracker: LocationTrackerImpl): LocationTracker

    single<LocationTracker> {
        LocationTrackerImpl(
            locationClient = get(),
            application = androidApplication()
        )
    }
}
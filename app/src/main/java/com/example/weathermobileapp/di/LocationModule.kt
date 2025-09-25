package com.example.weathermobileapp.di

import com.example.weathermobileapp.data.location.LocationTrackerImpl
import com.example.weathermobileapp.domain.location.LocationTracker
import org.koin.dsl.module

val locationModule = module {

    abstract fun bindLocationTracker(defaultLocationTracker: LocationTrackerImpl): LocationTracker
}
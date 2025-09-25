package com.example.weathermobileapp.di

import com.example.weathermobileapp.data.location.LocationTrackerImpl
import com.example.weathermobileapp.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn

abstract class LocationModule {

    abstract fun bindLocationTracker(defaultLocationTracker: LocationTrackerImpl): LocationTracker
}
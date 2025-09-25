package com.example.weathermobileapp.di

import com.example.weathermobileapp.data.remote.api.ApiConfig.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {

        }
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client()
            .addConverterFactory()
            .build()
    }
}
package com.example.weathermobileapp.di

import com.example.weathermobileapp.common.ApiMapper
import com.example.weathermobileapp.data.mappers_impl.DailyWeatherMapperImpl
import com.example.weathermobileapp.data.mappers_impl.ForecastMapperImpl
import com.example.weathermobileapp.data.mappers_impl.HourlyWeatherMapperImpl
import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.DailyWeatherModel
import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import com.example.weathermobileapp.domain.models.WeatherForecast
import org.koin.dsl.module

val apiMapperModule = module {
    single<ApiMapper<List<Forecast?>?, List<DailyWeatherModel>>> {
        DailyWeatherMapperImpl()
    }

    single<ApiMapper<List<Forecast?>?, WeatherForecast>> {
        ForecastMapperImpl(
            apiDailyWeatherMapper = get(),
            apiHourlyWeathersMapper = get()
        )
    }

    single<ApiMapper<List<Forecast?>?, List<HourlyWeatherModel>>> {
        HourlyWeatherMapperImpl()
    }
}
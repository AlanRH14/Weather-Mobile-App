package com.example.weathermobileapp.di

import com.example.weathermobileapp.common.ApiMapper
import com.example.weathermobileapp.data.mappers_impl.DailyWeatherMapperImpl
import com.example.weathermobileapp.data.mappers_impl.ForecastMapperImpl
import com.example.weathermobileapp.data.mappers_impl.HourlyWeatherMapperImpl
import com.example.weathermobileapp.data.mappers_impl.WeatherMapperImpl
import com.example.weathermobileapp.data.remote.dto.current.WeatherDto
import com.example.weathermobileapp.data.remote.dto.forecast.Forecast
import com.example.weathermobileapp.domain.models.DailyWeatherModel
import com.example.weathermobileapp.domain.models.HourlyWeatherModel
import com.example.weathermobileapp.domain.models.WeatherForecast
import com.example.weathermobileapp.domain.models.WeatherModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val apiMapperModule = module {
    single<ApiMapper<List<Forecast?>?, List<DailyWeatherModel>>> {
        DailyWeatherMapperImpl()
    }

    single<ApiMapper<List<Forecast?>?, List<HourlyWeatherModel>>>(named("HourlyWeatherMapper")) {
        HourlyWeatherMapperImpl()
    }

    single<ApiMapper<WeatherDto, WeatherModel>>(named("WeatherMapper")) {
        WeatherMapperImpl()
    }

    single<ApiMapper<List<Forecast?>?, WeatherForecast>> {
        ForecastMapperImpl(
            apiDailyWeatherMapper = get(named("WeatherMapper")),
            apiHourlyWeathersMapper = get(named("HourlyWeatherMapper"))
        )
    }
}
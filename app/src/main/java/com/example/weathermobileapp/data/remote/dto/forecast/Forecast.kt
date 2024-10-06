package com.example.weathermobileapp.data.remote.dto.forecast

import com.example.weathermobileapp.data.remote.dto.Clouds
import com.example.weathermobileapp.data.remote.dto.Weather
import com.example.weathermobileapp.data.remote.dto.Wind
import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("main")
    val main: Main?,
    @SerializedName("weather")
    val weather: List<Weather?>?,
    @SerializedName("clouds")
    val clouds: Clouds?,
    @SerializedName("wind")
    val wind: Wind?,
    @SerializedName("visibility")
    val visibility: Int?,
    @SerializedName("pop")
    val pop: Double?,
    @SerializedName("rain")
    val rain: Rain?,
    @SerializedName("snow")
    val snow: Snow? = null,
    @SerializedName("sys")
    val sys: Sys?,
    @SerializedName("dt_txt")
    val dtTxt: String?,
)
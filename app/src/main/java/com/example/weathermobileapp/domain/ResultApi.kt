package com.example.weathermobileapp.domain

sealed class ResultApi<out T> {
    data object Loading: ResultApi<Nothing>()
    class Success<T>(val data: T?): ResultApi<T>()
    class Error(val message: String): ResultApi<Nothing>()
}
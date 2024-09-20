package com.example.weathermobileapp.domain

sealed class ResultApi<out T> {
    data object Loading: ResultApi<Nothing>()
    class Success<T>(data: T?): ResultApi<T>()
    class Error(message: String): ResultApi<Nothing>()
}
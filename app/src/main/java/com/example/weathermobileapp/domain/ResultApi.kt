package com.example.weathermobileapp.domain

sealed interface ResultApi<out T> {
    data object Loading: ResultApi<Nothing>
    data class Success<T>(val data: T?): ResultApi<T>
    data class Error<T>(val message: String): ResultApi<T>
}
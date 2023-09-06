package com.example.correncyconverterwithkoin.utils

sealed class Resourse<T>(data: T?, message: String? = null) {
    data class Success<T>(val data: T?) : Resourse<T>(data, null)
    data class Error<T>(val message: String?) : Resourse<T>(null, message)

}
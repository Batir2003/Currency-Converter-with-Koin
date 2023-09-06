package com.example.correncyconverterwithkoin.utils

import com.example.correncyconverterwithkoin.data.models.ExchangeResponse

sealed class ConvertEvent {
    data class Success(val result: ExchangeResponse) : ConvertEvent()
    data class Error(val errorMessage: String?) : ConvertEvent()
    object Loading : ConvertEvent()
    object Empty : ConvertEvent()
}
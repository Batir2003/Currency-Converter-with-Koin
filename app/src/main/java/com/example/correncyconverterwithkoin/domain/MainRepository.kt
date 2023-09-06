package com.example.correncyconverterwithkoin.domain

import com.example.correncyconverterwithkoin.data.models.ExchangeResponse
import com.example.correncyconverterwithkoin.utils.Resourse

interface MainRepository {

    suspend fun convertRate(
        from: String,
        to: String,
        amount: String
    ): Resourse<ExchangeResponse>
}
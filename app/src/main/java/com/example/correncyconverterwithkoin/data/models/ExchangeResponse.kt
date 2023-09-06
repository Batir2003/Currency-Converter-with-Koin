package com.example.correncyconverterwithkoin.data.models

data class ExchangeResponse(
    val date: String,
    val historical: String,
    val info: Info,
    val query: Query,
    val result: Double,
    val success: Boolean
)
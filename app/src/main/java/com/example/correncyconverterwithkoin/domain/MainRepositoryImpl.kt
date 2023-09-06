package com.example.correncyconverterwithkoin.domain

import com.example.correncyconverterwithkoin.data.models.ExchangeResponse
import com.example.correncyconverterwithkoin.data.network.ConverterApi
import com.example.correncyconverterwithkoin.utils.Resourse

class MainRepositoryImpl(private val api: ConverterApi) : MainRepository {
    override suspend fun convertRate(
        from: String,
        to: String,
        amount: String
    ): Resourse<ExchangeResponse> {
        return try {
            val response = api.convertRate(from, to, amount)
            if (response.isSuccessful && response.body() != null) {
                Resourse.Success(response.body())
            } else {
                Resourse.Error(response.message())
            }

        } catch (e: Exception) {
            Resourse.Error(e.message)
        }
    }

}
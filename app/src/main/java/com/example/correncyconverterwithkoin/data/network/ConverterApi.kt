package com.example.correncyconverterwithkoin.data.network

import com.example.correncyconverterwithkoin.data.models.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ConverterApi {
    @GET("convert")
    @Headers("apikey:Oc6Qt0ewxpfWOJgJu1uHpENBBsYCTx88")
    suspend fun convertRate(
        @Query("from") from:String,
        @Query("to") to:String,
        @Query("amount") amount:String

    ):Response<ExchangeResponse>
}
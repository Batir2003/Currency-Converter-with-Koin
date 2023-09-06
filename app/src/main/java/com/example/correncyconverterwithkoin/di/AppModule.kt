package com.example.correncyconverterwithkoin.di

import com.example.correncyconverterwithkoin.data.network.ConverterApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single(named("currency_converter")){
        Retrofit.Builder()
            .baseUrl("https://api.coinpaprika.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConverterApi::class.java)
    }


}
package com.example.cryptoapp.network

import com.example.cryptoapp.utils.Constants
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CryptoClient {

    private val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api= retrofit.create(CryptoService::class.java)
}
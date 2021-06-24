package com.example.cryptoapp.network

import com.example.cryptoapp.network.response.get.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET

interface CryptoService {

    @GET("/api/markets")
    suspend fun getCryptoList(): Response<CryptoResponse>
}
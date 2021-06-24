package com.example.cryptoapp.repository

import com.example.cryptoapp.network.CryptoClient
import com.example.cryptoapp.network.response.get.CryptoResponse
import com.example.cryptoapp.utils.Result
import com.example.cryptoapp.utils.Status


class CryptoRepository {

    suspend fun getCryptoDetails():Result<CryptoResponse> {
        return try {
            val res = CryptoClient.api.getCryptoList()
            if (res.code() == 401) {
                Result(Status.ERROR, null, "Retry Again!")
            }
            if (res.isSuccessful) {
                Result(Status.SUCCESS, res.body(), "Success")
            } else {
                Result(Status.ERROR, null, "Error")
            }
        } catch (e: Exception) {
            Result(Status.ERROR,null,"Exception is there $e")
        }
    }
}
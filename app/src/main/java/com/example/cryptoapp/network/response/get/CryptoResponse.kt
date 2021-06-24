package com.example.cryptoapp.network.response.get


import com.squareup.moshi.Json

data class CryptoResponse(
    @Json(name = "markets")
    val markets: List<Market>,
    @Json(name = "pagination")
    val pagination: Pagination
)
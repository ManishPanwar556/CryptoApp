package com.example.cryptoapp.network.response.get


import com.squareup.moshi.Json

data class Market(
    @Json(name="change_24h")
    val change24h: Float,
    @Json(name = "exchange_id")
    val exchangeId: String,
    @Json(name = "price")
    val price: Double,
    @Json(name = "price_unconverted")
    val priceUnconverted: Double,
    @Json(name = "spread")
    val spread: Double,
    @Json(name = "status")
    val status: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "time")
    val time: String,
    @Json(name = "volume_24h")
    val volume24h: Float
)
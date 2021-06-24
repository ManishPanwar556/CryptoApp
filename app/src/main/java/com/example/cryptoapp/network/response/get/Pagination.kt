package com.example.cryptoapp.network.response.get


import com.squareup.moshi.Json

data class Pagination(
    @Json(name = "next")
    val next: String
)
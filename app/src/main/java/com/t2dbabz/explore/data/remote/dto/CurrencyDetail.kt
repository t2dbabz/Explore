package com.t2dbabz.explore.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrencyDetail(
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

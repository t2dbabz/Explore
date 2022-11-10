package com.t2dbabz.explore.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NativeNameDetail(
    @SerializedName("common")
    val common: String,
    @SerializedName("official")
    val official: String
)

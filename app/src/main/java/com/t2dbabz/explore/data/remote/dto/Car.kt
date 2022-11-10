package com.t2dbabz.explore.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("side")
    val side: String,
    @SerializedName("signs")
    val signs: List<String>
)
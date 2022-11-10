package com.t2dbabz.explore.data.remote.dto


import com.google.gson.annotations.SerializedName

data class FrenchDemonyms(
    @SerializedName("f")
    val f: String,
    @SerializedName("m")
    val m: String
)
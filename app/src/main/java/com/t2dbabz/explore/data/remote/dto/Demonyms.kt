package com.t2dbabz.explore.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Demonyms(
    @SerializedName("eng")
    val eng: EnglishDemonyms,
    @SerializedName("fra")
    val fra: FrenchDemonyms?
)
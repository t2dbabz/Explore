package com.t2dbabz.explore.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CapitalInfo(
    @SerializedName("latlng")
    val latlng: List<Double>?
)
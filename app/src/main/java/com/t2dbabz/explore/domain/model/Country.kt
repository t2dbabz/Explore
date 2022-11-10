package com.t2dbabz.explore.domain.model

data class Country(
    val name: String,
    val capital: String,
    val region: String,
    val languages: List<String>,
    val demonyns: String,
    val independent: Boolean?,
    val unMember: Boolean,
    val area: String,
    val isLandLocked: Boolean,
    val currency:String? = null,
    val currencySymbol: String? = null,
    val timeZone: String,
    val diallingCode: String,
    val drivingSide: String,
    val geographicalLocation: List<Double>,
    val flagImage: String,
    val flagImageSVG: String,
    val coatOfArmsImage: String?,
    val coatOfArmsImageSVG: String?
)

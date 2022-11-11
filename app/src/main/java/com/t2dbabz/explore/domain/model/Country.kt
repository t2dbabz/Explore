package com.t2dbabz.explore.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: String,
    val capital: String,
    val population: Int,
    val region: String,
    val languages: String,
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
    val geographicalLocation: String,
    val flagImage: String,
    val flagImageSVG: String,
    val coatOfArmsImage: String?,
    val coatOfArmsImageSVG: String?
): Parcelable

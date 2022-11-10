package com.t2dbabz.explore.data.remote

import com.t2dbabz.explore.data.remote.dto.CountryDTO
import retrofit2.http.GET

interface CountriesApi {
    @GET("all")
    suspend fun getAllCountries(): List<CountryDTO>
}
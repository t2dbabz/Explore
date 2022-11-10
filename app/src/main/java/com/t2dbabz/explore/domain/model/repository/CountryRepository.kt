package com.t2dbabz.explore.domain.model.repository

import com.t2dbabz.explore.common.Resource
import com.t2dbabz.explore.domain.model.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    fun getAllCountries(): Flow<Resource<List<Country>>>
}
package com.t2dbabz.explore.data.repository

import android.util.Log
import com.t2dbabz.explore.common.Resource
import com.t2dbabz.explore.data.remote.CountriesApi
import com.t2dbabz.explore.domain.model.Country
import com.t2dbabz.explore.domain.model.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(private val countriesApi: CountriesApi): CountryRepository {

   override fun getAllCountries(): Flow<Resource<List<Country>>> = flow{
        Log.d("countries", "count called")
        try {
            emit(Resource.Loading())
            val countries = countriesApi.getAllCountries().map { it.toCountry() }
            emit(Resource.Success(countries))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected Error Occurred"))

        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server please check your internet connection"))
        }
    }
}
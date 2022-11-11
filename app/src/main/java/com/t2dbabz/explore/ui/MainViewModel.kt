package com.t2dbabz.explore.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.t2dbabz.explore.common.Resource
import com.t2dbabz.explore.domain.model.Country
import com.t2dbabz.explore.domain.model.repository.CountryRepository
import com.t2dbabz.explore.ui.screens.country_details.CountryDetailScreenState
import com.t2dbabz.explore.ui.screens.country_list.CountryListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val countryRepository: CountryRepository): ViewModel() {

    private val _countryListScreenState = mutableStateOf(CountryListScreenState())
    val countryListScreenState: State<CountryListScreenState> = _countryListScreenState

    private val _countryDetailScreenState = mutableStateOf(CountryDetailScreenState())
    val countryDetailScreenState: State<CountryDetailScreenState> = _countryDetailScreenState

    init {

        getCountry()
    }

    private fun getCountry() {
        countryRepository.getAllCountries().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _countryListScreenState.value = CountryListScreenState(isLoading = true)
                }
                is Resource.Success -> {
                    _countryListScreenState.value = CountryListScreenState(countries = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _countryListScreenState.value = CountryListScreenState(error = result.message ?: "Error Occurred")
                }
            }


        }.launchIn(viewModelScope)
    }

    fun setSelectedCountry(country: Country) {
        _countryDetailScreenState.value = CountryDetailScreenState(country = country)
    }
}
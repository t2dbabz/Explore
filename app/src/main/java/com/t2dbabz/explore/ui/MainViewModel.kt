package com.t2dbabz.explore.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.t2dbabz.explore.common.Resource
import com.t2dbabz.explore.domain.model.repository.CountryRepository
import com.t2dbabz.explore.ui.screens.country_list.CountryListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val countryRepository: CountryRepository): ViewModel() {

    private val _state = mutableStateOf(CountryListScreenState())
    val state: State<CountryListScreenState> = _state

    init {
        Log.d("Init", "ViewModel Called")
        getCount()
    }

    fun getCount() {
        countryRepository.getAllCountries().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = CountryListScreenState(isLoading = true)
                    //Log.d("Main", result.data?.first().toString())
                }
                is Resource.Success -> {
                   // Log.d("Main", result.data?.first().toString())
                    _state.value = CountryListScreenState(countries = result.data ?: emptyList())
                }
                is Resource.Error -> {
                   // Log.d("Main", result.message.toString())
                    _state.value = CountryListScreenState(error = result.message ?: "Error Occurred")
                }
            }


        }.launchIn(viewModelScope)
    }
}
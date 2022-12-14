package com.t2dbabz.explore.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.t2dbabz.explore.common.Resource
import com.t2dbabz.explore.data.datastore.UserPreferences
import com.t2dbabz.explore.domain.model.Continent
import com.t2dbabz.explore.domain.model.Country
import com.t2dbabz.explore.domain.model.TimeZone
import com.t2dbabz.explore.domain.model.repository.CountryRepository
import com.t2dbabz.explore.ui.screens.country_details.CountryDetailScreenState
import com.t2dbabz.explore.ui.screens.country_list.CountryListScreenEvent
import com.t2dbabz.explore.ui.screens.country_list.CountryListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val countryRepository: CountryRepository,
    private val userPreferences: UserPreferences
): ViewModel() {

    private val _countryListScreenState = mutableStateOf(CountryListScreenState())
    val countryListScreenState: State<CountryListScreenState> = _countryListScreenState

    private val _countryDetailScreenState = mutableStateOf(CountryDetailScreenState())
    val countryDetailScreenState: State<CountryDetailScreenState> = _countryDetailScreenState

    private var searchJob: Job? = null

    private val filteredList = mutableListOf<Country>()


    private val _continentList = mutableStateListOf(
        Continent("Africa", isSelected = false),
        Continent("Americas", isSelected = false),
        Continent("Asia", isSelected = false),
        Continent("Europe", isSelected = false),
        Continent("Oceania", isSelected = false),
        Continent("Antarctic", isSelected = false),
    )

    val continentList: List<Continent> = _continentList

    private val _timeZonesList = mutableStateListOf(
        TimeZone("UTC",false),
        TimeZone("UTC+01:00",false),
        TimeZone("UTC+02:00",false),
        TimeZone("UTC+03:00",false),
        TimeZone("UTC+04:00",false),
        TimeZone("UTC+05:00",false),
    )

    val timeZoneList: List<TimeZone> = _timeZonesList

    init {
        loadAppConfig()
        getCountry()
    }

    private fun loadAppConfig() = viewModelScope.launch {
        userPreferences.isAppThemeDarkMode .collectLatest { isDarkTheme ->
            _countryListScreenState.value = _countryListScreenState.value.copy(isAppThemeDarkMode = isDarkTheme)
            //delayToShowCustomAnimationOnAppStartup()
        }
    }

    fun getUserPreference(): UserPreferences {
        return userPreferences
    }

    private fun getCountry() {
        countryRepository.getAllCountries().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _countryListScreenState.value = CountryListScreenState(isLoading = true)
                }
                is Resource.Success -> {
                    val groupedCountries = result.data?.sortedBy { it.name }?.groupBy { it.name[0] }
                    _countryListScreenState.value = CountryListScreenState(countries = groupedCountries )
                    result.data?.let { filteredList.addAll(it.toList()) }
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

    fun onEvent(event: CountryListScreenEvent) {
        when(event) {
            is CountryListScreenEvent.OnSearchQueryChange -> {
               _countryListScreenState.value = _countryListScreenState.value.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                   getSearchList()
                }
            }
        }
    }


    private fun getSearchList(query: String = countryListScreenState.value.searchQuery) {
        viewModelScope.launch {

            val newCountryList: List<Country> =
                filteredList.filter {country ->
                    country.name.contains(query,ignoreCase = true,)
                }


            _countryListScreenState.value = _countryListScreenState.value.copy(countries = newCountryList.sortedBy {
                it.name }.groupBy { it.name[0] })
        }

    }

    fun setContinentSelectedAtIndex(index: Int, isSelected: Boolean) {
        _continentList[index] = _continentList[index].copy(isSelected = isSelected)
    }

    fun setTimeZoneSelectedAtIndex(index: Int, isSelected: Boolean) {
        _timeZonesList[index] = _timeZonesList[index].copy(isSelected = isSelected)
    }

    private fun continentFilter(): List<String> {
        val selectedContinent = _continentList.filter { it.isSelected }
        return selectedContinent.map { it.name }
    }

    private fun timezoneFilter(): List<String> {
        val selectedTimezones = _timeZonesList.filter { it.isSelected }
        return selectedTimezones.map { it.timeZone }
    }


    fun applyFiltersToCountryList() {
        val newFilteredList = mutableListOf<Country>()
        val continentFilterList = continentFilter()
        val timezoneList = timezoneFilter()
        viewModelScope.launch {

            continentFilterList.forEach { continent ->
                val result =  filteredList.filter { it.region == continent }
                newFilteredList.addAll(result)
            }

            timezoneList.forEach { timezone ->
                val result =  filteredList.filter { it.timeZone == timezone }
                newFilteredList.addAll(result)
            }
            _countryListScreenState.value = _countryListScreenState.value.copy(countries = newFilteredList.distinct()
                .sortedBy { it.name }.groupBy { it.name[0] })
        }

    }

    fun resetCountryListFilter(){

        with(_continentList.iterator()) {
            forEach {
               it.isSelected = false
            }
        }

        with(_timeZonesList.iterator()) {
            forEach {
                it.isSelected = false
            }
        }

        _countryListScreenState.value = _countryListScreenState.value.copy(countries = filteredList.sortedBy { it
            .name }.groupBy { it.name[0] })
    }

    fun updateAppTheme(darkMode: Boolean) = viewModelScope.launch {
        userPreferences.updateAppTheme(darkMode = darkMode)
    }


}
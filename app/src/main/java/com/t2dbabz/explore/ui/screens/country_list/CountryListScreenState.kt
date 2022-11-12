package com.t2dbabz.explore.ui.screens.country_list

import com.t2dbabz.explore.domain.model.Country

data class CountryListScreenState(
    val countries: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val searchQuery: String = "",
    val isAppThemeDarkMode: Boolean? = null,
)

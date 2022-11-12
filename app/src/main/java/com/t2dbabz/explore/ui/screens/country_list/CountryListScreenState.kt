package com.t2dbabz.explore.ui.screens.country_list

import com.t2dbabz.explore.domain.model.Country

data class CountryListScreenState(
    val countries: Map<Char, List<Country>>? = emptyMap(),
    val isLoading: Boolean = false,
    val error: String = "",
    val searchQuery: String = "",
    val isAppThemeDarkMode: Boolean? = null,
)

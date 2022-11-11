package com.t2dbabz.explore.ui.screens.country_list

sealed class CountryListScreenEvent {
    data class OnSearchQueryChange(val query: String): CountryListScreenEvent()
}

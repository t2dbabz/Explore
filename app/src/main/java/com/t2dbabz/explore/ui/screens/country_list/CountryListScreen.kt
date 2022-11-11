package com.t2dbabz.explore.ui.screens.country_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.t2dbabz.explore.ui.MainViewModel
import com.t2dbabz.explore.ui.screens.country_list.component.CountryListFilterSection
import com.t2dbabz.explore.ui.screens.country_list.component.CountryListItem
import com.t2dbabz.explore.ui.screens.country_list.component.SearchBar
import com.t2dbabz.explore.ui.screens.destinations.CountryDetailScreenDestination

@RootNavGraph(start = true)
@Destination
@Composable
fun CountryListScreen(viewModel: MainViewModel, navigator: DestinationsNavigator) {
    val state = viewModel.countryListScreenState
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 24.dp, top = 24.dp, end = 24.dp)){
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        CountryListFilterSection(onLanguageClicked = {}, onCountryListFilterClicked = {})
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn() {
            items(state.value.countries.sortedBy { it.name }) {
                CountryListItem(it) {country ->

                    navigator.navigate(CountryDetailScreenDestination(country))
                }

            }
        }
    }
}
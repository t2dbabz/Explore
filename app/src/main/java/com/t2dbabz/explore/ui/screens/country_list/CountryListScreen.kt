package com.t2dbabz.explore.ui.screens.country_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.t2dbabz.explore.ui.MainViewModel
import com.t2dbabz.explore.ui.screens.country_list.component.CountryListFilterSection
import com.t2dbabz.explore.ui.screens.country_list.component.CountryListItem
import com.t2dbabz.explore.ui.screens.country_list.component.SearchBar
import com.t2dbabz.explore.ui.screens.destinations.CountryDetailScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.CountryListFilterScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.CountryListLanguageFilterScreenDestination


@Destination
@Composable
fun CountryListScreen(viewModel: MainViewModel, navigator: DestinationsNavigator) {
    val state = viewModel.countryListScreenState.value
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 24.dp, top = 8.dp, end = 24.dp)){
        SearchBar(searchQuery = state.searchQuery){ query ->
            viewModel.onEvent(CountryListScreenEvent.OnSearchQueryChange(query))
        }
        Spacer(modifier = Modifier.height(16.dp))
        CountryListFilterSection(
            onLanguageClicked = {
                                navigator.navigate(CountryListLanguageFilterScreenDestination)
            },
            onCountryListFilterClicked = {
                navigator.navigate(CountryListFilterScreenDestination)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn() {
                state.countries?.forEach {(initial, countries) ->
                    item {
                        Text(
                            text = initial.toString(),
                            modifier = Modifier
                                .padding(
                                    end = 4.dp,
                                    bottom = 4.dp
                                )
                                .background(MaterialTheme.colors.background),
                            color = MaterialTheme.colors.onPrimary
                        )
                    }

                    items(countries) {
                        CountryListItem(it) {country ->

                            viewModel.setSelectedCountry(country)
                            navigator.navigate(CountryDetailScreenDestination(country))
                        }

                    }
                }

            }


            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)

                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), )
            }
        }

    }
}
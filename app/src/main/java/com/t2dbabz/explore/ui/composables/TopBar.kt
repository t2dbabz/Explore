package com.t2dbabz.explore.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.t2dbabz.explore.R
import com.t2dbabz.explore.ui.MainViewModel
import com.t2dbabz.explore.ui.screens.destinations.CountryDetailScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.CountryListScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.Destination
import com.t2dbabz.explore.ui.theme.ElsieSwashCaps
import com.t2dbabz.explore.ui.theme.FilterButton

@Composable
fun TopBar(destination: Destination, navBackStackEntry: NavBackStackEntry?, navController: NavController,
           isAppThemeDarkMode: Boolean) {

    val viewModel = viewModel<MainViewModel>()
    val state = viewModel.countryDetailScreenState.value

    when(destination) {
        CountryListScreenDestination -> {
            TopAppBar(
                title = {
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontFamily = ElsieSwashCaps, fontSize = 20.sp)) {
                                append("Explore")
                            }
                            withStyle(SpanStyle(fontFamily = ElsieSwashCaps, fontSize = 20.sp, color = FilterButton)) {
                                append(".")
                            }
                        },
                        fontSize = 24.sp,
                        fontFamily = ElsieSwashCaps,
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background,
                actions = {
                    IconButton(onClick = {
                        viewModel.updateAppTheme(darkMode = !isAppThemeDarkMode)
                    }) {
                        Icon(
                            painter = if (isAppThemeDarkMode) painterResource(id = R.drawable.ic_dark_mode ) else painterResource
                                (id = R.drawable.ic_outline_light ),
                            contentDescription = "light mode",
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            )
        }

        CountryDetailScreenDestination -> {

            TopAppBar(
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background,
                navigationIcon = {
                  Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription ="navigate up",
                      modifier = Modifier
                          .padding(start = 16.dp)
                          .clickable {
                              navController.navigateUp()
                          })


                },
                title = {
                    Box(modifier = Modifier.padding(horizontal = 100.dp),  Alignment.Center){
                        if (state.country != null) {
                            if (state.country.name.length > 9 ) {
                                Text(
                                    text = state.country.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colors.onPrimary
                                )
                            } else {
                                Text(
                                    text = state.country.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colors.onPrimary
                                )
                            }
                        }
                    }
                }
            )
        }
        else -> {}
    }
}




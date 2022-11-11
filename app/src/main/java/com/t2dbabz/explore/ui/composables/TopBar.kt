package com.t2dbabz.explore.ui.composables

import android.telecom.Call.Details
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.t2dbabz.explore.R
import com.t2dbabz.explore.ui.MainViewModel
import com.t2dbabz.explore.ui.screens.destinations.CountryDetailScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.CountryListScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.Destination
import com.t2dbabz.explore.ui.theme.ElsieSwashCaps
import com.t2dbabz.explore.ui.theme.HeaderColor

@Composable
fun TopBar(destination: Destination, navBackStackEntry: NavBackStackEntry?, navController: NavController) {

    val country = viewModel<MainViewModel>().countryDetailScreenState.value.country

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
                            withStyle(SpanStyle(fontFamily = ElsieSwashCaps, fontSize = 20.sp, color = Color.Red)) {
                                append(".")
                            }
                        },
                        fontSize = 24.sp,
                        fontFamily = ElsieSwashCaps,
                    )
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_outline_light),
                            contentDescription = "light mode",
                            tint = Color.Black
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
                        if (country != null) {
                            if (country.name.length > 10 ) {
                                Text(
                                    text = country.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            } else {
                                Text(
                                    text = country.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
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




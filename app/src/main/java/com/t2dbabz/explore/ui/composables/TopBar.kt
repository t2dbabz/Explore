package com.t2dbabz.explore.ui.composables

import android.telecom.Call.Details
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import com.t2dbabz.explore.ui.screens.destinations.CountryDetailScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.CountryListScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.Destination

@Composable
fun TopBar(destination: Destination, navBackStackEntry: NavBackStackEntry?) {

    when(destination) {
        CountryListScreenDestination -> {
            TopAppBar {
                Spacer(Modifier.width(8.dp))

                Text(
                    text = "Explore",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            }
        }

        CountryDetailScreenDestination -> {
            TopAppBar {
                Spacer(Modifier.width(8.dp))

                Text(
                    text = "Details",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            }
        }
    }
}




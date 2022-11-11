package com.t2dbabz.explore.ui.screens.country_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(style = DestinationStyle.BottomSheet::class)
@Composable
fun CountryListFilterScreen(navigator: DestinationsNavigator) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 24.dp, end = 24.dp, top = 24.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Filter", style = MaterialTheme.typography.h6)
            Icon(imageVector = Icons.Default.Clear, contentDescription = "", modifier = Modifier.clickable {
                navigator.navigateUp()
            })
        }
        Spacer(modifier = Modifier.height(24.dp))
        ContinentFilterSection()
        Spacer(modifier = Modifier.height(24.dp))
        TimeZoneFilterSection()
    }
}

@Preview
@Composable
fun ContinentFilterSection(){
    val continents = listOf("Africa", "Americas", "Asia", "Europe", "Oceania")
    var isExpanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isExpanded = !isExpanded
            }, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment
        = Alignment.CenterVertically) {
          Text(text = "Continent", style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold)
          Icon(imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown, contentDescription =
          "")
        }
        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = isExpanded) {
            Column() {
                continents.forEachIndexed {  index, continent ->
                    Column(modifier = Modifier.wrapContentSize()) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            val isChecked = remember { mutableStateOf(false) }
                            Text(text = continent)
                            Checkbox(
                                checked = isChecked.value,
                                onCheckedChange = { isChecked.value = it },
                                enabled = true,
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color.Black,
                                    uncheckedColor = Color.DarkGray,
                                    checkmarkColor = Color.White
                                )
                            )

                        }
                    }

                }
            }

        }

    }
}

@Preview
@Composable
fun TimeZoneFilterSection(){
    val timeZones = listOf("UTC", "UTC+01:00", "UTC+02:00", "UTC+03:00", "UTC+04:00")
    var isExpanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth()) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isExpanded = !isExpanded
            }, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment
        = Alignment.CenterVertically) {
            Text(text = "Time Zone",  style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold)
            Icon(imageVector =  if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "")
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(visible = isExpanded) {
            Column {
                timeZones.forEachIndexed { index, timezone ->
                    Column(modifier = Modifier.fillMaxWidth().wrapContentSize()) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            val isChecked = remember { mutableStateOf(false) }
                            Text(text = timezone)
                            Checkbox(
                                checked = isChecked.value,
                                onCheckedChange = { isChecked.value = it },
                                enabled = true,
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color.Black,
                                    uncheckedColor = Color.DarkGray,
                                    checkmarkColor = Color.White
                                )
                            )

                        }
                    }

                }
            }

        }


    }
}
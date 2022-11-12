package com.t2dbabz.explore.ui.screens.country_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle

@OptIn(ExperimentalMaterialNavigationApi::class)
@Destination(style = DestinationStyle.BottomSheet::class)
@Composable
fun CountryListLanguageFilterScreen(bottomSheetNavigator: BottomSheetNavigator,navigator: DestinationsNavigator) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.background)
        .padding(start = 24.dp, end = 24.dp, top = 24.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Languages", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.onPrimary)
            Icon(imageVector = Icons.Default.Clear, contentDescription = "", modifier = Modifier.clickable {
                navigator.navigateUp()
            }, tint = MaterialTheme.colors.onPrimary)
        }
        Spacer(modifier = Modifier.height(24.dp))
        LanguageFilterSection(){

        }
    }
}


@Composable
fun LanguageFilterSection(onOptionSelect:(String) -> Unit){
    val languagesOptions = listOf("Bahasa", "Deutsch", "English", "Espanol", "Francaise",
        "Italiano", "Portugues", "Pycckuu", "Svenska", "Turkce")

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(languagesOptions[2] ) }
    Column(modifier = Modifier.fillMaxWidth()) {
        languagesOptions.forEachIndexed { index, languages ->
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth().selectable(
                        selected = (languages == selectedOption),
                        onClick = {
                            onOptionSelected(languages)
                            onOptionSelect(languages)
                        }),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = languages, style = MaterialTheme.typography.subtitle1, color = MaterialTheme.colors.onPrimary)
                    RadioButton(
                        selected = (languages == selectedOption),
                        onClick = { onOptionSelected(languages) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colors.onPrimary,
                            unselectedColor = MaterialTheme.colors.onPrimary,
                            disabledColor = Color.White
                        )

                    )



                }
            }

        }
    }
}
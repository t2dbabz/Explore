package com.t2dbabz.explore.ui.screens.country_list.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.t2dbabz.explore.R
import com.t2dbabz.explore.ui.theme.FilterBorder

@Composable
fun CountryListFilterSection(
    modifier: Modifier = Modifier,
    onLanguageClicked: () -> Unit,
    onCountryListFilterClicked: () -> Unit
) {

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Card(
            modifier = Modifier
                .size(height = 40.dp, width = 73.dp)
                .shadow(
                    shape = RoundedCornerShape(4.dp),
                    elevation = 0.5.dp
                )
                .clickable {
                       onLanguageClicked()
                },
            border = BorderStroke(width = 0.2.dp, color = FilterBorder),
            shape = RoundedCornerShape(4.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Icon(painter = painterResource(id = R.drawable.globe), contentDescription = "icon",  )
                Text(text = "EN", style = MaterialTheme.typography.caption, lineHeight = 19.sp, modifier = Modifier.padding
                    (start = 10.dp), color = MaterialTheme.colors.onPrimary )
            }
        }

        Card(
            modifier = Modifier
                .size(height = 40.dp, width = 86.dp)
                .shadow(
                    shape = RoundedCornerShape(4.dp),
                    elevation = 0.5.dp
                ).clickable {
                     onCountryListFilterClicked()
                },
            border = BorderStroke(width = 0.2.dp, color = FilterBorder),
            shape = RoundedCornerShape(4.dp),
            backgroundColor = MaterialTheme.colors.background
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Icon(painter = painterResource(id = R.drawable.filter), contentDescription = "icon", Modifier.size(18
                    .dp), )
                Text(text = "Filter", style = MaterialTheme.typography.caption, lineHeight = 19.sp, modifier =
                Modifier.padding(start = 11.dp),color = MaterialTheme.colors.onPrimary)
            }
        }
    }
}
package com.t2dbabz.explore.ui.screens.country_list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.t2dbabz.explore.domain.model.Country

@Composable
fun CountryListItem(country: Country, onItemClick: (Country) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .height(46.dp)
            .clickable {
                       onItemClick(country)
            },
        verticalAlignment = Alignment
            .CenterVertically
    ) {
        AsyncImage(
            model = country.flagImage,
            contentDescription ="country flag",
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(6.dp),),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxHeight().padding(start = 16.dp), verticalArrangement = Arrangement.Center) {
            Text(text = country.name, fontSize = 14.sp, lineHeight = 22.18.sp)
            Text(text = country.capital, fontSize = 14.sp, lineHeight = 22.18.sp, modifier = Modifier.padding(top = 2.dp))
        }
    }
}
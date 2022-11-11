package com.t2dbabz.explore.ui.screens.country_list.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.t2dbabz.explore.ui.theme.GraySearch

@Preview
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,


            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = GraySearch
        ),
        placeholder = {

               Text(text = "Search Country")

        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}
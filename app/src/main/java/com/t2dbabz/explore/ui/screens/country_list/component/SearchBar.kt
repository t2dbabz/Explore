package com.t2dbabz.explore.ui.screens.country_list.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.t2dbabz.explore.R
import com.t2dbabz.explore.ui.theme.GraySearch


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
) {
    TextField(
        value = searchQuery,
        onValueChange = {
                  onSearchQueryChange(it)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = GraySearch
        ),
        maxLines = 1,
        singleLine = true,
        placeholder = {
               Text(text = stringResource(id = R.string.search_country))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}
package com.t2dbabz.explore.ui.screens.country_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.t2dbabz.explore.R


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
) {
    OutlinedTextField(

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
            backgroundColor = MaterialTheme.colors.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        maxLines = 1,
        singleLine = true,
        placeholder = {
               Text(text = stringResource(id = R.string.search_country), textAlign =  TextAlign.Center, modifier =
               Modifier.fillMaxWidth())
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                 color = MaterialTheme.colors.surface
            )
    )
}
package com.t2dbabz.explore.ui.screens.country_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.t2dbabz.explore.domain.model.Country
import com.t2dbabz.explore.domain.model.Page
import com.t2dbabz.explore.ui.theme.LightTextGray


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CountryImagesPager(country: Country) {
    val pagerState = rememberPagerState()
    val pages = listOf(
        Page(country.flagImage),
        Page(country.coatOfArmsImage ?: ""),
    )

    Box(modifier = Modifier
        .size(height = 190.dp, width = 400.dp)
        .clip(shape = RoundedCornerShape(8.dp))){
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                Surface(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = pages[page].url,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }


            }
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = Color.White,
            inactiveColor = LightTextGray,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 16.dp)
        )
    }
}


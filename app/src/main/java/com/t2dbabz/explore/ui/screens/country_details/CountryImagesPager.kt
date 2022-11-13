package com.t2dbabz.explore.ui.screens.country_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.t2dbabz.explore.domain.model.Country
import com.t2dbabz.explore.domain.model.Page
import com.t2dbabz.explore.ui.theme.LightTextGray
import com.t2dbabz.explore.R
import com.t2dbabz.explore.ui.theme.FilterBorder
import com.t2dbabz.explore.ui.theme.PagerIcon
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CountryImagesPager(country: Country) {
    val pagerState = rememberPagerState()
    val pages = listOf(
        Page(country.flagImage),
        Page(country.coatOfArmsImage ?: ""),
    )

    val scope = rememberCoroutineScope()

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

        PagerSlideButton(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .clickable {
                           scope.launch {
                               if (pagerState.currentPage == 0){
                                  return@launch
                               } else {
                                   pagerState.animateScrollToPage(pagerState.currentPage - 1)
                               }

                           }
                },
            icon = R.drawable
                .ic_arrow_back
        )

        PagerSlideButton(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .clickable {
                    scope.launch {
                        if (pagerState.currentPage == pages.lastIndex){
                            return@launch
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
            icon = R.drawable
                .ic_arrow_forward
        )

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = Color.White,
            inactiveColor = LightTextGray,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )




    }
}

@Composable
fun PagerSlideButton(modifier: Modifier = Modifier, icon: Int) {
    Surface(modifier = modifier
        .size(32.dp)
        .clip(CircleShape), color = FilterBorder.copy(alpha = 0.8f)) {
        Box {
            Icon(painter = painterResource(id = icon), contentDescription = "arrow icon", tint =
            PagerIcon, modifier = Modifier
                .size(height = 16.dp, width = 16.dp)
                .align(Alignment.Center))
        }
    }
}


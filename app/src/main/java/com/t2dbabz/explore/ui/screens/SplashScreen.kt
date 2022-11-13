package com.t2dbabz.explore.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import com.t2dbabz.explore.ui.screens.destinations.CountryListScreenDestination
import com.t2dbabz.explore.ui.screens.destinations.SplashScreenDestination
import com.t2dbabz.explore.ui.theme.ElsieSwashCaps
import com.t2dbabz.explore.ui.theme.FilterButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontFamily = ElsieSwashCaps, fontSize = 30.sp)) {
                    append("Explore")
                }
                withStyle(SpanStyle(fontFamily = ElsieSwashCaps, fontSize = 20.sp, color = FilterButton)) {
                    append(".")
                }
            },
            fontSize = 24.sp,
            fontFamily = ElsieSwashCaps,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.align(Alignment.Center)
        )

        scope.launch {
            delay(2000L)
            navigator.navigate(CountryListScreenDestination) {
                popUpTo(SplashScreenDestination){
                    inclusive = true
                }
            }
        }


    }
}
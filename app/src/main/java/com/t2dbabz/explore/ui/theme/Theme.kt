package com.t2dbabz.explore.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = HeaderColor,
    onPrimary = DarkTextBlack,
    secondary = DarkTextGray,
    onSecondary = LightTextGray,
    background = DarkBackground,
    onBackground = DarkIconTint,
    surface = DarkBackground,
    onSurface = DarkOnPrimary,
)

private val LightColorPalette = lightColors(
    primary = DarkBackground,
    primaryVariant = LightTextBlack,
    onPrimary = LightTextBlack,
    secondary = DarkTextBlack,
    onSecondary = GraySearchText,
    background = Color.White,
    onBackground = Color.Black,
    surface = DarkTextBlack,
    onSurface = GraySearchText,





    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ExploreTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(color = colors.primaryVariant)
        systemUiController.systemBarsDarkContentEnabled = false
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
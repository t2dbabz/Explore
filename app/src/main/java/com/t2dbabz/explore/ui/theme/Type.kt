package com.t2dbabz.explore.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.t2dbabz.explore.R

private val Axiforma = FontFamily(
     Font(R.font.axiforma_regular),
     Font(R.font.axiforma_light, FontWeight.W300),
     Font(R.font.axiforma_bold, FontWeight.W700),
     Font(R.font.axiforma_medium, FontWeight.W500),
 )

 val ElsieSwashCaps = FontFamily(
    Font(R.font.elsieswashcaps_black, FontWeight.W900)
)



// Set of Material typography styles to start with
val Typography = Typography(
    h6 = TextStyle(
        fontFamily = Axiforma,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Axiforma,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = Axiforma,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Axiforma,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    caption = TextStyle(
        fontFamily = Axiforma,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),

    button = TextStyle(
        fontFamily = Axiforma,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)



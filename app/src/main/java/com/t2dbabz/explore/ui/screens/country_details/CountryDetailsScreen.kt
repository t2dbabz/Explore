package com.t2dbabz.explore.ui.screens.country_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.ramcosta.composedestinations.annotation.Destination
import com.t2dbabz.explore.domain.model.Country
import com.t2dbabz.explore.R


@Destination
@Composable
fun CountryDetailScreen(country: Country) {


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 24.dp)
        .verticalScroll(rememberScrollState())) {
        CountryImage(country)

        Spacer(modifier = Modifier.height(24.dp))

        CountryDetailsSectionOne(country = country)

        Spacer(modifier = Modifier.height(24.dp))

        CountryDetailsSectionTwo(country = country)

        Spacer(modifier = Modifier.height(24.dp))

        CountryDetailsSectionThree(country = country)

        Spacer(modifier = Modifier.height(24.dp))

        CountryDetailsSectionFour(country = country)
    }
}


@Composable
fun CountryImage(country: Country) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(country.flagImageSVG)
            .size(height = 200, width = 380) // Set the target size to load the image at.
            .build()
    )
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(height = 190.dp, width = 400.dp)
            .clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun CountryDetailsSectionOne(country: Country){
    Column {
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.population))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.population.toString())
            }
        })

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.region))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.region)
            }
        }, modifier = Modifier.padding(top = 4.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.capital))
            }
            append("   ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.capital)
            }
        }, modifier = Modifier.padding(top = 4.dp))
    }
}

@Composable
fun CountryDetailsSectionTwo(country: Country){
    Column {
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.official_language))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.languages)
            }
        })

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.demonym))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.demonyns)
            }
        }, modifier = Modifier.padding(top = 4.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.independent))
            }
            append("  ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(if (country.independent == true) "Yes" else "No")
            }
        }, modifier = Modifier.padding(top = 4.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.un_member))
            }
            append("  ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(if (country.unMember) "Yes" else "No")
            }
        }, modifier = Modifier.padding(top = 4.dp))
    }
}


@Composable
fun CountryDetailsSectionThree(country: Country){
    Column {
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.area))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.area + " km2")
            }
        })

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.landlocked))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(if (country.isLandLocked) "Yes" else "No")
            }
        }, modifier = Modifier.padding(top = 4.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.currency))
            }
            append("  ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                if (country.currency != null) {
                    append(country.currency)
                } else {
                    append("None")
                }

            }
        }, modifier = Modifier.padding(top = 4.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.currency_symbol))
            }
            append("  ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                if (country.currencySymbol != null) {
                    append(country.currencySymbol)
                } else {
                    append("None")
                }
            }
        }, modifier = Modifier.padding(top = 4.dp))
    }
}


@Composable
fun CountryDetailsSectionFour(country: Country){
    Column {
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.time_zone))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.timeZone)
            }
        })

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.dialling_code))
            }
            append(" ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                append(country.diallingCode)
            }
        }, modifier = Modifier.padding(top = 4.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.driving_side))
            }
            append("  ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){
                    append(country.drivingSide)


            }
        }, modifier = Modifier.padding(top = 4.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(stringResource(id = R.string.geographical_location))
            }
            append("  ")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary, fontWeight = FontWeight.Light)){

                    append(country.geographicalLocation)

            }
        }, modifier = Modifier.padding(top = 4.dp))
    }
}
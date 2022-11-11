package com.t2dbabz.explore.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.spec.Route
import com.t2dbabz.explore.ui.screens.appCurrentDestinationAsState
import com.t2dbabz.explore.ui.screens.destinations.Destination
import com.t2dbabz.explore.ui.screens.startAppDestination

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun ExploreScaffold(
    startRoute: Route,
    navController: NavHostController,
    bottomSheetNavigator: BottomSheetNavigator,
    topBar: @Composable (Destination, NavBackStackEntry?) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination

    val navBackStackEntry = navController.currentBackStackEntry



    navController.navigatorProvider += bottomSheetNavigator

    // 👇 ModalBottomSheetLayout is only needed if some destination is bottom sheet styled
    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(16.dp)
    ) {
        Scaffold(
            topBar = {
                topBar(destination, navBackStackEntry)
            },

            content = content
        )
    }
}
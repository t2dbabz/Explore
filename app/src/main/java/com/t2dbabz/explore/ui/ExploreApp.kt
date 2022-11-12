package com.t2dbabz.explore.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency
import com.t2dbabz.explore.MainActivity
import com.t2dbabz.explore.ui.composables.ExploreScaffold
import com.t2dbabz.explore.ui.composables.TopBar
import com.t2dbabz.explore.ui.screens.NavGraphs

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
fun ExploreApp(activity: MainActivity, isAppDarkMode: Boolean) {

    val engine = rememberAnimatedNavHostEngine()
    val navController = engine.rememberNavController()
    val bottomSheetNavigator = rememberBottomSheetNavigator()

    ExploreScaffold(
        startRoute = NavGraphs.root.startRoute,
        navController = navController,
        bottomSheetNavigator,
        topBar = { destination, navBackStackEntry -> TopBar(destination, navBackStackEntry, navController, isAppDarkMode) }
    ) {
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(it),
            dependenciesContainerBuilder = {
                dependency(hiltViewModel<MainViewModel>(activity))

                dependency(bottomSheetNavigator)
            }
        )


    }
}
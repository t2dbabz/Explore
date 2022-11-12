package com.t2dbabz.explore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.t2dbabz.explore.ui.ExploreApp
import com.t2dbabz.explore.ui.MainViewModel
import com.t2dbabz.explore.ui.theme.ExploreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            val isAppThemeDarkMode = viewModel.getUserPreference().isAppThemeDarkMode.collectAsState(isSystemInDarkTheme()).value ?: false
            ExploreTheme(isAppThemeDarkMode) {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ExploreApp(this, isAppThemeDarkMode)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExploreTheme {

    }
}
package com.abdulaziz.animekmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.abdulaziz.animekmm.android.data.NavigationGraph
import com.abdulaziz.animekmm.android.domain.FeedViewModel
import com.abdulaziz.animekmm.android.ui.components.AppBottomNavigation
import com.abdulaziz.animekmm.android.ui.components.AppLoader

class MainActivity : ComponentActivity() {
    lateinit var showLoader: MutableState<Boolean>
    private val feedViewModel: FeedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showLoader = remember { mutableStateOf(false) }
            MainScreenView()
            AppLoader(showLoader = showLoader.value)
        }
    }

    @Composable
    fun MainScreenView() {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { AppBottomNavigation(navController = navController) }, content = { _ ->
                NavigationGraph(navController = navController, feedViewModel,)
            })
    }
}


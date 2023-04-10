package com.abdulaziz.animekmm.android.data

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abdulaziz.animekmm.android.domain.FeedViewModel
import com.abdulaziz.animekmm.android.ui.destinations.About
import com.abdulaziz.animekmm.android.ui.destinations.Feed
import com.abdulaziz.animekmm.android.ui.destinations.Genre

@Composable
fun NavigationGraph(navController: NavHostController, feedViewModel: FeedViewModel) {
    NavHost(navController, startDestination = BottomNavItem.Feed.screen_route) {
        composable(BottomNavItem.Feed.screen_route) {
            val genre:String? = it.arguments?.getString("genre") ?: ""
            Feed(navController, genre)
        }
        composable(BottomNavItem.Genre.screen_route) {
            Genre(navController)
        }
        composable(BottomNavItem.About.screen_route) {
            About(navController)
        }
    }
}
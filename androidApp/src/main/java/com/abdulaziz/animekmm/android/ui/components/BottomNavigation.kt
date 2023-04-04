package com.abdulaziz.animekmm.android.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.abdulaziz.animekmm.android.data.BottomNavItem
import androidx.compose.runtime.getValue
import com.abdulaziz.animekmm.android.ui.theme.Purple500
import com.abdulaziz.animekmm.android.ui.theme.Teal200

@Composable
fun AppBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Feed,
        BottomNavItem.Genre,
        BottomNavItem.About
    )
    BottomNavigation(
        backgroundColor = Purple500,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
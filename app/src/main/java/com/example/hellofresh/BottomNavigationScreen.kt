package com.example.hellofresh

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hellofresh.navigation.BottomNavItem

@Composable
fun bottomNavigationScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            bottomNavigationBar(items = listOf(
                BottomNavItem(
                    name = "Shop",
                    route = Screens.ShopScreen.route,
                    image = Icons.Default.ShoppingCart
                ),
                BottomNavItem(
                    name = "Explore",
                    route = Screens.ExploreScreen.route,
                    image = Icons.Default.Search
                ),
                BottomNavItem(
                    name = "Notification",
                    route = Screens.NotificationScreen.route,
                    image = Icons.Default.Notifications
                ),
                BottomNavItem(
                    name = "Profile",
                    route = Screens.ProfileScreen.route,
                    image = Icons.Default.Person
                )

            ),
                navController = navController,
                onItemClick = { navController.navigate(it.route) })
        }) {
        bottomNavGraph(navController = navController)
    }
}
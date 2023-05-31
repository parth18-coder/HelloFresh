package com.example.hellofresh

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hellofresh.navigation.Graph
import com.example.hellofresh.ui.theme.uIs.exploreScreenUI
import com.example.hellofresh.ui.theme.uIs.notificationScreenUI
import com.example.hellofresh.ui.theme.uIs.profileScreenUI
import com.example.hellofresh.ui.theme.uIs.shopScreenUI

@Composable
fun bottomNavGraph(navController: NavHostController){
    NavHost(navController =navController , startDestination =Screens.ShopScreen.route, route = Graph.BOTTOM_NAVIGATION)
    {
        composable(Screens.ShopScreen.route){
            shopScreenUI(navController)
        }

        composable(route = Screens.ExploreScreen.route) {
            exploreScreenUI()
        }

        composable(route = Screens.NotificationScreen.route) {
            notificationScreenUI()
        }

        composable(route = Screens.ProfileScreen.route) {
            profileScreenUI()
        }
    }
}
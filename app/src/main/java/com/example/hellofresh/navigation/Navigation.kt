package com.example.hellofresh.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellofresh.Screens
import com.example.hellofresh.bottomNavigationScreen
import com.example.hellofresh.ui.theme.uIs.*
import com.google.accompanist.pager.ExperimentalPagerApi

/*
Add the Navigation dependency: In your app's build.gradle file, make sure you have the following dependencies added:
implementation "androidx.navigation:navigation-compose:2.4.0-alpha04"
 */

@Composable
@ExperimentalPagerApi
@ExperimentalMaterialApi
fun Navigation() {
    var navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route,
        route=Graph.Root
    ) {
        composable(route=Screens.MainScreen.route){
            mainScreenUi(navController)
        }

        composable(route=Screens.OnBoardingScreen.route){
            onBoardingScreenUi(navController)
        }

        composable(route=Graph.BOTTOM_NAVIGATION){
            bottomNavigationScreen()
        }
    }
}

object Graph{
    const val Root="root_graph"
    const val BOTTOM_NAVIGATION="bottom_navigation_graph"
    const val BASIC_NAVIGATION="basic_navigation_graph"
}
package com.example.hellofresh

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellofresh.ui.theme.uIs.mainScreenUi
import com.example.hellofresh.ui.theme.uIs.onBoardingScreenUi
import com.example.hellofresh.ui.theme.uIs.shopScreenUI
import com.google.accompanist.pager.ExperimentalPagerApi

/*
Add the Navigation dependency: In your app's build.gradle file, make sure you have the following dependencies added:
implementation "androidx.navigation:navigation-compose:2.4.0-alpha04"
 */

@Composable
@ExperimentalPagerApi
@ExperimentalMaterialApi
fun navigation() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route=Screens.MainScreen.route){
            mainScreenUi(navController)
        }

        composable(route=Screens.OnBoardingScreen.route){
            onBoardingScreenUi(navController)
        }

        composable(route=Screens.ShopScreen.route){
            shopScreenUI()
        }
    }

}
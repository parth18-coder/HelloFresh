package com.example.hellofresh

sealed class Screens(val route:String){
    object MainScreen:Screens("main_screen")
    object OnBoardingScreen:Screens("on_boarding_screen")
    object ShopScreen:Screens("shop")
    object ExploreScreen:Screens("explore")
    object NotificationScreen:Screens("notification")
    object ProfileScreen:Screens("profile")
}



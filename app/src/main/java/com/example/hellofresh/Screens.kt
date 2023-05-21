package com.example.hellofresh

sealed class Screens(val route:String){
    object MainScreen:Screens("main_screen")
    object OnBoardingScreen:Screens("on_boarding_screen")
}



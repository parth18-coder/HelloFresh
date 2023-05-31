package com.example.hellofresh.ui.theme.uIs

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun notificationScreenUI(){
    Scaffold(topBar = { notificationAppBar()}) {}

}

@Composable
fun notificationAppBar() {
    TopAppBar(
        title = {
            Text(text = "Notifications")
        },
        backgroundColor = Color(0xFF1B5E20),
        contentColor = Color.White
    )
}
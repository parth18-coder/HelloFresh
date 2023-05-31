package com.example.hellofresh.ui.theme.uIs

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun exploreScreenUI(){
    Scaffold(topBar = { exploreAppBar()}) {}
}

@Composable
fun exploreAppBar() {
    TopAppBar(
        title = {
            Text(text = "Explore")
        },
        backgroundColor = Color(0xFF1B5E20),
        contentColor = Color.White
    )
}
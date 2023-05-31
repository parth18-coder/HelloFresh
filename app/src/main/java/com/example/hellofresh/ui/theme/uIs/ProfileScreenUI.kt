package com.example.hellofresh.ui.theme.uIs

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun profileScreenUI(){
    Scaffold(topBar = { profileAppBar()}) {}
}

@Composable
fun profileAppBar() {
    TopAppBar(
        title = {
            Text(text = "Profile")
        },
        backgroundColor = Color(0xFF1B5E20),
        contentColor = Color.White
    )
}
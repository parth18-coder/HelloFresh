package com.example.hellofresh.ui.theme.uIs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.hellofresh.R

@Composable
fun shopScreenUI() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Welcome to",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Image(painter = painterResource(id = R.drawable.shopimage1), contentDescription = "logo" )
        Text(text = "Eat Better.Every Day")
        Image(painter = painterResource(id = R.drawable.shopimage2), contentDescription = "Image showing variety of the foods")
        Text(text = "Fresh ingredients and easy-to-follow recipes,straight to your doorstep.")

    }
}
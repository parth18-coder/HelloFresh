package com.example.hellofresh.ui.theme.uIs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hellofresh.*
import com.example.hellofresh.R
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun shopScreenUI(navController:NavHostController) {
    Scaffold(topBar = {
        shopScreenAppBar()
    }){

    }

    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Welcome to",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 65.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp


        )
        Box(modifier = Modifier
            .height(65.dp)
            .fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.shopimage1), contentDescription = "logo", modifier = Modifier.fillMaxSize())
        }
        Text(text = "Eat Better.Every Day", fontSize = 24.sp)
        Box(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.shopimage2), contentDescription = "Image showing variety of the foods",
            modifier = Modifier.fillMaxSize())
        }
        Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center) {
            Text(text = "Fresh ingredients and easy-to-follow recipes,straight to your doorstep.",
                modifier = Modifier.padding(20.dp),
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold)

        }

        Button(
            onClick = {}, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF1B5E20),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Build your plan",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun shopScreenAppBar() {
    TopAppBar(title = {
        Text(text = "Shop", textAlign = TextAlign.Center,modifier=Modifier.fillMaxWidth())
    },
    backgroundColor = Color(0xFF1B5E20),
    contentColor = Color.White)

}
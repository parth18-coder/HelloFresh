package com.example.hellofresh.ui.theme.uIs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import com.example.hellofresh.BottomSheetScreen
import com.example.hellofresh.R
import com.example.hellofresh.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@ExperimentalPagerApi
@ExperimentalMaterialApi
fun mainScreenUi(navController: NavController) {

    var sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val bottomSheetObj = BottomSheetScreen()
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        loginRow()

        Box(modifier = Modifier.height(350.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.hellofreshimage),
                contentDescription = "Image of the home screen"
            )
        }

        textComposable()

        Column(
            modifier = Modifier
                .height(130.dp)
                .padding(10.dp)
        ) {
            tellMeMoreButton(navController = navController)

            selectYourPlanButton(sheetState = sheetState, scope = scope)
        }
    }

    bottomSheetObj.BottomSheet(sheetState)
}

@Composable
fun loginRow() {
    Box(
        modifier = Modifier
            .height(100.dp)
            .padding(16.dp),

        ) {
        val constraints = ConstraintSet {
            val loginButton = createRefFor("loginButton")
            val dropDownMenu = createRefFor("dropDownMenu")

            constrain(loginButton) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
        }

        ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(10.dp)
                    .layoutId("loginButton"),

                // This is used to color the background of the button and color inside the button.
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color(0xFF1B5E20)
                ),

                // to draw the border around the button
                border = BorderStroke(1.dp, Color(0xFF1B5E20))

            ) {
                Text(text = "Log in")
            }

        }
    }
}

@Composable
fun textComposable() {
    Column(
        modifier = Modifier
            .height(170.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Eat better",
            fontSize = 30.sp
        )

        Text(
            text = "Everyday!",
            fontSize = 30.sp,
            color = Color(0xFF1B5E20)
        )

        Text(
            text = "Get fresh ingredients easy-to-follow recipe cards delivered to the door",
            fontSize = 18.sp
        )
    }
}

@Composable
fun tellMeMoreButton(navController: NavController){
    Button(
        onClick = { navController.navigate(Screens.OnBoardingScreen.route) },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF1B5E20),
            contentColor = Color.White
        )
    ) {
        Text(text = "Tell me more")
    }
}

@Composable
@ExperimentalPagerApi
@ExperimentalMaterialApi
fun selectYourPlanButton(sheetState:ModalBottomSheetState, scope:CoroutineScope){
    Button(
        onClick = {
            scope.launch {
                sheetState.animateTo(ModalBottomSheetValue.Expanded)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color(0xFF1B5E20)
        ),

        border = BorderStroke(1.dp, Color(0xFF1B5E20))

    ) {
        Text(text = "Select your plan")
    }
}
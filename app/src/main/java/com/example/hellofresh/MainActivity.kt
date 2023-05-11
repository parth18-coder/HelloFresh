package com.example.hellofresh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.hellofresh.ui.theme.HelloFreshTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.example.hellofresh.BottomSheetScreen.*
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    @ExperimentalPagerApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // To change the color of the status bar
        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_green)

        setContent {
            var isVisibleImage by remember {
                mutableStateOf(true)
            }
            var isVisible by remember { mutableStateOf(true) }

            val items = onBoardingData()

            val pagerState = rememberPagerState(
                pageCount = items.size,
                initialOffscreenLimit = 2,
                infiniteLoop = false,
                initialPage = 0,
            )

            val scope= rememberCoroutineScope()
            var sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            val bottomSheetObj=BottomSheetScreen()

            HelloFreshTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFAFA)),
                    color = MaterialTheme.colors.background

                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        loginRow()

                        if (isVisibleImage) {
                            Box(modifier = Modifier.height(350.dp)) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.hellofreshimage),
                                    contentDescription = "Image of the home screen"
                                )
                            }
                        } else{
                            onBoardingPager(
                                items = items, pagerState = pagerState, modifier = Modifier
                                    .fillMaxWidth()
                                    .height(580.dp)
                            )
                        }

                        if(isVisible) {
                            textComposable()
                        }

                        Column(
                            modifier = Modifier
                                .height(130.dp)
                                .padding(10.dp)
                        ) {
                            if (isVisible) {
                                Button(
                                    onClick = {
                                        isVisible = false
                                        isVisibleImage = false
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color(0xFF1B5E20),
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(text = "Tell me more")
                                }
                            }

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
                                )
                            ) {
                                Text(text = "Select your plan")
                            }
                        }

                    }

                }
            }
            bottomSheetObj.BottomSheet(sheetState)
        }
    }
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

// for colors hexadecimal we have to add '0xFF'
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

@ExperimentalPagerApi
@Composable
fun buttonComposable() {

    var isVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .height(130.dp)
            .padding(10.dp)
    ) {
        if (isVisible) {
            Button(
                onClick = { isVisible = false },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF1B5E20),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Tell me more")
            }
        }

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color(0xFF1B5E20)
            )
        ) {
            Text(text = "Select your plan")
        }
    }
}

@ExperimentalPagerApi
fun onBoardingData(): ArrayList<OnBoardingData> {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            image = R.drawable.screen1,
            title = "What are you hungry for?",
            description = "With a range of recipes to choose from, there is something for every taste"
        )
    )

    items.add(
        OnBoardingData(
            image = R.drawable.screen2,
            title = "Add something extra",
            description = "Complement your meals vegetables sides decadent desserts and more"
        )
    )

    items.add(
        OnBoardingData(
            image = R.drawable.screen3,
            title = "Always busy? We can help",
            description = "Tell us when,where,and how you want your box,and we'll make it happen"
        )
    )

    return items

}

@ExperimentalPagerApi
@Composable
fun onBoardingPager(
    items: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column {
                    Box(modifier=Modifier.height(350.dp)) {
                        Image(
                            modifier=Modifier.fillMaxSize(),
                            painter = painterResource(id = items[page].image),
                            contentDescription = items[page].title
                        )
                    }

                    Box(modifier=Modifier.padding(10.dp)) {
                        Column() {
                            Text(text=items[page].title,
                                fontSize = 34.sp)

                            Spacer(modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp))

                            Text(text=items[page].description,
                                fontSize = 18.sp)

                        }
                    }

                    pagerIndicator(size = items.size,pagerState.currentPage)
                }

            }

        }

    }
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @androidx.annotation.IntRange(from = 0) pageCount: Int,
    @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Composable
fun pagerIndicator(size: Int, currentPage: Int) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement=Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)

    ) {
        repeat(size){
            indicator(isSelected = (it==currentPage))
        }
    }
}

@Composable
fun indicator(isSelected:Boolean) {
    Box(modifier = Modifier
        .padding(5.dp)
        .size(10.dp)
        .clip(CircleShape)
        .border(width = 1.dp, color = Color.Black, shape = CircleShape)
        .background(if (isSelected) Color(0xFF1B5E20) else Color.White))
}

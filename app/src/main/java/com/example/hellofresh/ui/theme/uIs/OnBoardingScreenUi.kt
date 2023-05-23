package com.example.hellofresh.ui.theme.uIs

import androidx.annotation.FloatRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hellofresh.BottomSheetScreen
import com.example.hellofresh.OnBoardingData
//import com.example.hellofresh.indicator
//import com.example.hellofresh.pagerIndicator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.example.hellofresh.R




@Composable
@ExperimentalPagerApi
@ExperimentalMaterialApi
fun onBoardingScreenUi(navController: NavController){

    val items = onBoardingData()
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0,
    )

    var sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val bottomSheetObj = BottomSheetScreen()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        loginRow()

        onBoardingPager(
            items = items, pagerState = pagerState, modifier = Modifier
                .fillMaxWidth()
                .height(580.dp)
        )

        selectYourPlanButton(sheetState =sheetState , scope = scope)

    }

    bottomSheetObj.BottomSheet(sheetState,navController)



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
                    Box(modifier= Modifier.height(350.dp)) {
                        Image(
                            modifier= Modifier.fillMaxSize(),
                            painter = painterResource(id = items[page].image),
                            contentDescription = items[page].title
                        )
                    }

                    Box(modifier= Modifier.padding(10.dp)) {
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

@ExperimentalPagerApi
fun onBoardingData(): ArrayList<OnBoardingData> {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            image = R.drawable.screen2,
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
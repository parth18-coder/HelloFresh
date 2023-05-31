package com.example.hellofresh

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hellofresh.navigation.BottomNavItem

@Composable
fun bottomNavigationBar(
    items:List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick:(BottomNavItem)->Unit
){
    var backStackEntry=navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp) {
        items.forEach { item ->
            var selected=item.route==backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected,
                onClick = {onItemClick(item)},
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon={
                    Column() {
                        Icon(
                            imageVector = item.image,
                            contentDescription = null
                        )
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                        )
                    }

            })
        }
        
    }
}


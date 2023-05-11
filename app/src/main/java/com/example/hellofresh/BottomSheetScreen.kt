package com.example.hellofresh

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BottomSheetScreen {
    @Composable
    @ExperimentalMaterialApi
    public fun BottomSheet(sheetState: ModalBottomSheetState) {

        ModalBottomSheetLayout(
            sheetBackgroundColor=Color(0xFFFFFFFF),
            sheetState=sheetState,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .height(350.dp)
                        .fillMaxWidth()
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                        Image(
                            painter = painterResource(id = R.drawable.bottomsheetimage),
                            contentDescription = "Bottom Sheet Image",
                            modifier= Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = "Surprise:Save on your first boxes!",
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
                        )
                        Text(
                            text = "Sign up & get cooking with up to $120 off on your first orders.",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {}, modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF1B5E20),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "I'll take it")
                        }

                        Button(
                            onClick = {}, modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.White,
                                contentColor = Color(0xFF1B5E20)
                            ),
                            border = BorderStroke(1.dp, Color(0xFF1B5E20))
                        ) {
                            Text(text = "Maybe later")
                        }
                    }
                }

            }
        ) {

        }
    }
}
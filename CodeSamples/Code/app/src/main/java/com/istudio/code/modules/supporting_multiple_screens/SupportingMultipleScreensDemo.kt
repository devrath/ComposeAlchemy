package com.istudio.code.modules.supporting_multiple_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.code.modules.supporting_multiple_screens.helpers.WindowSizeClass
import com.istudio.code.modules.supporting_multiple_screens.theme.AppTheme
import com.istudio.code.modules.supporting_multiple_screens.theme.Orientation
import com.istudio.code.ui.composables.AppButton

@Composable
fun SupportingMultipleScreensDemo(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController
) {

    val viewModel: SupportingMultipleScreensViewModel = hiltViewModel()

    if(AppTheme.orientation == Orientation.Portrait){
        // <------------- PORTRAIT MODE ------------->

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){

            Row(

            ) {
                Text(
                    "Hello World",
                    textAlign = TextAlign.Center
                )
            }

            Row(

            ) {
                Button({

                }, Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.mediumLarge),
                    shape = RectangleShape
                ) {
                    Text(
                        text = "Action",
                        textAlign = TextAlign.Center
                    )
                }
            }

        }

    } else {
        // <------------- LANDSCAPE MODE ------------>

    }
}
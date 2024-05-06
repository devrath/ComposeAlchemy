package com.istudio.code.modules.app_foundations.demos.demo_text_unit_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.code.modules.app_foundations.AppFoundationsViewModel
import com.istudio.code.modules.app_foundations.theme.AppTheme
import com.istudio.code.modules.app_foundations.theme.Orientation

@Composable
fun TextUnitTypeCustomScreen(
    navController: NavHostController
) {


    if(AppTheme.orientation == Orientation.Portrait){
        // <------------- PORTRAIT MODE ------------->

        Column(
            modifier = Modifier
                .fillMaxSize().background(Color.Magenta),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){

            Text(
                "Hello",
                textAlign = TextAlign.Center,
                color = Color.White,
                style = MaterialTheme.typography.displayLarge
            )

        }

    } else {
        // <------------- LANDSCAPE MODE ------------>

    }
}
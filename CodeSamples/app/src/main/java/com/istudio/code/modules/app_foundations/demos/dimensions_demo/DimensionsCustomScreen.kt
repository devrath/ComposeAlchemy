package com.istudio.code.modules.app_foundations.demos.dimensions_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.istudio.code.modules.app_foundations.theme.AppTheme

@Composable
fun DimensionsCustomScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){

        Text(
            "HI Custom",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = AppTheme.textUnits.large
        )

    }
}
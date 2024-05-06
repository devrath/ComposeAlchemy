package com.istudio.code.modules.app_foundations.demos.color_demo

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
fun ColorCustomScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){

        Text(
            "Profile User Name",
            textAlign = TextAlign.Center,
            color = AppTheme.colorUnits.profileUserName,
            fontSize = AppTheme.textUnits.large
        )

        Text(
            "Profile Address",
            textAlign = TextAlign.Center,
            color = AppTheme.colorUnits.profileAddress,
            fontSize = AppTheme.textUnits.large
        )
    }
}
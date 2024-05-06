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
fun TextUnitTypeMaterialScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){

        Text(
            "display Large",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.displayLarge
        )

        Text(
            "display Medium",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            "display Small",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            "headline Large",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            "headline Medium",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            "headline Small",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            "title Large",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            "title Medium",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            "title Small",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            "body Large",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            "body Medium",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            "body Small",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            "label Large",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.labelLarge
        )

        Text(
            "label Medium",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            "label Small",
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.labelSmall
        )

    }
}
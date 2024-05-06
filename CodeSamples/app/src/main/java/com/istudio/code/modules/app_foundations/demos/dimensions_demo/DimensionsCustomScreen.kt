package com.istudio.code.modules.app_foundations.demos.dimensions_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.modules.app_foundations.theme.AppTheme

@Composable
fun DimensionsCustomScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(
            text = "Padding applied in widgets",
            color = Color.White
        )

        Spacer(modifier = Modifier.height(50.dp))

       Button(
           onClick = { /*TODO*/ }
       ) {
           val value = AppTheme.dimens.large
           Text(
               modifier = Modifier.padding(AppTheme.dimens.large),
               text = "Large - $value"
           )
       }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ }
        ) {
            val value = AppTheme.dimens.mediumLarge
            Text(
                modifier = Modifier.padding(AppTheme.dimens.mediumLarge),
                text = "Medium Large - $value"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ }
        ) {
            val value = AppTheme.dimens.medium
            Text(
                modifier = Modifier.padding(AppTheme.dimens.medium),
                text = "Medium - $value"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ }
        ) {
            val value = AppTheme.dimens.smallMedium
            Text(
                modifier = Modifier.padding(AppTheme.dimens.smallMedium),
                text = "Small Medium - $value"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ }
        ) {
            val value = AppTheme.dimens.small
            Text(
                modifier = Modifier.padding(AppTheme.dimens.small),
                text = "Small - $value"
            )
        }

    }
}
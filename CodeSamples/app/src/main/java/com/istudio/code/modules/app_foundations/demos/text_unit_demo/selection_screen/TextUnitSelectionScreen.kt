package com.istudio.code.modules.app_foundations.demos.text_unit_demo.selection_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.modules.app_foundations.demo_selection.AppFoundationsDemo
import com.istudio.code.ui.composables.AppButton

@Composable
fun TextUnitSelectionScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Text-Unit Material", onClick = {
            navController.navigate(AppFoundationsDemo.TextUnitTypeMaterialScreen.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Text-Unit Custom", onClick = {
            navController.navigate(AppFoundationsDemo.TextUnitTypeCustomScreen.rout)
        })

    }
}
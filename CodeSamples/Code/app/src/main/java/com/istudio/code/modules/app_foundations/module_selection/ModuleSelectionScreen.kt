package com.istudio.code.modules.app_foundations.module_selection

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.modules.app_foundations.MultipleScreensSupportDemoActivity
import com.istudio.code.ui.composables.AppButton

@Composable
fun ModuleSelectionScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        val context = LocalContext.current

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Text Unit Demos", onClick = {
            navController.navigate(AppFoundationsDemo.TextUnitDemos.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Dimensions Demos", onClick = {
            navController.navigate(AppFoundationsDemo.DimensionsDemos.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Colors Demos", onClick = {
            navController.navigate(AppFoundationsDemo.ColorsDemos.rout)
        })

    }
}
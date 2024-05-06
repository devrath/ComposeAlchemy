package com.istudio.code.module_selection

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
import com.istudio.code.modules.app_foundations.AppFoundationsActivity
import com.istudio.code.ui.composables.AppButton

@Composable
fun ModuleMainSelectionScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        val context = LocalContext.current

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Handling Side Effects", onClick = {
            navController.navigate(ModuleDemo.HandlingSideEffects.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "App Foundations", onClick = {
            //navController.navigate(ModuleDemo.SupportingMultipleScreens.rout)
            context.startActivity(Intent(context, AppFoundationsActivity::class.java))
        })

    }
}
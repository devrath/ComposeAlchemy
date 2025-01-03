package com.istudio.code.modules.state_basics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.module_selection.ModuleDemo
import com.istudio.code.ui.composables.AppButton


@Composable
fun StateBasicsDemo(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        AppButton(text = "Primitive variable as state Demo", onClick = {
            navController.navigate(ModuleDemo.PrimitiveVariableAsStateDemo.rout)
        })

        AppButton(text = "Compose state Demo", onClick = {
            navController.navigate(ModuleDemo.StatesWithComposeDemo.rout)
        })

        AppButton(text = "State with SideEffect Demo", onClick = {
            navController.navigate(ModuleDemo.StatesWithSideEffectDemo.rout)
        })

        AppButton(text = "Updating content of state Demo", onClick = {
            navController.navigate(ModuleDemo.UpdatingContentOfStateDemo.rout)
        })

        AppButton(text = "Stateless Composable Demo", onClick = {
            navController.navigate(ModuleDemo.StatelessComposeDemo.rout)
        })

        AppButton(text = "Number Guess Demo", onClick = {
            navController.navigate(ModuleDemo.NumberGuessDemo.rout)
        })

    }

}




package com.istudio.code.modules.side_effects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.code.module_selection.ModuleDemo
import com.istudio.code.ui.composables.AppButton

@Composable
fun SideEffectsDemo(navController: NavHostController) {

    val viewModel: SideEffectsViewModel = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Side Effect", onClick = {
            navController.navigate(ModuleDemo.SideEffect.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Launched Effect")

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(ModuleDemo.LaunchedEffectDemo1.rout)
            }) {
                Text("Demo-1")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(ModuleDemo.LaunchedEffectDemo2.rout)
            }) {
                Text("Demo-2")
            }

        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Disposable Effect")

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(ModuleDemo.TypeDisposableEffectDemo1.rout)
            }) {
                Text("Demo-1")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(ModuleDemo.TypeDisposableEffectDemo2.rout)
            }) {
                Text("Demo-2")
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Remember Coroutine Scope", onClick = {
            navController.navigate(ModuleDemo.TypeRememberCoroutineScope.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Produce State", onClick = {
            navController.navigate(ModuleDemo.TypeProduceState.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Derived State", onClick = {
            navController.navigate(ModuleDemo.TypeDerivedState.rout)
        })

    }
}
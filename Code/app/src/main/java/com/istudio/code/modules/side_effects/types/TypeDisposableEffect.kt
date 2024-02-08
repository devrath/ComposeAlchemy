package com.istudio.code.modules.side_effects.types

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TypeDisposableEffect(navController: NavHostController) {

    val timeTaken = remember{ mutableIntStateOf(0) }

    println("Root composable composition occurs")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        println("Column composable composition occurs")

        DisposableEffect(Unit) {

            println("DisposableEffect scope is invoked")

            val scope = CoroutineScope(Dispatchers.Default)
            val job = scope.launch {
                while (timeTaken.value<4) {
                    delay(1000)
                    timeTaken.value += 1
                    println("Timer is still working ${timeTaken.value}")
                }
            }

            onDispose {
                job.cancel()
                println("Dispose invoked")
            }
        }

    }

}
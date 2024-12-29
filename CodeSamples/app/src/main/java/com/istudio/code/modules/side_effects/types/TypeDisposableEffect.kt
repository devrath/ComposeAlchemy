package com.istudio.code.modules.side_effects.types

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
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

// ------------------------------------ DEMO-2 ---------------------------------------------------->

@Composable
fun TypeDisposableEffectDemo2(navController: NavHostController) {
    TypeDisposableEffectDemo2Screen()
}

@Composable
fun TypeDisposableEffectDemo2Screen(modifier: Modifier = Modifier) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycle = lifecycleOwner.lifecycle

    DisposableEffect(lifecycle) {
        // Create the observer
        val observer = LifecycleEventObserver { source , event ->
            when(event){
                Lifecycle.Event.ON_CREATE -> println("ON_CREATE is invoked")
                Lifecycle.Event.ON_START -> println("ON_START is invoked")
                Lifecycle.Event.ON_RESUME -> println("ON_RESUME is invoked")
                Lifecycle.Event.ON_PAUSE -> println("ON_PAUSE is invoked")
                Lifecycle.Event.ON_STOP -> println("ON_STOP is invoked")
                Lifecycle.Event.ON_DESTROY -> println("ON_DESTROY is invoked")
                Lifecycle.Event.ON_ANY -> println("ON_ANY is invoked")
            }
        }
        // Add the observer to lifecycle
        lifecycle.addObserver(observer)

        onDispose {
            // Remove the observer from lifecycle
            lifecycle.removeObserver(observer)
        }

    }


}
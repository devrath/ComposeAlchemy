package com.istudio.code.modules.side_effects.types

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.ui.composables.AppButton
import com.istudio.code.ui.theme.CodeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TypeLaunchedEffect(navController: NavHostController) {

    val isLoaderDisplayed = remember { mutableStateOf(false) }
    val data = remember { mutableStateOf(listOf<String>()) }
    val scope = rememberCoroutineScope()

    println("Root composable is composed")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        println("Column composable is composed")

        // This side effect is launched only when the boolean value is true(Initially its false)
        LaunchedEffect(key1 = Unit){

            println("LaunchedEffect is invoked :--> Before fetching the data")
            isLoaderDisplayed.value = true;

            println("Before calling API")
            data.value = fetchData()
            println("After calling API")

            println("LaunchedEffect is invoked :--> After fetching the data")

            // Reset to false
            isLoaderDisplayed.value = false;
        }


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            println("Column composable (parent of button) is composed")

            AppButton(text = "Fetch Data"){
                println("Button click invoked")
                scope.launch {
                    isLoaderDisplayed.value = true
                    data.value = fetchData()
                    isLoaderDisplayed.value = false;
                }
            }
            if (isLoaderDisplayed.value) {
                // Show a loading indicator
                CircularProgressIndicator()
                println("Loader is shown")
            } else {
                // Show the data
                LazyColumn {
                    items(data.value.size) { index ->
                        Text(text = data.value[index])
                    }
                }
                println("List is displayed")
            }
        }

    }

}

// Simulate a network call by suspending the coroutine for 2 seconds
private suspend fun fetchData(): List<String> {
    // Simulate a network delay
    delay(2000)
    println("Inside API call")
    return listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",)
}


// ------------------------------------ DEMO-2 ---------------------------------------------------->
@Composable
fun LaunchedEffectDemo2(navController: NavHostController) {
    LaunchedEffectDemo2Screen()
}

@Composable
fun LaunchedEffectDemo2Screen(modifier: Modifier = Modifier) {

    var counterState by remember { mutableIntStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(counterState) {
        if (counterState % 2 == 0) {
            snackbarHostState.showSnackbar(" $counterState --> It is a even number")
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { counterState++ }
            ) {
                Text(text = "Current Value -> $counterState")
            }
        }
    }

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { LaunchedEffectDemo2Screen() }
}
package com.istudio.code.modules.state_basics.modules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun StatesWithPrimitiveDemo(navController: NavHostController) {
    StatesWithPrimitiveDemoScreen()
}


private var counterState = 0

@Composable
fun StatesWithPrimitiveDemoScreen(modifier: Modifier = Modifier) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    counterState++
                }
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
    CodeTheme { StatesWithPrimitiveDemoScreen() }
}



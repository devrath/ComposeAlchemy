package com.istudio.code.modules.state_basics.modules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun StatelessComposeDemo(navController: NavHostController) {
    CounterDemoScreen()
}

@Composable
fun CounterDemoScreen(modifier: Modifier = Modifier) {

    var counterState by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CounterWidget(
                    modifier = Modifier.fillMaxWidth(),
                    counter = counterState,
                    updateCount = {
                        counterState++
                    }
                )
                Button(
                    modifier = Modifier.wrapContentSize(),
                    onClick = {
                        counterState = 0
                    }
                ) {
                    Text(text = "Reset")
                }
            }

        }
    }

}

@Composable
fun CounterWidget(
    modifier: Modifier = Modifier,
    counter: Int,
    updateCount: (Int)-> Unit
){
    Box(
        modifier = modifier
            .wrapContentSize()
    ) {
        Column {
            Text(text = "Current Value -> $counter")
            Button(
                onClick = {
                    updateCount(counter)
                }
            ) {
                Text(text = "Click to Increment")
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
    CodeTheme { CounterDemoScreen() }
}
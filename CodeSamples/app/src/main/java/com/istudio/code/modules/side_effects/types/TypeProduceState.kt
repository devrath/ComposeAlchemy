package com.istudio.code.modules.side_effects.types

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun TypeProduceState(navController: NavHostController) {
    ProduceStateDemo()
}

@Composable
fun ProduceStateDemo() {
    val counter by produceState(0) {
        // This provides a suspending function
        while (true){
            delay(1000L)
            value += 1
        }
    }

    Text(
        text = counter.toString(),
        modifier = Modifier.fillMaxSize().wrapContentSize()
    )
}


@Preview(
    showBackground = true
)
@Composable
private fun ProduceStateDemoPreview() {
    ProduceStateDemo()
}
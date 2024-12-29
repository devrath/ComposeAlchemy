package com.istudio.code.modules.side_effects.types

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun TypeDerivedState(navController: NavHostController) {
    DerivedStateDemo()
}

@Composable
fun DerivedStateDemo() {

    Log.d("TypeDerivedState-Demo","Composition occurs")
    // We have a state defined in the composable
    var counter by remember { mutableIntStateOf(0) }
    // We now have a derived state
    val calculation by remember {
        Log.d("TypeDerivedState-Demo", "Calculation Triggered")
        derivedStateOf { counter > 3 }
    }

    Log.d("TypeDerivedState-Demo","Counter READ: $calculation")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.d("TypeDerivedState-Demo", "Column is composed")
        Button(
            onClick = {
                counter += 1
                Log.d("TypeDerivedState-Demo", "Click invoked - New value of count = $counter")
            }
        ) {
            Log.d("TypeDerivedState-Demo", "Button is composed")
            Text(text = "CLICK")
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
private fun DerivedStateDemoPreview() {
    DerivedStateDemo()
}
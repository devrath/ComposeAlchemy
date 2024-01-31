package com.istudio.code.modules.side_effects.types

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TypeSideEffect(navController: NavHostController) {

    val count = remember { mutableIntStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        println("Outer Count is ${count.value}")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        println("Column composable is composed")

        Text(text = "${count.value}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count.value++ }) {
            println("Button composable is composed")
            Text(text = "Increase count")
        }

    }
}
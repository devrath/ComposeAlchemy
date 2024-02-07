package com.istudio.code.modules.side_effects.types

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TypeSideEffect(navController: NavHostController) {

    val count = remember { mutableIntStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        println("Root Side effect is triggered")
    }

    println("Root composable is composed")

    Column(
        modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxSize()
            .padding(30.dp)
    ) {

        println("(BLUE) composable is composed")

        SideEffect {
            // Called on every recomposition
            println("Blue composable Side effect is triggered")
        }

        Column(
            modifier = Modifier
                .weight(1f).fillMaxWidth()
                .height(100.dp)
                .background(Color.Green),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            println("(GREEN) composable is composed")

            SideEffect {
                // Called on every recomposition
                println("Green composable Side effect is triggered")
            }

            Text(
                text = "${count.value}",
                color = Color.Magenta,
                fontSize = 38.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = { count.value++ }) {
                println("Button composable is composed")
                Text(text = "Increase count")

                SideEffect {
                    // Called on every recomposition
                    println("Button composable Side effect is triggered")
                }
            }
        }

        Column(
            modifier = Modifier
                .weight(1f).fillMaxWidth()
                .height(100.dp)
                .background(Color.Red),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            println("(RED) composable is composed")

            SideEffect {
                // Called on every recomposition
                println("Red composable Side effect is triggered")
            }
        }
    }

}

@Preview
@Composable
fun Preview(){
    TypeSideEffect(navController = NavHostController(LocalContext.current))
}
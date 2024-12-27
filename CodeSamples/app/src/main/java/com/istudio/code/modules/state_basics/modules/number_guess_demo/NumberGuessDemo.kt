package com.istudio.code.modules.state_basics.modules.number_guess_demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun NumberGuessDemo(navController: NavHostController) {
    NumberGuessDemoScreen()
}

@Composable
fun NumberGuessDemoScreen(modifier: Modifier = Modifier) {



}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { NumberGuessDemoScreen() }
}



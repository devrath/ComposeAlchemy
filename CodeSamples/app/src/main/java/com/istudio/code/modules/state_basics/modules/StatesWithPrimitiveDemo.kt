package com.istudio.code.modules.state_basics.modules

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun StatesWithPrimitiveDemo(navController: NavHostController) {
    StatesWithPrimitiveDemoScreen()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun StatesWithPrimitiveDemoScreen(modifier: Modifier = Modifier) {

    

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { StatesWithPrimitiveDemoScreen() }
}



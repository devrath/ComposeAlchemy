package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun WindowSizeDemo(navController: NavHostController) {
    WindowSizeDemoScreen()
}

@Composable
fun WindowSizeDemoScreen(modifier: Modifier = Modifier) {



}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { WindowSizeDemoScreen() }
}



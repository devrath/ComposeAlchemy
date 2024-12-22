package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowWidthSizeClass
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun WindowSizeDemo(navController: NavHostController) {
    WindowSizeDemoScreen()
}

@Composable
fun WindowSizeDemoScreen(modifier: Modifier = Modifier) {

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            when (windowSizeClass.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT -> {
                    Text(text = "Compact width")
                }

                WindowWidthSizeClass.MEDIUM -> {
                    Text(text = "Medium width")
                }

                WindowWidthSizeClass.EXPANDED -> {
                    Text(text = "Expanded width")
                }

                else -> {
                    Text(text = "Unknown width")
                }
            }
        }
    }


}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF,
    device = "spec:width=411dp,height=891dp"
)
@Composable
private fun CurrentScreenPhonePreview() {
    CodeTheme { WindowSizeDemoScreen() }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF,
    device = "spec:width=1280dp,height=800dp,dpi=240"
)
@Composable
private fun CurrentScreenTabletPreview() {
    CodeTheme { WindowSizeDemoScreen() }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF,
    device = "spec:width=673dp,height=841dp"
)
@Composable
private fun CurrentScreenFoldablePreview() {
    CodeTheme { WindowSizeDemoScreen() }
}




package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme
import com.istudio.code.utils.setWidthMode

@Composable
fun BoxDemo(navController: NavHostController) {
    BoxDemoScreen()
}

@Composable
fun BoxDemoScreen(modifier: Modifier = Modifier) {

    Box(
        contentAlignment = Alignment.BottomEnd
    ) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan))
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Magenta))
    }

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { BoxDemoScreen() }
}



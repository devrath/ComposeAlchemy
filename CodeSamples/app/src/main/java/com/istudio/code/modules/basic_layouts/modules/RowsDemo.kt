@file:OptIn(ExperimentalMaterial3Api::class)

package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
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
fun RowsDemo(navController: NavHostController) {
    CurrentRowScreen()
}

@Composable
fun CurrentRowScreen(modifier: Modifier = Modifier) {

    var isFullWidth by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { isFullWidth = !isFullWidth }) {
            Text(if (isFullWidth) "Switch to Wrap Content" else "Switch to Fill Max Width")
        }

        Text("Space Evenly")
        Row(
            modifier = Modifier.setWidthMode(isFullWidth),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta))
        }
        Text("Space Around")
        Row(
            modifier = Modifier.setWidthMode(isFullWidth),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta))
        }
        Text("Space Between")
        Row(
            modifier = Modifier.setWidthMode(isFullWidth),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta))
        }
        Text("Start")
        Row(
            modifier = Modifier.setWidthMode(isFullWidth),
            horizontalArrangement = Arrangement.Start
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta))
        }
        Text("Center")
        Row(
            modifier = Modifier.setWidthMode(isFullWidth),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta))
        }
        Text("End")
        Row(
            modifier = Modifier.setWidthMode(isFullWidth),
            horizontalArrangement = Arrangement.End
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan))
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.Magenta))
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { CurrentRowScreen() }
}



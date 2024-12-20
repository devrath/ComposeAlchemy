@file:OptIn(ExperimentalMaterial3Api::class)

package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.istudio.code.utils.setHeightMode

@Composable
fun ColumnDemo(navController: NavHostController) {
    CurrentColumnScreen()
}

@Composable
fun CurrentColumnScreen(modifier: Modifier = Modifier) {
    var isFullHeight by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.wrapContentWidth().wrapContentHeight().padding(10.dp),
            onClick = { isFullHeight = !isFullHeight }
        ) {
            Text(if (isFullHeight) "Switch to Wrap Content" else "Switch to Fill Max Height")
        }

        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {


            Column(
                modifier = Modifier.setHeightMode(isFullHeight).padding(5.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Cyan))
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Magenta))
            }
            Column(
                modifier = Modifier.setHeightMode(isFullHeight).padding(5.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Cyan))
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Magenta))
            }
            Column(
                modifier = Modifier.setHeightMode(isFullHeight).padding(5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Cyan))
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Magenta))
            }
            Column(
                modifier = Modifier.setHeightMode(isFullHeight).padding(5.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Cyan))
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Magenta))
            }
            Column(
                modifier = Modifier.setHeightMode(isFullHeight).padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Cyan))
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Magenta))
            }
            Column(
                modifier = Modifier.setHeightMode(isFullHeight).padding(5.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Cyan))
                Box(modifier = Modifier
                    .size(40.dp)
                    .background(Color.Magenta))
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { CurrentColumnScreen() }
}

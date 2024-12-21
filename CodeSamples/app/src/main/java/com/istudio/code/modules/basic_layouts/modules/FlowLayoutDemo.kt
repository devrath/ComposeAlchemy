package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun FlowLayoutDemo(navController: NavHostController) {
    FlowLayoutDemoScreen()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemoScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            maxItemsInEachRow = Int.MAX_VALUE,
        ) {
            for (i in 1..40) {
                AssistChip(
                    onClick = {},
                    label = {
                        Text("Item-$i")
                    }
                )
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
    CodeTheme { FlowLayoutDemoScreen() }
}



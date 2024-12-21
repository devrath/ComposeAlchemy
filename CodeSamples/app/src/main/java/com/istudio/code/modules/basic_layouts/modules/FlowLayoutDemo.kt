package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var isExpanded by remember { mutableStateOf(false) } // State to track expansion

    val items = (1..40).toList() // Sample data

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachRow = Int.MAX_VALUE
        ) {

            // Show only the first few items when collapsed, show all when expanded
            val visibleItems = if (isExpanded) items else items.take(10)
            val expandedItemsIndicator = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
            val description = if (isExpanded) "Collapse" else "Expand"
            
            // Render visible items
            visibleItems.forEach { item ->
                AssistChip(
                    onClick = {},
                    label = { Text("Item-$item") }
                )
            }

            // Expand/Collapse Indicator
            if (items.size > 10) {
                IconButton(
                    onClick = { isExpanded = !isExpanded } // Toggle expand/collapse
                ) {
                    Icon(
                        imageVector = expandedItemsIndicator,
                        contentDescription = description
                    )
                }
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



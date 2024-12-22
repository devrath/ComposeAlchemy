package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun LazyListDemo(navController: NavHostController) {
    LazyListDemoScreen()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyListDemoScreen(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        stickyHeader(
            key = "Header-1"
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(100.dp).background(color = Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "Header-1"
                )
            }
        }

        for (i in 1..15){
            item{
                Box(
                    modifier = Modifier.padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        text = "Content-$i"
                    )
                }
            }
        }

        stickyHeader(
            key = "Header-2"
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(100.dp).background(color = Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "Header-2"
                )
            }
        }

        for (i in 1..15){
            item{
                Box(
                    modifier = Modifier.padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        text = "Content-$i"
                    )
                }
            }
        }

        stickyHeader(
            key = "Header-3"
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(100.dp).background(color = Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "Header-3"
                )
            }
        }

        for (i in 1..15){
            item{
                Box(
                    modifier = Modifier.padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        text = "Content-$i"
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
    CodeTheme { LazyListDemoScreen() }
}



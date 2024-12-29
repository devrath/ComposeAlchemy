package com.istudio.code.modules.side_effects.types

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun TypeDerivedState(navController: NavHostController) {
    DerivedStateDemo()
}

@Composable
fun DerivedStateDemo() {


    Text(
        text = "hi",
        modifier = Modifier.fillMaxSize().wrapContentSize()
    )
}


@Preview(
    showBackground = true
)
@Composable
private fun DerivedStateDemoPreview() {
    DerivedStateDemo()
}
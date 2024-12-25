package com.istudio.code.modules.state_basics.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun UpdatingContentOfStateDemo(navController: NavHostController) {
    UpdatingContentOfStateDemoScreen()
}

@Composable
fun UpdatingContentOfStateDemoScreen(modifier: Modifier = Modifier) {

    var updateReference by remember { mutableStateOf(listOf("<-Item->")) }
    var updateContentOfReference by remember { mutableStateOf(mutableListOf<String>("<-Item->")) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().weight(1F).background(color = Color.Cyan)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(text = updateReference.toString())

                    Button(onClick = {
                        updateReference = updateReference.plus("<-Item->")
                    }) {
                        Text(text = "Update references")
                    }
                }

            }
            Column(
                modifier = Modifier.fillMaxSize().weight(1F).background(color = Color.DarkGray)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(text = updateContentOfReference.toString())


                    Button(onClick = {
                        updateContentOfReference.add("<-Item->")
                    }) {
                        Text(text = "Update content of reference")
                    }
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
    CodeTheme { UpdatingContentOfStateDemoScreen() }
}



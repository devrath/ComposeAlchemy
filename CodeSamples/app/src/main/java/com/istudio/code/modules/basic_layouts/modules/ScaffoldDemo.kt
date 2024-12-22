package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme
import kotlinx.coroutines.launch

@Composable
fun ScaffoldDemo(navController: NavHostController) {
    ScaffoldDemoScreen()
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDemoScreen(modifier: Modifier = Modifier) {

    val snackBarState = remember { SnackbarHostState() }
    val snackBarScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Title")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                snackBarScope.launch {
                    snackBarState.showSnackbar(message = "Hello World")
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Place")
            }
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarState
            )
        },
        bottomBar = {
            BottomAppBar {
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text(text = "Home")
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile"
                        )
                    },
                    label = {
                        Text(text = "Profile")
                    }
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
                .padding(padding),
            contentAlignment = Alignment.Center
        ){
            Text("Content")
        }

    }

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { ScaffoldDemoScreen() }
}



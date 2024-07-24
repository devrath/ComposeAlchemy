@file:OptIn(ExperimentalMaterial3Api::class)

package com.istudio.code.modules.ui_demos.modules

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavHostController
import com.istudio.code.databinding.SimpleViewOneBinding
import com.istudio.code.databinding.SimpleViewOneBinding.inflate

@Composable
fun ToolbarMenuDropDownDemo(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { CustomTopAppBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(innerPadding)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            val context = LocalContext.current
            // Using the xml with view binding in compose
            Text(text = "Screen Content")
        }
    }
}

@Composable
private fun CustomTopAppBar() {
    TopAppBar(title = { CustomTopAppBarTitle() })
}

@Composable
private fun CustomTopAppBarTitle() = Row {

}




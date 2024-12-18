package com.istudio.code.modules.basic_layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.code.module_selection.ModuleDemo
import com.istudio.code.ui.composables.AppButton


@Composable
fun BasicLayoutsDemo(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        AppButton(text = "Rows Demo", onClick = {
            navController.navigate(ModuleDemo.RowsDemo.rout)
        })

        AppButton(text = "Column Demo", onClick = {
            navController.navigate(ModuleDemo.ColumnDemo.rout)
        })

    }

}




package com.istudio.code.modules.basic_layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

        AppButton(text = "Rows Arrangement Demo", onClick = {
            navController.navigate(ModuleDemo.RowsArrangementDemo.rout)
        })

        AppButton(text = "Column Arrangement Demo", onClick = {
            navController.navigate(ModuleDemo.ColumnArrangementDemo.rout)
        })

        AppButton(text = "Rows Spaced By Demo", onClick = {
            navController.navigate(ModuleDemo.RowsSpacedByDemo.rout)
        })

        AppButton(text = "Rows Weights Demo", onClick = {
            navController.navigate(ModuleDemo.RowsSpacedByDemo.rout)
        })

        AppButton(text = "Box Demo", onClick = {
            navController.navigate(ModuleDemo.BoxDemo.rout)
        })

        AppButton(text = "Flow Layout Demo", onClick = {
            navController.navigate(ModuleDemo.FlowLayoutDemo.rout)
        })

    }

}




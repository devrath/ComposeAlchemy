package com.istudio.code.modules.pagination

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
fun PaginationSelection(navController: NavHostController) {

    val viewModel: PaginationSelectionViewModel = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Beer List", onClick = {
            navController.navigate(ModuleDemo.PaginationDemo.rout)
        })

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Quotes List", onClick = {
            navController.navigate(ModuleDemo.QuotesDemo.rout)
        })

    }
}
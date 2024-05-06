package com.istudio.code.modules.app_foundations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.istudio.code.module_selection.ModuleDemo
import com.istudio.code.module_selection.ModuleMainSelectionScreen
import com.istudio.code.modules.app_foundations.demo_selection.AppFoundationsDemo
import com.istudio.code.modules.app_foundations.helpers.rememberWindowSizeClass
import com.istudio.code.modules.app_foundations.demo_selection.AppFoundationsSelectionScreen
import com.istudio.code.modules.app_foundations.theme.CustomTheme
import com.istudio.code.ui.theme.CodeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppFoundationsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = rememberWindowSizeClass()
            CustomTheme(window) {
                val navController = rememberNavController()
                AppFoundationsSelectionScreen(navController = navController)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = AppFoundationsDemo.MainSelection.rout
                    ) {
                        // Selection Screen
                        composable(AppFoundationsDemo.MainSelection.rout) {
                            AppFoundationsSelectionScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

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
import com.istudio.code.modules.app_foundations.demo_selection.AppFoundationsDemo
import com.istudio.code.modules.app_foundations.demo_selection.AppFoundationsSelectionScreen
import com.istudio.code.modules.app_foundations.demos.dimensions_demo.DimensionsCustomScreen
import com.istudio.code.modules.app_foundations.demos.dimensions_demo.selection_screen.DimensionsSelectionScreen
import com.istudio.code.modules.app_foundations.demos.text_unit_demo.TextUnitTypeCustomScreen
import com.istudio.code.modules.app_foundations.demos.text_unit_demo.TextUnitTypeMaterialScreen
import com.istudio.code.modules.app_foundations.demos.text_unit_demo.selection_screen.TextUnitSelectionScreen
import com.istudio.code.modules.app_foundations.helpers.rememberWindowSizeClass
import com.istudio.code.modules.app_foundations.theme.CustomTheme
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
                        // <----------------------> Type Scale
                        // Type Scale : SELECTION-SCREEN
                        composable(AppFoundationsDemo.TextUnitDemos.rout) {
                            TextUnitSelectionScreen(navController = navController)
                        }
                        // Type Scale : Material
                        composable(AppFoundationsDemo.TextUnitTypeMaterialScreen.rout) {
                            TextUnitTypeMaterialScreen(navController = navController)
                        }
                        // Type Scale : Custom
                        composable(AppFoundationsDemo.TextUnitTypeCustomScreen.rout) {
                            TextUnitTypeCustomScreen(navController = navController)
                        }
                        // <----------------------> Type Scale
                        // <----------------------> Dimensions
                        // Dimensions: SELECTION-SCREEN
                        composable(AppFoundationsDemo.DimensionsDemos.rout) {
                            DimensionsSelectionScreen(navController = navController)
                        }
                        // Dimensions : Custom
                        composable(AppFoundationsDemo.DimensionsCustomScreen.rout) {
                            DimensionsCustomScreen(navController = navController)
                        }
                        // <----------------------> Dimensions

                    }
                }
            }
        }
    }
}

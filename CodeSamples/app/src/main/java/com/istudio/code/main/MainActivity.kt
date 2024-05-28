package com.istudio.code.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.istudio.code.module_selection.ModuleDemo
import com.istudio.code.module_selection.ModuleMainSelectionScreen
import com.istudio.code.modules.life_cycle.LifeCycleDemo
import com.istudio.code.modules.pagination.PaginationSelection
import com.istudio.code.modules.pagination.sample_beer_list.PaginationDemo
import com.istudio.code.modules.pagination.quotes_list.QuotesDemo
import com.istudio.code.modules.side_effects.SideEffectsDemo
import com.istudio.code.modules.side_effects.types.TypeDisposableEffect
import com.istudio.code.modules.side_effects.types.TypeLaunchedEffect
import com.istudio.code.modules.side_effects.types.TypeRememberCoroutineScope
import com.istudio.code.modules.side_effects.types.TypeSideEffect
import com.istudio.code.ui.theme.CodeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = ModuleDemo.DemoSelection.rout
                    ) {
                        // Selection Screen
                        composable(ModuleDemo.DemoSelection.rout) {
                            ModuleMainSelectionScreen(navController = navController)
                        }
                        // Side Effect - Selection
                        composable(ModuleDemo.HandlingSideEffects.rout) {
                            SideEffectsDemo(navController = navController)
                        }
                        // Side Effect
                        composable(ModuleDemo.SideEffect.rout) {
                            TypeSideEffect(navController = navController)
                        }
                        // Launched Effect
                        composable(ModuleDemo.LaunchedEffect.rout) {
                            TypeLaunchedEffect(navController = navController)
                        }
                        // Disposable Effect
                        composable(ModuleDemo.TypeDisposableEffect.rout) {
                            TypeDisposableEffect(navController = navController)
                        }
                        // Remember Coroutine Scope
                        composable(ModuleDemo.TypeRememberCoroutineScope.rout) {
                            TypeRememberCoroutineScope(navController = navController)
                        }
                        // Life cycle of Compose
                        composable(ModuleDemo.LifeCycleDemo.rout) {
                            LifeCycleDemo(navController = navController)
                        }
                        // Selection: Pagination screen
                        composable(ModuleDemo.PaginationSelection.rout) {
                            PaginationSelection(navController = navController)
                        }
                        // Pagination Demo
                        composable(ModuleDemo.PaginationDemo.rout) {
                            PaginationDemo(navController = navController)
                        }
                        // Quotes Demo
                        composable(ModuleDemo.QuotesDemo.rout) {
                            QuotesDemo(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
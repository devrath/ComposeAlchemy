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
import com.istudio.code.modules.basic_layouts.BasicLayoutsDemo
import com.istudio.code.modules.basic_layouts.modules.BoxDemo
import com.istudio.code.modules.basic_layouts.modules.ColumnDemo
import com.istudio.code.modules.basic_layouts.modules.FlowLayoutDemo
import com.istudio.code.modules.basic_layouts.modules.LazyListDemo
import com.istudio.code.modules.basic_layouts.modules.RowsDemo
import com.istudio.code.modules.basic_layouts.modules.RowsSpacedByDemo
import com.istudio.code.modules.basic_layouts.modules.RowsWeightsDemo
import com.istudio.code.modules.basic_layouts.modules.ScaffoldDemo
import com.istudio.code.modules.basic_layouts.modules.WindowSizeDemo
import com.istudio.code.modules.interoperability_apis.InteroperabilityApisDemo
import com.istudio.code.modules.interoperability_apis.modules.ViewsInComposeDemo
import com.istudio.code.modules.life_cycle.LifeCycleDemo
import com.istudio.code.modules.pagination.QuotesDemo
import com.istudio.code.modules.side_effects.SideEffectsDemo
import com.istudio.code.modules.side_effects.types.TypeDisposableEffect
import com.istudio.code.modules.side_effects.types.TypeLaunchedEffect
import com.istudio.code.modules.side_effects.types.TypeRememberCoroutineScope
import com.istudio.code.modules.side_effects.types.TypeSideEffect
import com.istudio.code.modules.state_basics.StateBasicsDemo
import com.istudio.code.modules.state_basics.modules.StatesWithComposeDemo
import com.istudio.code.modules.state_basics.modules.StatesWithPrimitiveDemo
import com.istudio.code.modules.state_basics.modules.StatesWithSideEffectDemo
import com.istudio.code.modules.ui_demos.UiDemo
import com.istudio.code.modules.ui_demos.modules.ToolbarMenuDropDownDemo
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
                        // Quotes Demo
                        composable(ModuleDemo.QuotesDemo.rout) {
                            QuotesDemo(navController = navController)
                        }
                        // Interoperability Demo
                        composable(ModuleDemo.InteroperabilityApis.rout) {
                            InteroperabilityApisDemo(navController = navController)
                        }
                        // Views in Compose Demo
                        composable(ModuleDemo.ViewsInCompose.rout) {
                            ViewsInComposeDemo(navController = navController)
                        }
                        // UI in Demo
                        composable(ModuleDemo.UiDemo.rout) {
                            UiDemo(navController = navController)
                        }
                        // Toolbar menu drop down
                        composable(ModuleDemo.ToolbarMenuDropDown.rout) {
                            ToolbarMenuDropDownDemo(navController = navController)
                        }
                        // Basic Layouts
                        composable(ModuleDemo.BasicLayouts.rout) {
                            BasicLayoutsDemo(navController = navController)
                        }
                        // Basic Layouts --> Rows Demo
                        composable(ModuleDemo.RowsArrangementDemo.rout) {
                            RowsDemo(navController = navController)
                        }
                        // Basic Layouts --> Column Demo
                        composable(ModuleDemo.ColumnArrangementDemo.rout) {
                            ColumnDemo(navController = navController)
                        }
                        // Basic Layouts --> Rows SpacedBy Demo
                        composable(ModuleDemo.RowsSpacedByDemo.rout) {
                            RowsSpacedByDemo(navController = navController)
                        }
                        // Basic Layouts --> Rows Weights Demo
                        composable(ModuleDemo.RowsWeightsDemo.rout) {
                            RowsWeightsDemo(navController = navController)
                        }
                        // Basic Layouts --> Box Demo
                        composable(ModuleDemo.BoxDemo.rout) {
                            BoxDemo(navController = navController)
                        }
                        // Basic Layouts --> Flow Layout Demo
                        composable(ModuleDemo.FlowLayoutDemo.rout) {
                            FlowLayoutDemo(navController = navController)
                        }
                        // Basic Layouts --> Lazy List Demo
                        composable(ModuleDemo.LazyListDemo.rout) {
                            LazyListDemo(navController = navController)
                        }
                        // Basic Layouts --> Scaffold Demo
                        composable(ModuleDemo.ScaffoldDemo.rout) {
                            ScaffoldDemo(navController = navController)
                        }
                        // Basic Layouts --> WindowSize Demo
                        composable(ModuleDemo.WindowSizeDemo.rout) {
                            WindowSizeDemo(navController = navController)
                        }
                        // State Basics --> Selection
                        composable(ModuleDemo.StateBasics.rout) {
                            StateBasicsDemo(navController = navController)
                        }
                        // State Basics --> Primitive variables as states
                        composable(ModuleDemo.PrimitiveVariableAsStateDemo.rout) {
                            StatesWithPrimitiveDemo(navController = navController)
                        }
                        // State Basics --> Compose state
                        composable(ModuleDemo.StatesWithComposeDemo.rout) {
                            StatesWithComposeDemo(navController = navController)
                        }
                        // State Basics --> State with side effect
                        composable(ModuleDemo.StatesWithSideEffectDemo.rout) {
                            StatesWithSideEffectDemo(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
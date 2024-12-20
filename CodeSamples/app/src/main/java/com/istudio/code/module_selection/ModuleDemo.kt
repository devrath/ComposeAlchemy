package com.istudio.code.module_selection

sealed class ModuleDemo(val rout: String) {
    data object DemoSelection : ModuleDemo("DemoSelection")
    data object HandlingSideEffects : ModuleDemo("HandlingSideEffects")
    data object SideEffect : ModuleDemo("SideEffect")
    data object LaunchedEffect : ModuleDemo("LaunchedEffect")
    data object TypeDisposableEffect : ModuleDemo("TypeDisposableEffect")
    data object TypeRememberCoroutineScope : ModuleDemo("TypeRememberCoroutineScope")
    data object LifeCycleDemo : ModuleDemo("LifeCycleDemo")
    data object SupportingMultipleScreens : ModuleDemo("SupportingMultipleScreens")
    data object QuotesDemo : ModuleDemo("QuotesDemo")
    data object InteroperabilityApis : ModuleDemo("InteroperabilityApis")
    data object ViewsInCompose : ModuleDemo("ViewsInCompose")
    data object UiDemo : ModuleDemo("UiDemo")
    data object ToolbarMenuDropDown : ModuleDemo("ToolbarMenuDropDown")
    data object BasicLayouts : ModuleDemo("BasicLayouts")
    data object RowsArrangementDemo : ModuleDemo("RowsArrangementDemo")
    data object ColumnArrangementDemo : ModuleDemo("ColumnArrangementDemo")
    data object RowsSpacedByDemo : ModuleDemo("RowsSpacedByDemo")
    data object RowsWeightsDemo : ModuleDemo("RowsWeightsDemo")
}
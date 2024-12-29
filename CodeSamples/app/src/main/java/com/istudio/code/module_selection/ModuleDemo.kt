package com.istudio.code.module_selection

sealed class ModuleDemo(val rout: String) {
    data object DemoSelection : ModuleDemo("DemoSelection")
    data object HandlingSideEffects : ModuleDemo("HandlingSideEffects")
    data object SideEffect : ModuleDemo("SideEffect")
    data object LaunchedEffectDemo1 : ModuleDemo("LaunchedEffectDemo1")
    data object LaunchedEffectDemo2 : ModuleDemo("LaunchedEffectDemo2")
    data object TypeDisposableEffectDemo1 : ModuleDemo("TypeDisposableEffectDemo1")
    data object TypeDisposableEffectDemo2 : ModuleDemo("TypeDisposableEffectDemo2")
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
    data object BoxDemo : ModuleDemo("BoxDemo")
    data object FlowLayoutDemo : ModuleDemo("FlowLayoutDemo")
    data object LazyListDemo : ModuleDemo("LazyListDemo")
    data object ScaffoldDemo : ModuleDemo("ScaffoldDemo")
    data object WindowSizeDemo : ModuleDemo("WindowSizeDemo")
    data object StateBasics : ModuleDemo("StateBasics")
    data object PrimitiveVariableAsStateDemo : ModuleDemo("PrimitiveVariableAsStateDemo")
    data object StatesWithComposeDemo : ModuleDemo("StatesWithComposeDemo")
    data object StatesWithSideEffectDemo : ModuleDemo("StatesWithSideEffectDemo")
    data object UpdatingContentOfStateDemo : ModuleDemo("UpdatingContentOfStateDemo")
    data object StatelessComposeDemo : ModuleDemo("StatelessComposeDemo")
    data object NumberGuessDemo : ModuleDemo("NumberGuessDemo")
    data object TypeProduceState : ModuleDemo("TypeProduceState")
    data object TypeDerivedState : ModuleDemo("TypeDerivedState")
}
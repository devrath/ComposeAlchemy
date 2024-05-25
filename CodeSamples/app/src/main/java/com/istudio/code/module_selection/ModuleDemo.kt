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

    data object PaginationSelection : ModuleDemo("PaginationSelection")
    data object PaginationDemo : ModuleDemo("PaginationDemo")
    data object QuotesDemo : ModuleDemo("QuotesDemo")
}
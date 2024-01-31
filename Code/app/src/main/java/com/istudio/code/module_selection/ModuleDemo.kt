package com.istudio.code.module_selection
sealed class ModuleDemo(val rout: String) {

    data object DemoSelection : ModuleDemo("DemoSelection")
    data object HandlingSideEffects : ModuleDemo("HandlingSideEffects")
    data object SideEffect : ModuleDemo("SideEffect")
    data object LaunchedEffect : ModuleDemo("LaunchedEffect")
    data object TypeDisposableEffect : ModuleDemo("TypeDisposableEffect")

}
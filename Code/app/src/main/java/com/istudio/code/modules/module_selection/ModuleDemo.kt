package com.istudio.code.modules.module_selection
sealed class ModuleDemo(val rout: String) {

    data object DemoSelection : ModuleDemo("DemoSelection")


}
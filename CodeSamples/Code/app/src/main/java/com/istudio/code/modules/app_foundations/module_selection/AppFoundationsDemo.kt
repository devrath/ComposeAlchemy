package com.istudio.code.modules.app_foundations.module_selection


sealed class AppFoundationsDemo(val rout: String) {

    data object MainSelection : AppFoundationsDemo("MainSelection")
    data object TextUnitDemos : AppFoundationsDemo("TextUnitDemos")
    data object DimensionsDemos : AppFoundationsDemo("DimensionsDemos")
    data object ColorsDemos : AppFoundationsDemo("ColorsDemos")

}
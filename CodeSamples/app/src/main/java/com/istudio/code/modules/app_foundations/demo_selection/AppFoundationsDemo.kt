package com.istudio.code.modules.app_foundations.demo_selection


sealed class AppFoundationsDemo(val rout: String) {

    data object MainSelection : AppFoundationsDemo("MainSelection")
    data object TextUnitDemos : AppFoundationsDemo("TextUnitDemos")
    data object DimensionsDemos : AppFoundationsDemo("DimensionsDemos")
    data object ColorsDemos : AppFoundationsDemo("ColorsDemos")

    // <----------> TextUnit
    data object TextUnitTypeMaterialScreen : AppFoundationsDemo("TextUnitTypeMaterialScreen")
    data object TextUnitTypeCustomScreen : AppFoundationsDemo("TextUnitTypeCustomScreen")
    // <----------> TextUnit

    // <----------> Dimensions
    data object DimensionsMaterialScreen : AppFoundationsDemo("DimensionsMaterialScreen")
    data object DimensionsCustomScreen : AppFoundationsDemo("DimensionsCustomScreen")
    // <----------> Dimensions


}
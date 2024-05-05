package com.istudio.code.modules.supporting_multiple_screens.helpers

sealed class WindowSize(val size:Int){
    data class Small(val smallSize:Int):WindowSize(smallSize)
    data class Compact(val compactSize:Int):WindowSize(compactSize)
    data class Medium(val mediumSize:Int):WindowSize(mediumSize)
    data class Large(val largeSize:Int):WindowSize(largeSize)
}
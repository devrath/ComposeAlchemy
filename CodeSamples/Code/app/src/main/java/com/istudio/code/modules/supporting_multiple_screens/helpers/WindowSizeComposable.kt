package com.istudio.code.modules.supporting_multiple_screens.helpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

/**
 * We will call this class at the beginning of the root composable of the project to calculate the width and height
 * It will be called again once the orientation change occurs
 */
@Composable
fun windowSizeComposable() : WindowSizeData{

    val config = LocalConfiguration.current

    val width by remember(config){ mutableIntStateOf(config.screenWidthDp) }

    val height by remember(config){ mutableIntStateOf(config.screenHeightDp) }

    val windowWidthClass = when {
        width <= 360 -> WindowSize.Small(width)
        width in 361..480 -> WindowSize.Compact(width)
        width in 481..720 -> WindowSize.Medium(width)
        else -> WindowSize.Large(width)
    }

    val windowHeightClass = when {
        height <= 360 -> WindowSize.Small(height)
        height in 361..480 -> WindowSize.Compact(height)
        height in 481..720 -> WindowSize.Medium(height)
        else -> WindowSize.Large(height)
    }

    return WindowSizeData(windowWidthClass, windowHeightClass)

}
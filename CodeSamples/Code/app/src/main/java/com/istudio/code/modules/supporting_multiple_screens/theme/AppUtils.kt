package com.istudio.code.modules.supporting_multiple_screens.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

/**
 * This take dimensions, orientation and content
 */
@Composable
fun ProvideAppUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    content: @Composable () ->Unit
) {
    val dimSet = remember{dimensions}
    val orientationSet = remember{orientation}

    CompositionLocalProvider(
        LocalAppDimens provides dimSet,
        LocalOrientationMode provides orientationSet,
        content = content
    )
}

val LocalAppDimens = compositionLocalOf {
    smallDimensions
}

val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait
}
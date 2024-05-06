package com.istudio.code.modules.app_foundations.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.istudio.code.modules.app_foundations.theme.custom.CustomColors
import com.istudio.code.modules.app_foundations.theme.custom.CustomDimensions
import com.istudio.code.modules.app_foundations.theme.custom.CustomTextUnits
import com.istudio.code.modules.app_foundations.theme.custom.customColorsLightTheme
import com.istudio.code.modules.app_foundations.theme.custom.smallCustomDimensions
import com.istudio.code.modules.app_foundations.theme.custom.smallCustomTextUnits

/**
 * This take dimensions, orientation and content
 */
@Composable
fun ProvideAppUtils(
    customDimensions: CustomDimensions,
    customTextUnits: CustomTextUnits,
    colors: CustomColors,
    orientation: Orientation,
    content: @Composable () -> Unit,
) {
    val dimSet = remember{customDimensions}
    val textSet = remember{customTextUnits}
    val colorsSet = remember{colors}
    val orientationSet = remember{orientation}

    CompositionLocalProvider(
        LocalAppDimens provides dimSet,
        LocalAppTextUnits provides textSet,
        LocalColorSelection provides colorsSet,
        LocalOrientationMode provides orientationSet,
        content = content
    )
}

// Custom Spacing Dimensions
val LocalAppDimens = compositionLocalOf {
    smallCustomDimensions
}
// Custom TextUnit Dimensions
val LocalAppTextUnits = compositionLocalOf {
    smallCustomTextUnits
}
// Custom TextUnit Dimensions
val LocalColorSelection = compositionLocalOf {
    customColorsLightTheme
}
// Current orientation
val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait
}
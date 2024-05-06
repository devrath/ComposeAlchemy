package com.istudio.code.modules.app_foundations.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.istudio.code.modules.app_foundations.helpers.WindowSize
import com.istudio.code.modules.app_foundations.helpers.WindowSizeClass
import com.istudio.code.modules.app_foundations.theme.custom.CustomColors
import com.istudio.code.modules.app_foundations.theme.custom.CustomDimensions
import com.istudio.code.modules.app_foundations.theme.custom.CustomTextUnits
import com.istudio.code.modules.app_foundations.theme.custom.compactCustomDimensions
import com.istudio.code.modules.app_foundations.theme.custom.compactCustomTextUnits
import com.istudio.code.modules.app_foundations.theme.custom.customColorsDarkTheme
import com.istudio.code.modules.app_foundations.theme.custom.customColorsLightTheme
import com.istudio.code.modules.app_foundations.theme.custom.largeCustomDimensions
import com.istudio.code.modules.app_foundations.theme.custom.largeCustomTextUnits
import com.istudio.code.modules.app_foundations.theme.custom.mediumCustomDimensions
import com.istudio.code.modules.app_foundations.theme.custom.mediumCustomTextUnits
import com.istudio.code.modules.app_foundations.theme.custom.smallCustomDimensions
import com.istudio.code.modules.app_foundations.theme.custom.smallCustomTextUnits

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun CustomTheme(
    windowSizeClass: WindowSizeClass,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    /** ***************** Determine the orientation *****************
     * if(Width > Height) { LANDSCAPE } else { PORTRAIT }
     ** ***************** Determine the orientation ***************** **/
    val orientation = when{
        windowSizeClass.width.size > windowSizeClass.height.size -> Orientation.Landscape
        else -> Orientation.Portrait
    }

    /** ***************** Determine the size preference *****************
     * if(PORTRAIT) { Width is Preference } else { Height is Preference }
     ** ***************** Determine the size preference ***************** **/
    val sizeThatMatters = when(orientation){
        Orientation.Portrait -> windowSizeClass.width
        else -> windowSizeClass.height
    }

    /** ***************** Determine the dimensions *****************
     * Based on size determine the dimensions
     ** ***************** Determine the dimensions ***************** **/
    val dimensions = when(sizeThatMatters){
        is WindowSize.Small -> smallCustomDimensions
        is WindowSize.Compact -> compactCustomDimensions
        is WindowSize.Medium -> mediumCustomDimensions
        else -> largeCustomDimensions
    }

    /** ***************** Determine the dimensions *****************
     * Based on size determine the text-unit
     ** ***************** Determine the dimensions ***************** **/
    val textUnits = when(sizeThatMatters){
        is WindowSize.Small -> smallCustomTextUnits
        is WindowSize.Compact -> compactCustomTextUnits
        is WindowSize.Medium -> mediumCustomTextUnits
        else -> largeCustomTextUnits
    }

    /** ***************** Determine the dimensions *****************
     * Based on size determine the typography
     ** ***************** Determine the dimensions ***************** **/
    val typography = when(sizeThatMatters){
        is WindowSize.Small -> typographySmall
        is WindowSize.Compact -> typographyCompact
        is WindowSize.Medium -> typographyMedium
        else -> typographyBig
    }

    /** ***************** Determine the colors *****************
     * Based on darkTheme flag, Determine the color palette
     ** ***************** Determine the colors ***************** **/
    val colors = if(darkTheme) { customColorsDarkTheme } else { customColorsLightTheme }

    /**
     * We wrap material with our own app utils
     */
    ProvideAppUtils(
        customDimensions = dimensions,
        customTextUnits = textUnits,
        colors = colors,
        orientation = orientation,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}

/**
 * This helps us to get access to orientation and dimensions in runtime
 */
object AppTheme{
    val dimens : CustomDimensions
        @Composable
        get() = LocalAppDimens.current

    val textUnits: CustomTextUnits
        @Composable
        get() = LocalAppTextUnits.current

    val colorUnits: CustomColors
        @Composable
        get() = LocalColorSelection.current

    val orientation : Orientation
        @Composable
        get() = LocalOrientationMode.current
}
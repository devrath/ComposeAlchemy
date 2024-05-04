package com.yourcompany.android.toreadlist.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.Dp
import com.yourcompany.android.toreadlist.LocalColorsProvider
import com.yourcompany.android.toreadlist.LocalTypographyProvider

data class MyReadingPaddings(
  val small: Dp,
  val medium: Dp
)

object MyReadingTheme {
  val colors: MyReadingColors
    @Composable
    get() = LocalColorsProvider.current
  val typography: MyReadingTypography
    @Composable
    get() = LocalTypographyProvider.current
}

@Composable
fun ToReadListTheme(content: @Composable () -> Unit) {
  CompositionLocalProvider(
    LocalColorsProvider provides MyReadingColors(),
    LocalTypographyProvider provides MyReadingTypography()
  ) {
    MaterialTheme(
      colors = lightColors(
        primary = MyReadingTheme.colors.primary100,
        primaryVariant = MyReadingTheme.colors.primary90,
        secondary = MyReadingTheme.colors.secondary100,
        secondaryVariant = MyReadingTheme.colors.secondary90
      ),
      content = content
    )
  }
}
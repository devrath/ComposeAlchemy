package com.yourcompany.android.toreadlist

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yourcompany.android.toreadlist.ui.theme.MyReadingColors
import com.yourcompany.android.toreadlist.ui.theme.MyReadingPaddings
import com.yourcompany.android.toreadlist.ui.theme.MyReadingTypography

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController> { error("No navigation host controller provided.") }

val LocalColorsProvider = staticCompositionLocalOf { MyReadingColors() }

val LocalTypographyProvider = staticCompositionLocalOf { MyReadingTypography() }

val LocalPaddings = compositionLocalOf { MyReadingPaddings(small = 8.dp, medium = 16.dp) }
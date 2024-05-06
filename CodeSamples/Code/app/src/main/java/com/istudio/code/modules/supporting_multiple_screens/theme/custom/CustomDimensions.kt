package com.istudio.code.modules.supporting_multiple_screens.theme.custom

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CustomDimensions(
    val small:Dp,
    val smallMedium:Dp,
    val medium:Dp,
    val mediumLarge:Dp,
    val large:Dp
)

val smallCustomDimensions = CustomDimensions(
    small = 2.dp,
    smallMedium = 4.dp,
    medium = 6.dp,
    mediumLarge = 9.dp,
    large = 13.dp
)

val compactCustomDimensions = CustomDimensions(
    small = 3.dp,
    smallMedium = 5.dp,
    medium = 8.dp,
    mediumLarge = 11.dp,
    large = 15.dp
)

val mediumCustomDimensions = CustomDimensions(
    small = 5.dp,
    smallMedium = 7.dp,
    medium = 10.dp,
    mediumLarge = 13.dp,
    large = 18.dp
)

val largeCustomDimensions = CustomDimensions(
    small = 8.dp,
    smallMedium = 11.dp,
    medium = 15.dp,
    mediumLarge = 20.dp,
    large = 25.dp
)
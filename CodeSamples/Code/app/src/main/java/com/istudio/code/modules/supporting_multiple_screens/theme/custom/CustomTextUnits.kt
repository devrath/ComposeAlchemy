package com.istudio.code.modules.supporting_multiple_screens.theme.custom

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class CustomTextUnits(
    val small: TextUnit,
    val smallMedium: TextUnit,
    val medium: TextUnit,
    val mediumLarge: TextUnit,
    val large: TextUnit
)

val smallCustomTextUnits = CustomTextUnits(
    small = 12.sp,
    smallMedium = 14.sp,
    medium = 16.sp,
    mediumLarge = 18.sp,
    large = 20.sp
)

val compactCustomTextUnits = CustomTextUnits(
    small = 14.sp,
    smallMedium = 16.sp,
    medium = 18.sp,
    mediumLarge = 20.sp,
    large = 22.sp
)

val mediumCustomTextUnits = CustomTextUnits(
    small = 16.sp,
    smallMedium = 18.sp,
    medium = 20.sp,
    mediumLarge = 22.sp,
    large = 24.sp
)

val largeCustomTextUnits = CustomTextUnits(
    small = 18.sp,
    smallMedium = 20.sp,
    medium = 22.sp,
    mediumLarge = 24.sp,
    large = 26.sp
)

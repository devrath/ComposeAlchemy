package com.istudio.code.modules.app_foundations.theme.custom

import androidx.compose.ui.graphics.Color

data class CustomColors(
    val profileUserName : Color,
    val profileAddress : Color
)

val customColorsLightTheme = CustomColors(
    profileUserName = Color(0xFF000000),
    profileAddress = Color(0xFF00008B)
)

val customColorsDarkTheme = CustomColors(
    profileUserName = Color(0xFFFFFFFF),
    profileAddress = Color(0xFF00FFFF)
)
package com.istudio.code.utils

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.ui.Modifier

fun Modifier.setWidthMode(isFullWidth: Boolean): Modifier =
    if (isFullWidth) this.fillMaxWidth() else this.wrapContentWidth()

fun Modifier.setHeightMode(isFullWidth: Boolean): Modifier =
    if (isFullWidth) this.fillMaxHeight() else this.wrapContentHeight()
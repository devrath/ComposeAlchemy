package com.yourcompany.android.toreadlist.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.yourcompany.android.toreadlist.R

val ubuntuLight = FontFamily(
  Font(resId = R.font.ubuntu_light, style = FontStyle.Normal)
)

val ubuntuRegular = FontFamily(
  Font(resId = R.font.ubuntu_regular, style = FontStyle.Normal)
)

data class MyReadingTypography(
  val H5: TextStyle = TextStyle(
    fontFamily = ubuntuRegular,
    fontSize = 20.sp,
    lineHeight = 22.sp,
    fontWeight = FontWeight.Normal
  ),
  val subtitle: TextStyle = TextStyle(
    fontFamily = ubuntuLight,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    fontWeight = FontWeight.Normal
  )
)
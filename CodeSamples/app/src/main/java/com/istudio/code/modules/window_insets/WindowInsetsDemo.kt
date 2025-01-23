package com.istudio.code.modules.window_insets

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.ui.composables.AppButton

@Composable
fun WindowInsetsDemo(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.background(Color.Magenta).fillMaxSize()
    ) {

        val context = LocalContext.current

        Spacer(modifier = Modifier.height(16.dp))

        AppButton(text = "Click", onClick = {
        })

    }
}
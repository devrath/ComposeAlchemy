package com.istudio.code.modules.window_insets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.istudio.code.modules.app_foundations.helpers.rememberWindowSizeClass
import com.istudio.code.modules.app_foundations.theme.CustomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsetsDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = rememberWindowSizeClass()
            CustomTheme(window) {
                Column(
                    modifier = Modifier.background(Color.White)
                ) {
                    WindowInsetsDemo(
                        modifier = Modifier
                            .statusBarsPadding()
                            .navigationBarsPadding()
                            .safeGesturesPadding()
                            .safeDrawingPadding()
                    )
                }
                /*Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                }*/
            }
        }
    }
}

package com.istudio.code.modules.supporting_multiple_screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.istudio.code.modules.supporting_multiple_screens.theme.CustomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MultipleScreensSupportDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val window = windowSizeComposable()
            CustomTheme() {
                val navController = rememberNavController()
                SupportingMultipleScreensDemo(navController = navController)
            }
        }
    }
}

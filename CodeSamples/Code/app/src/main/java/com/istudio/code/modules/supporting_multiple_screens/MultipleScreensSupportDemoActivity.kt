package com.istudio.code.modules.supporting_multiple_screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation.compose.rememberNavController
import com.istudio.code.modules.supporting_multiple_screens.helpers.rememberWindowSizeClass
import com.istudio.code.modules.supporting_multiple_screens.theme.CustomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MultipleScreensSupportDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val window = rememberWindowSizeClass()
            CustomTheme(window) {
                val navController = rememberNavController()
                SupportingMultipleScreensDemo( navController = navController)
            }
        }
    }

}

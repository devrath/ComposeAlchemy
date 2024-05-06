package com.istudio.code.modules.app_foundations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.istudio.code.modules.app_foundations.helpers.rememberWindowSizeClass
import com.istudio.code.modules.app_foundations.theme.CustomTheme
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
package com.istudio.code.modules.basic_layouts.modules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.istudio.code.R
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun BoxDemo(navController: NavHostController) {
    BoxDemoScreen()
}

@Composable
fun BoxDemoScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd // We can put the alignment in the parent
        ) {
            // First Position = Image
            Image(
                painter = painterResource(R.drawable.pikachu),
                contentDescription = "Background Image"
            )
            // Second Position = Gradient on top of image
            Box(
                modifier = Modifier
                    .matchParentSize() // Special modifier that matches to the parent content
                    .background(
                        // We can add the gradient here
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Magenta)
                        )
                    )
            )
            // Third position = icon on top of both Image and Gradient
            Icon(
                modifier = Modifier.align(alignment = Alignment.BottomCenter),// Individually we can add the alignment
                imageVector = Icons.Default.Star,
                contentDescription = "Star"
            )
        }
    }

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme { BoxDemoScreen() }
}



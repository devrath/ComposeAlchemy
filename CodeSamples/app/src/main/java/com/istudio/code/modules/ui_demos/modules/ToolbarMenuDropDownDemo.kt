package com.istudio.code.modules.ui_demos.modules

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavHostController
import com.istudio.code.databinding.SimpleViewOneBinding
import com.istudio.code.databinding.SimpleViewOneBinding.inflate


@Composable
fun ToolbarMenuDropDownDemo(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val context = LocalContext.current
        // Using the xml with view binding in compose
        AndroidViewBinding(SimpleViewOneBinding::inflate) {
            demoButtonId.setOnClickListener {
                Toast.makeText(context,"Toolbar",Toast.LENGTH_LONG).show()
            }
        }
    }

}




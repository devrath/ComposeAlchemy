@file:OptIn(ExperimentalMaterial3Api::class)

package com.istudio.code.modules.ui_demos.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.istudio.code.R
import com.istudio.code.ui.composables.ToggleButtonComposable

@Composable
fun ToolbarMenuDropDownDemo(navController: NavHostController) {

    val menuItems = listOf(
        CustomMenuItem(icon = Icons.Default.Call, title = "Call"),
        CustomMenuItem(icon = Icons.Default.Build, title = "Build"),
        CustomMenuItem(icon = Icons.Default.DateRange, title = "Date Range")
    )

    var isAppIconVisible by rememberSaveable { mutableStateOf(true) }
    var isDropDownExpanded by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    CustomTopAppBarTitle(iconContent = {
                        if (isAppIconVisible) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_toolbar_icon),
                                contentDescription = "App Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    })
                },
                actions = {
                    Box {
                        DropdownMenu(
                            expanded = isDropDownExpanded,
                            onDismissRequest = { isDropDownExpanded = false }
                        ) {
                            menuItems.forEachIndexed { index, item ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clickable { isDropDownExpanded = false }
                                        .fillMaxWidth()
                                        .padding(5.dp)
                                ) {
                                    Icon(imageVector = item.icon, contentDescription = item.title)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = item.title)
                                }
                            }
                        }
                        IconButton(onClick = {
                            isDropDownExpanded = true
                        }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Open Menu",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            val context = LocalContext.current
            Text(text = "Screen Content")
            ToggleButtonComposable(
                isChecked = isAppIconVisible,
                onCheckedChange = { isAppIconVisible = it }
            )
        }
    }
}


@Composable
private fun CustomTopAppBarTitle(
    iconContent: (@Composable () -> Unit)? = null
) = Row {
    iconContent?.invoke()
    Spacer(modifier = Modifier.width(8.dp))
    Text(text = "Title")
}


data class CustomMenuItem(
    val icon: ImageVector,
    val title: String
)




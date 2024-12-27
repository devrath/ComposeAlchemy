package com.istudio.code.modules.state_basics.modules.number_guess_demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.istudio.code.ui.theme.CodeTheme

@Composable
fun NumberGuessDemoRoute(navController: NavHostController) {
    val viewModel = viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    NumberGuessDemoScreen(
        data = state,
        onAction = viewModel::onGuessAction, // Forwards all the action from the composable to the view model reference
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun NumberGuessDemoScreen(
    modifier: Modifier = Modifier,
    onAction: (NumberGuessAction) -> Unit,
    data: NumberGuessState
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = data.numberText,
            onValueChange = { newText ->
                onAction(NumberGuessAction.OnNumberTextChange(newText))
            }
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF
)
@Composable
private fun CurrentScreenPreview() {
    CodeTheme {
        NumberGuessDemoScreen(
            data = NumberGuessState(),
            onAction = {}
        )
    }
}



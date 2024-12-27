package com.istudio.code.modules.state_basics.modules.number_guess_demo

sealed interface NumberGuessAction {
    data object OnGuessClick : NumberGuessAction
    data class OnNumberTextChange(val numberText: String) : NumberGuessAction
    data object OnStartNewGameButtonClick: NumberGuessAction
}
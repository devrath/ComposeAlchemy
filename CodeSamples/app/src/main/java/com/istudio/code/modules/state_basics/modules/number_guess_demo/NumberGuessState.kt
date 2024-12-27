package com.istudio.code.modules.state_basics.modules.number_guess_demo

data class NumberGuessState(
    val numberText: String = "",
    val guessText: String? = "",
    val isGuessCorrect: Boolean = false
)

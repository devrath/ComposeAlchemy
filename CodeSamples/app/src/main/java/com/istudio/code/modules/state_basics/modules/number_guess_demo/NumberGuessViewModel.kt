package com.istudio.code.modules.state_basics.modules.number_guess_demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NumberGuessViewModel : ViewModel() {

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    fun onGuessAction(action: NumberGuessAction){
        when(action){
            is NumberGuessAction.OnGuessClick -> {

            }
            is NumberGuessAction.OnNumberTextChange -> {
                _state.update {
                    it.copy(numberText = action.numberText)
                }
            }
            is NumberGuessAction.OnStartNewGameButtonClick -> {

            }
        }
    }

}
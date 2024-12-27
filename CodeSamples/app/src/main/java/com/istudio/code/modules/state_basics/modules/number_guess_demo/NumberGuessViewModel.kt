package com.istudio.code.modules.state_basics.modules.number_guess_demo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NumberGuessViewModel : ViewModel() {

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

}
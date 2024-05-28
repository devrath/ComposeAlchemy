package com.istudio.code.modules.pagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.istudio.code.modules.pagination.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotesDemoViewModel @Inject constructor(
    repository : QuoteRepository
) : ViewModel() {

    val list = repository.getQuotes().cachedIn(viewModelScope)

}
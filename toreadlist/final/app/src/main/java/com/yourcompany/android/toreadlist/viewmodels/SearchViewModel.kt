package com.yourcompany.android.toreadlist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourcompany.android.toreadlist.models.Book
import com.yourcompany.android.toreadlist.models.NetworkResponse
import com.yourcompany.android.toreadlist.models.SearchState
import com.yourcompany.android.toreadlist.models.SearchUiState
import com.yourcompany.android.toreadlist.repositories.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
  private val bookRepository: BookRepository
) : ViewModel() {

  private val _searchUiState = MutableStateFlow(SearchUiState())
  val searchUiState: Flow<SearchUiState>
    get() = _searchUiState

  fun search(query: String) {
    viewModelScope.launch {
      bookRepository
        .search(query)
        .collect { response ->
          when (response) {
            is NetworkResponse.Success -> {
              _searchUiState.emit(
                SearchUiState(
                  state = SearchState.DONE,
                  searchResult = response.result ?: emptyList())
              )
            }
            NetworkResponse.Loading -> _searchUiState.emit(SearchUiState(SearchState.LOADING))
            is NetworkResponse.Error -> {}
          }
        }
    }
  }

  fun addToList(book: Book) {
    viewModelScope.launch {
      bookRepository.addBook(book)
    }
  }

  fun clearResults() {
    _searchUiState.value = _searchUiState.value.copy(searchResult = emptyList())
  }
}
package com.yourcompany.android.toreadlist.models

data class SearchUiState(
  val state: SearchState = SearchState.NONE,
  val searchResult: List<Book> = emptyList()
)

enum class SearchState {
  DONE, ERROR, LOADING, NONE
}

/*
 * Copyright (c) 2022 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
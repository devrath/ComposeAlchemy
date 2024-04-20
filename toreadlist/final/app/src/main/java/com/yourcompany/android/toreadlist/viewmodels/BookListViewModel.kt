package com.yourcompany.android.toreadlist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourcompany.android.toreadlist.models.Book
import com.yourcompany.android.toreadlist.repositories.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
  private val bookRepository: BookRepository
) : ViewModel() {

  private val _bookList = MutableStateFlow(emptyList<Book>())
  val bookList: Flow<List<Book>>
    get() = _bookList

  fun getBookList() {
    viewModelScope.launch {
      bookRepository
        .getBookList()
        .collect { _bookList.value = it }
    }
  }
}

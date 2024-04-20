package com.yourcompany.android.toreadlist.repositories

import com.yourcompany.android.toreadlist.models.Book
import com.yourcompany.android.toreadlist.models.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface BookRepository {
  fun search(query: String): Flow<NetworkResponse<List<Book>>>

  suspend fun addBook(book: Book)

  fun getBookList(): Flow<List<Book>>
}
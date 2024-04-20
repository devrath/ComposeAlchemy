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
package com.yourcompany.android.toreadlist.repositories

import com.yourcompany.android.toreadlist.models.Book
import com.yourcompany.android.toreadlist.models.NetworkResponse
import com.yourcompany.android.toreadlist.network.service.BookService
import com.yourcompany.android.toreadlist.storage.BookDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
  private val bookService: BookService,
  private val bookDataSource: BookDataSource
) : BookRepository {
  override fun search(query: String) = flow {
    emit(NetworkResponse.Loading)
    val response = bookService.search(query)
    if (response.isSuccessful && response.body() != null) {
      emit(NetworkResponse.Success(
        result = response.body()?.books?.map {
          Book(
            author = if (it.authors?.isNotEmpty() == true) it.authors[0] else "",
            title = it.title,
            coverId = it.coverId
          )
        } ?: emptyList())
      )
    }
  }
  .catch { emit(NetworkResponse.Error(it)) }
  .flowOn(Dispatchers.IO)

  override fun getBookList(): Flow<List<Book>> = bookDataSource.books

  override suspend fun addBook(book: Book) {
    bookDataSource.addBook(book)
  }
}

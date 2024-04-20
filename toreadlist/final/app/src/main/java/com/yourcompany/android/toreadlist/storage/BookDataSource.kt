package com.yourcompany.android.toreadlist.storage

import com.yourcompany.android.toreadlist.models.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface BookDataSource {
  val books: Flow<List<Book>>

  suspend fun addBook(book: Book)
}

class BookDataSourceImpl @Inject constructor(
  private val booksDao: BookDao
) : BookDataSource {

  override val books: Flow<List<Book>> = booksDao
    .getBooks()
    .map { list ->
      list.map { Book(title = it.title, author = it.author, coverId = it.coverId) }
    }

  override suspend fun addBook(book: Book) {
    val bookEntity = BookEntity(
      title = book.title,
      author = book.author,
      coverId = book.coverId
    )
    booksDao.insertBook(bookEntity)
  }
}
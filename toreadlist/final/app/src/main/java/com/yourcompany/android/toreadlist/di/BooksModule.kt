package com.yourcompany.android.toreadlist.di

import android.content.Context
import androidx.room.Room
import com.yourcompany.android.toreadlist.network.service.BookService
import com.yourcompany.android.toreadlist.repositories.BookRepository
import com.yourcompany.android.toreadlist.repositories.BookRepositoryImpl
import com.yourcompany.android.toreadlist.storage.BookDao
import com.yourcompany.android.toreadlist.storage.BookDataSource
import com.yourcompany.android.toreadlist.storage.BookDataSourceImpl
import com.yourcompany.android.toreadlist.storage.BooksDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object BooksModule {
  @Provides
  fun provideBookService(): BookService {
    return Retrofit.Builder()
      .baseUrl("https://openlibrary.org/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(BookService::class.java)
  }

  @Provides
  fun provideDatabase(@ApplicationContext context: Context): BooksDatabase =
    Room.databaseBuilder(context, BooksDatabase::class.java, "books-db").build()

  @Provides
  fun provideBookDao(database: BooksDatabase): BookDao = database.booksDao()
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class BooksAbstractModule {
  @Binds
  abstract fun bindBookDataSource(dataSource: BookDataSourceImpl): BookDataSource

  @Binds
  abstract fun bindBookRepository(bookRepository: BookRepositoryImpl): BookRepository
}

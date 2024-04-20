package com.yourcompany.android.toreadlist.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

  @Query("SELECT * FROM books")
  fun getBooks(): Flow<List<BookEntity>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertBook(book: BookEntity)
}
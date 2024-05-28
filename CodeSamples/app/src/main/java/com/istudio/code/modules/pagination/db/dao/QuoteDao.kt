package com.istudio.code.modules.pagination.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.istudio.code.modules.pagination.models.Result

@Dao
interface QuoteDao {

    /**
     * With the query satisfied, We will get the records from the database. from quote table and return in the form of pages
     * Now how many records does each page have, We need to define a paging config for this
     */
    @Query("SELECT * FROM quote")
    fun getQuotes(): PagingSource<Int, Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotes(quotes: List<Result>)

    @Query("DELETE FROM quote")
    suspend fun deleteQuotes()

}
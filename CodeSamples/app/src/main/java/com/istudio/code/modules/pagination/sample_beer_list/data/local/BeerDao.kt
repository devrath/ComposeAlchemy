package com.istudio.code.modules.pagination.sample_beer_list.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface BeerDao {

    @Upsert
    suspend fun upsertAll(beers: List<BeerEntity>)

    /**
     * PagingSource that returns a list of beers.
     * * It accepts <Int,BeerEntity>
     * * Int is the page number
     * * BeerEntity is the item type that you return in each page(Each page consists of bunch of beer entities)
     */
    @Query("SELECT * FROM beerentity")
    fun pagingSource(): PagingSource<Int, BeerEntity>

    @Query("DELETE FROM beerentity")
    suspend fun clearAll()
}
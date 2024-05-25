package com.istudio.code.modules.pagination.sample_beer_list.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.istudio.code.modules.pagination.sample_beer_list.data.local.BeerDatabase
import com.istudio.code.modules.pagination.sample_beer_list.data.local.BeerEntity
import com.istudio.code.modules.pagination.sample_beer_list.data.mappers.toBeerEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(
    private val beerDb: BeerDatabase,
    private val beerApi: BeerApi
) : RemoteMediator<Int, BeerEntity>() {
    /**
     * Load function is called everytime when there is some form of pagination
     * LoadType.REFRESH :-> We are loading because the whole list is going to be refreshed from the beginning
     * LoadType.APPEND  :-> We are loading because we are going to load(append) more items
     *
     */
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeerEntity>
    ): MediatorResult {
        /**
         * We return a MediatorResult :-> It can be either a success or an error
         *
         */
        return try {

            // We need to formulate the current key which is the page.
            val loadKey = when (loadType) {
                LoadType.REFRESH -> {
                    // We return "1" because since we refresh, we need to get the first page
                    1
                }
                LoadType.PREPEND -> {
                    // Currently we are not prepending anything
                    return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                }

                LoadType.APPEND -> {
                    // We need to calculate the next page we want to load.
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        // If its null then we say its the first item to return so we return "1"
                        1
                    } else {
                        // Else have your custom logic here
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val beers = beerApi.getBeers(
                page = loadKey,
                pageCount = state.config.pageSize
            )

            // WithTransaction ensures either all the queries are successful or none of them.
            beerDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    beerDb.dao.clearAll()
                }
                val beerEntities = beers.map { it.toBeerEntity() }
                beerDb.dao.upsertAll(beerEntities)
            }

            // This indicates we reached to end of the pagination since for passed page there are no new items
            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}
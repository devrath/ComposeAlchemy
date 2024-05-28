package com.istudio.code.modules.pagination.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.istudio.code.modules.pagination.db.database.QuoteDatabase
import com.istudio.code.modules.pagination.models.QuoteRemoteKeys
import java.lang.Exception
import com.istudio.code.modules.pagination.models.Result
import com.istudio.code.modules.pagination.retrofit.QuoteAPI

@ExperimentalPagingApi
class QuoteRemoteMediator(
    private val quoteAPI: QuoteAPI,
    private val quoteDatabase: QuoteDatabase
) : RemoteMediator<Int, Result>() {

    val quoteDao = quoteDatabase.quoteDao()
    val quoteRemoteKeysDao = quoteDatabase.remoteKeysDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Result>): MediatorResult {
        return try {

            // <-------> Logic for states REFRESH , PREPEND , APPEND <------->
            // This will return 1,2,3,4 .... And So on ....
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    // If null we return first page else we return a current page (By minus the next page)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            // <-------> Fetching data from the API <------->
            val response = quoteAPI.getQuotes(currentPage)
            val endOfPaginationReached = response.totalPages == currentPage

            // Get previous page and next page number
            val prevPage = if(currentPage == 1) null else currentPage -1
            val nextPage = if(endOfPaginationReached) null else currentPage + 1

            quoteDatabase.withTransaction {

                // If refresh its probably the first page
                if (loadType == LoadType.REFRESH) {
                    // Delete all previous quotes
                    quoteDao.deleteQuotes()
                    // Delete all previous remote keys
                    quoteRemoteKeysDao.deleteAllRemoteKeys()
                }

                val keys = response.results.map { quote ->
                    QuoteRemoteKeys(
                        id = quote._id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }

                // Add quotes to database
                quoteDao.addQuotes(response.results)
                // Add remote keys to database
                quoteRemoteKeysDao.addAllRemoteKeys(keys)
            }
            MediatorResult.Success(endOfPaginationReached)
        }
        catch (e: Exception){
            MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Result>
    ): QuoteRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?._id?.let { id ->
                quoteRemoteKeysDao.getRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Result>
    ): QuoteRemoteKeys? {
        // Idea is to get the first page and in addition get the first record of that page
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { quote ->
                // -> If the control reaches here then there can be a previous page
                quoteRemoteKeysDao.getRemoteKeys(id = quote._id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Result>
    ): QuoteRemoteKeys? {
        // Idea is to get the last page and in addition get the last record of that page
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { quote ->
                // -> If the control reaches here then there can be a next page
                quoteRemoteKeysDao.getRemoteKeys(id = quote._id)
            }
    }
}
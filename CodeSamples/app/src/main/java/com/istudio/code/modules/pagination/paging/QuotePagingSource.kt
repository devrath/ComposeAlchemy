package com.istudio.code.modules.pagination.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.istudio.code.modules.pagination.models.Result
import com.istudio.code.modules.pagination.retrofit.QuoteAPI
import java.lang.Exception

/**
 * In the paging source, We define how to load the data from the API.
 * *************
 * PagingSource<Int, Result>
 * <*> First Param: The type of the key used to load the data.
 * URL: https://quotable.io/quotes?page=2
 * Here the value `2` is the key used to load the data which is integer type
 * <*> Second Param: The type is the base response data which we will receive from the API.
 */
class QuotePagingSource(private val quoteAPI: QuoteAPI) : PagingSource<Int, Result>() {

    /**
     * OBJECTIVE: In this method we will load the data from the API.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        // Params contains the information on what page to load next
        return try {
            // Determine the page number: When we do not have the `key`(It will be null) in the param, So we load the first page
            val position = params.key ?: 1
            val response = quoteAPI.getQuotes(position)

            // Load the page
            return LoadResult.Page(
                // Define the current data
                data = response.results,
                // <---> Define the previous page key <--->
                // If the position = 1 ==> This indicates ths there is no previous page
                // If the position > 1 ==> This indicates that there is a previous page (position - 1)
                prevKey = if (position == 1) null else position - 1,
                // <---> Define the next page key <--->
                // If the position = totalPages ==> This indicates that there is no next page
                // If the position < totalPages ==> This indicates that there is a next page (position + 1)
                nextKey = if (position == response.totalPages) null else position + 1
            )

        } catch (e: Exception) {
            // Load the error
            LoadResult.Error(e)
        }
    }

    /**
     * OBJECTIVE: This function will help us telling which page to load next.
     * Based on the anchor position we determine which page to load next
     * ******
     * Basically the anchor position maintains the current position of the page.
     */
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            // When we pass the anchor position the `closestPageToPosition` function it will get you the closest page to that position
            val anchorPage = state.closestPageToPosition(anchorPosition)
            // Once we have the anchor position, We will see the previous key or next key of the page
            // Here we are checking if the current page has a previous key ==> If previous key is not there then check the next key
            // If the current page has a next key ==> If next key is not there then check the previous key
            // ----> If none of the key is there then return null --> In such case it will get the first page
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}
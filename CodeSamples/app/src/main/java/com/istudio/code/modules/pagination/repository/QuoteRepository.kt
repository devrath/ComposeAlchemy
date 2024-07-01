package com.istudio.code.modules.pagination.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.istudio.code.modules.pagination.db.database.QuoteDatabase
import com.istudio.code.modules.pagination.models.Result
import com.istudio.code.modules.pagination.paging.QuoteRemoteMediator
import com.istudio.code.modules.pagination.retrofit.QuoteAPI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class QuoteRepository @Inject constructor(
    private val quoteAPI: QuoteAPI,
    private val quoteDatabase: QuoteDatabase
) {
    fun getQuotes(): Flow<PagingData<Result>> = Pager(
        config = PagingConfig(
            pageSize = 10, maxSize = 100
        ),
        remoteMediator = QuoteRemoteMediator(quoteAPI, quoteDatabase),
        pagingSourceFactory = { quoteDatabase.quoteDao().getQuotes() }
    ).flow
}
package com.istudio.code.modules.pagination.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.istudio.code.modules.pagination.models.Result
import com.istudio.code.modules.pagination.paging.QuotePagingSource
import com.istudio.code.modules.pagination.retrofit.QuoteAPI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteAPI: QuoteAPI) {
    fun getQuotes(): Flow<PagingData<Result>> = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource(quoteAPI) }
    ).flow
}
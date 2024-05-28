package com.istudio.code.modules.pagination.retrofit

import com.istudio.code.modules.pagination.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): QuoteList
}
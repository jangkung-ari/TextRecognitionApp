package com.arimukti.qasirqu.data.repository.datasource

import com.arimukti.qasirqu.data.model.ApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int, category: String): Response<ApiResponse>
    suspend fun getSearchedNews(
        country: String,
        page: Int,
        searchQuery: String,
        category: String
    ): Response<ApiResponse>
}
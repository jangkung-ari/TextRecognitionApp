package com.arimukti.qasirqu.data.repository.datasourceImpl

import com.arimukti.qasirqu.data.api.NewsApiService
import com.arimukti.qasirqu.data.model.ApiResponse
import com.arimukti.qasirqu.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val apiService: NewsApiService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(
        country: String,
        page: Int,
        category: String
    ): Response<ApiResponse> {
        return apiService.getTopHeadlines(country,category,page)
    }

    override suspend fun getSearchedNews(
        country: String,
        page: Int,
        searchQuery: String,
        category: String
    ): Response<ApiResponse> {
        return apiService.getSearchedTopHeadlines(country, searchQuery, category, page)
    }
}
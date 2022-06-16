package com.arimukti.qasirqu.domain.repository

import com.arimukti.qasirqu.data.model.ApiResponse
import com.arimukti.qasirqu.data.model.Article
import com.arimukti.qasirqu.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(
        country: String,
        page: Int,
        category: String
    ): Resource<ApiResponse>

    suspend fun getSearchedNews(
        country: String,
        page: Int,
        category: String,
        searchQuery: String
    ): Resource<ApiResponse>

    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>

}
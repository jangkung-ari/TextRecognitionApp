package com.arimukti.textrecognitionapp.domain.repository

import com.arimukti.textrecognitionapp.data.model.*
import com.arimukti.textrecognitionapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface AppRepository {

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

    suspend fun login(
        username: String,
        password: String
    ): Resource<LoginResponse>

    suspend fun signUp(signUpReq: SignUpRequest): Resource<SignUpResponse>

    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}
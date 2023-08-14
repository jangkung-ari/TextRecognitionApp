package com.arimukti.textrecognitionapp.data.repository.datasourceImpl

import com.arimukti.textrecognitionapp.data.api.ApiService
import com.arimukti.textrecognitionapp.data.model.*
import com.arimukti.textrecognitionapp.data.repository.datasource.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(
    private val apiService: ApiService,
) : RemoteDataSource {

    override suspend fun getTopHeadlines(
        country: String,
        page: Int,
        category: String
    ): Response<ApiResponse> {
        return apiService.getTopHeadlines(country,category,page)
    }

    override suspend fun login(username: String, password: String): Response<LoginResponse> {
        return apiService.login(LoginRequest(username, password))
    }

    override suspend fun signUp(signUpRequest: SignUpRequest): Response<SignUpResponse> {
        return apiService.signUp(signUpRequest)
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
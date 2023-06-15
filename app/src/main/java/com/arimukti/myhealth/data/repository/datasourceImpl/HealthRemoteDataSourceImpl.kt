package com.arimukti.myhealth.data.repository.datasourceImpl

import com.arimukti.myhealth.data.api.HealthApiService
import com.arimukti.myhealth.data.model.*
import com.arimukti.myhealth.data.repository.datasource.HealthRemoteDataSource
import retrofit2.Response

class HealthRemoteDataSourceImpl(
    private val apiService: HealthApiService,
) : HealthRemoteDataSource {

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
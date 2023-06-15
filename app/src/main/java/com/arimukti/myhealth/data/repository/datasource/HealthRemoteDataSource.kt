package com.arimukti.myhealth.data.repository.datasource

import com.arimukti.myhealth.data.model.ApiResponse
import com.arimukti.myhealth.data.model.LoginResponse
import com.arimukti.myhealth.data.model.SignUpRequest
import com.arimukti.myhealth.data.model.SignUpResponse
import retrofit2.Response

interface HealthRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int, category: String): Response<ApiResponse>
    suspend fun login(username: String, password: String): Response<LoginResponse>
    suspend fun signUp(signUpRequest: SignUpRequest): Response<SignUpResponse>
    suspend fun getSearchedNews(
        country: String,
        page: Int,
        searchQuery: String,
        category: String
    ): Response<ApiResponse>
}
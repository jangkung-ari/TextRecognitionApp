package com.arimukti.textrecognitionapp.data.repository.datasource

import com.arimukti.textrecognitionapp.data.model.ApiResponse
import com.arimukti.textrecognitionapp.data.model.LoginResponse
import com.arimukti.textrecognitionapp.data.model.SignUpRequest
import com.arimukti.textrecognitionapp.data.model.SignUpResponse
import retrofit2.Response

interface RemoteDataSource {
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
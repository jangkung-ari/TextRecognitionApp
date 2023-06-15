package com.arimukti.myhealth.data.repository

import com.arimukti.myhealth.data.model.*
import com.arimukti.myhealth.data.repository.datasource.HealthLocalDataSource
import com.arimukti.myhealth.data.repository.datasource.HealthRemoteDataSource
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.domain.repository.MyHealthRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MyHealthRepositoryImpl(
    private val remoteDataSource: HealthRemoteDataSource,
    private val healthLocalDataSource: HealthLocalDataSource
) : MyHealthRepository {

    override suspend fun getNewsHeadlines(
        country: String,
        page: Int,
        category: String
    ): Resource<ApiResponse> {
        return responseToResult(remoteDataSource.getTopHeadlines(country, page, category))
    }

    override suspend fun getSearchedNews(
        country: String,
        page: Int,
        category: String,
        searchQuery: String
    ): Resource<ApiResponse> {
        return responseToResult(
            remoteDataSource.getSearchedNews(
                country,
                page,
                searchQuery,
                category
            )
        )
    }

    override suspend fun login(username: String, password: String): Resource<LoginResponse> {
        return responseLoginToResult(remoteDataSource.login(username, password))
    }

    override suspend fun signUp(signUpReq: SignUpRequest): Resource<SignUpResponse> {
        return responseSignUpToResult(remoteDataSource.signUp(signUpReq))
    }

    private fun responseToResult(response: Response<ApiResponse>): Resource<ApiResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseLoginToResult(response: Response<LoginResponse>): Resource<LoginResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseSignUpToResult(response: Response<SignUpResponse>): Resource<SignUpResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
        healthLocalDataSource.saveArticleToDb(article)
    }

    override suspend fun deleteNews(article: Article) {
        healthLocalDataSource.deleteArticlesFromDb(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return healthLocalDataSource.getSavedArticles()
    }
}

















package com.arimukti.textrecognitionapp.data.repository

import com.arimukti.textrecognitionapp.data.model.*
import com.arimukti.textrecognitionapp.data.repository.datasource.AppLocalDataSource
import com.arimukti.textrecognitionapp.data.repository.datasource.RemoteDataSource
import com.arimukti.textrecognitionapp.data.util.Resource
import com.arimukti.textrecognitionapp.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val appLocalDataSource: AppLocalDataSource
) : AppRepository {

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
        appLocalDataSource.saveArticleToDb(article)
    }

    override suspend fun deleteNews(article: Article) {
        appLocalDataSource.deleteArticlesFromDb(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return appLocalDataSource.getSavedArticles()
    }
}

















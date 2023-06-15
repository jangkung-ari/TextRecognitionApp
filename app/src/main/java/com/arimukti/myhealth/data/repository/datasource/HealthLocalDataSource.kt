package com.arimukti.myhealth.data.repository.datasource

import com.arimukti.myhealth.data.model.Article
import kotlinx.coroutines.flow.Flow

interface HealthLocalDataSource {
    suspend fun saveArticleToDb(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun deleteArticlesFromDb(article: Article)
}
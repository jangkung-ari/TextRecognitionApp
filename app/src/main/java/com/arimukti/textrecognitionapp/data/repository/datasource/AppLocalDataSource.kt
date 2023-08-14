package com.arimukti.textrecognitionapp.data.repository.datasource

import com.arimukti.textrecognitionapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface AppLocalDataSource {
    suspend fun saveArticleToDb(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun deleteArticlesFromDb(article: Article)
}
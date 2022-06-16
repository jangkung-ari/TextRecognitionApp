package com.arimukti.qasirqu.data.repository.datasource

import com.arimukti.qasirqu.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticleToDb(article: Article)
    fun getSavedArticles() : Flow<List<Article>>
    suspend fun deleteArticlesFromDb(article: Article)
}
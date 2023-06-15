package com.arimukti.myhealth.data.repository.datasourceImpl

import com.arimukti.myhealth.data.db.ArticleDao
import com.arimukti.myhealth.data.model.Article
import com.arimukti.myhealth.data.repository.datasource.HealthLocalDataSource
import kotlinx.coroutines.flow.Flow

class HealthLocalDataSourceImpl(private val articleDao: ArticleDao) : HealthLocalDataSource {
    override suspend fun saveArticleToDb(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticlesFromDb(article: Article) {
        articleDao.delete(article)
    }
}
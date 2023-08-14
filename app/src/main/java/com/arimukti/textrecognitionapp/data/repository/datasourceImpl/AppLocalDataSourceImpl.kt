package com.arimukti.textrecognitionapp.data.repository.datasourceImpl

import com.arimukti.textrecognitionapp.data.db.ArticleDao
import com.arimukti.textrecognitionapp.data.model.Article
import com.arimukti.textrecognitionapp.data.repository.datasource.AppLocalDataSource
import kotlinx.coroutines.flow.Flow

class AppLocalDataSourceImpl(private val articleDao: ArticleDao) : AppLocalDataSource {
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
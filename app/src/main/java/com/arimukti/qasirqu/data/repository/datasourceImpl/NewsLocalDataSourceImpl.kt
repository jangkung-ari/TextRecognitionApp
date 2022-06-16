package com.arimukti.qasirqu.data.repository.datasourceImpl

import com.arimukti.qasirqu.data.db.ArticleDao
import com.arimukti.qasirqu.data.model.Article
import com.arimukti.qasirqu.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao: ArticleDao) : NewsLocalDataSource {
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
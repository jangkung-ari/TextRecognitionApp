package com.arimukti.qasirqu.presentation.di

import com.arimukti.qasirqu.data.db.ArticleDao
import com.arimukti.qasirqu.data.repository.datasource.NewsLocalDataSource
import com.arimukti.qasirqu.data.repository.datasourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }
}
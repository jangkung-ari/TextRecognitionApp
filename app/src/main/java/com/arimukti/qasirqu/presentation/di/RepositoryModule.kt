package com.arimukti.qasirqu.presentation.di

import com.arimukti.qasirqu.data.repository.NewsRepositoryImpl
import com.arimukti.qasirqu.data.repository.datasource.NewsLocalDataSource
import com.arimukti.qasirqu.data.repository.datasource.NewsRemoteDataSource
import com.arimukti.qasirqu.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}
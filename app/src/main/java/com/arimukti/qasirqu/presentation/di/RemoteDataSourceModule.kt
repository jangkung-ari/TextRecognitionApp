package com.arimukti.qasirqu.presentation.di

import com.arimukti.qasirqu.data.api.NewsApiService
import com.arimukti.qasirqu.data.repository.datasource.NewsRemoteDataSource
import com.arimukti.qasirqu.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsApiService: NewsApiService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }

}
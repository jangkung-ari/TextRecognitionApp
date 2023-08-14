package com.arimukti.textrecognitionapp.di

import com.arimukti.textrecognitionapp.data.db.ArticleDao
import com.arimukti.textrecognitionapp.data.repository.datasource.AppLocalDataSource
import com.arimukti.textrecognitionapp.data.repository.datasourceImpl.AppLocalDataSourceImpl
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
    fun provideLocalDataSource(articleDao: ArticleDao): AppLocalDataSource {
        return AppLocalDataSourceImpl(articleDao)
    }
}
package com.arimukti.myhealth.presentation.di

import com.arimukti.myhealth.data.db.ArticleDao
import com.arimukti.myhealth.data.repository.datasource.HealthLocalDataSource
import com.arimukti.myhealth.data.repository.datasourceImpl.HealthLocalDataSourceImpl
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
    fun provideLocalDataSource(articleDao: ArticleDao): HealthLocalDataSource {
        return HealthLocalDataSourceImpl(articleDao)
    }
}
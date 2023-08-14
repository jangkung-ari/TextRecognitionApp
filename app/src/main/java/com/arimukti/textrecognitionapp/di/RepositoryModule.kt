package com.arimukti.textrecognitionapp.di

import com.arimukti.textrecognitionapp.data.repository.AppRepositoryImpl
import com.arimukti.textrecognitionapp.data.repository.datasource.AppLocalDataSource
import com.arimukti.textrecognitionapp.data.repository.datasource.RemoteDataSource
import com.arimukti.textrecognitionapp.domain.repository.AppRepository
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
    fun providesRepository(
        remoteDataSource: RemoteDataSource,
        appLocalDataSource: AppLocalDataSource
    ): AppRepository {
        return AppRepositoryImpl(remoteDataSource, appLocalDataSource)
    }
}
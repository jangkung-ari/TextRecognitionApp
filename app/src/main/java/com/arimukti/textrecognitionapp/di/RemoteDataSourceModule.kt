package com.arimukti.textrecognitionapp.di

import com.arimukti.textrecognitionapp.data.api.ApiService
import com.arimukti.textrecognitionapp.data.repository.datasource.RemoteDataSource
import com.arimukti.textrecognitionapp.data.repository.datasourceImpl.RemoteDataSourceImpl
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
    fun provideAppRemoteDataSource(healthApiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(healthApiService)
    }

}
package com.arimukti.myhealth.di

import com.arimukti.myhealth.data.api.HealthApiService
import com.arimukti.myhealth.data.repository.datasource.HealthRemoteDataSource
import com.arimukti.myhealth.data.repository.datasourceImpl.HealthRemoteDataSourceImpl
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
    fun provideHealthRemoteDataSource(healthApiService: HealthApiService): HealthRemoteDataSource {
        return HealthRemoteDataSourceImpl(healthApiService)
    }

}
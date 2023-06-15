package com.arimukti.myhealth.presentation.di

import com.arimukti.myhealth.data.repository.MyHealthRepositoryImpl
import com.arimukti.myhealth.data.repository.datasource.HealthLocalDataSource
import com.arimukti.myhealth.data.repository.datasource.HealthRemoteDataSource
import com.arimukti.myhealth.domain.repository.MyHealthRepository
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
    fun providesMyHealthRepository(
        healthRemoteDataSource: HealthRemoteDataSource,
        healthLocalDataSource: HealthLocalDataSource
    ): MyHealthRepository {
        return MyHealthRepositoryImpl(healthRemoteDataSource, healthLocalDataSource)
    }
}
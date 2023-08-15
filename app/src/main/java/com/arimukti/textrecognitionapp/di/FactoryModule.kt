package com.arimukti.textrecognitionapp.di

import android.app.Application
import com.arimukti.textrecognitionapp.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideMainViewModelFactory(
        application: Application
    ): MainViewModelFactory {
        return MainViewModelFactory(
            application
        )
    }
}
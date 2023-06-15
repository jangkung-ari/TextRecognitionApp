package com.arimukti.myhealth.presentation.di

import com.arimukti.myhealth.presentation.adapter.SavedNewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SavedNewsAdapterModule {
    @Singleton
    @Provides
    fun provideSavedNewsAdapter(): SavedNewsAdapter {
        return SavedNewsAdapter()
    }

}
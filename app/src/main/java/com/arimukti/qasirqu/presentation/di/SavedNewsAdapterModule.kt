package com.arimukti.qasirqu.presentation.di

import com.arimukti.qasirqu.presentation.adapter.SavedNewsAdapter
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